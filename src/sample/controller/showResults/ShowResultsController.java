package sample.controller.showResults;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import ir.behinehsazan.gasStation.model.burner.Burner;
import ir.behinehsazan.gasStation.model.heater.Heater;
import ir.behinehsazan.gasStation.model.heater.Heaters;
import ir.behinehsazan.gasStation.model.pipeLine.base.BasePipe;
import ir.behinehsazan.gasStation.model.regulator.Regulator;
import ir.behinehsazan.gasStation.model.run.Runs;
import ir.behinehsazan.gasStation.model.run.base.BaseRun;
import ir.behinehsazan.gasStation.model.station.StationLogic;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import sample.model.Station;
import sample.model.showResultEntity.Table;
import sample.model.stationProperties.StationPropertice;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicLong;

public class ShowResultsController implements Initializable {


    public TextField textField2;
    public GridPane gridPane;
    @FXML
    TableView<Table> tableID;
    @FXML
    TableColumn<Table, String> name;
    @FXML
    TableColumn<Table, String> value;

    //    public TableView table;
    @FXML
    TextField textField = new TextField();


    public static ObservableList<Table> getData() {
        return data;
    }

    static final ObservableList<Table> data = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {


        name.setCellValueFactory(new PropertyValueFactory<Table, String>("name"));
        value.setCellValueFactory(new PropertyValueFactory<Table, String>("value"));
//        showResult();
        tableID.setItems(data);
        tableID.setColumnResizePolicy((param) -> true);
        Platform.runLater(() -> customResize(tableID));
        name.prefWidthProperty().bind(tableID.widthProperty().divide(2));
        value.prefWidthProperty().bind(tableID.widthProperty().divide(2));
//        showResult();

    }


//    @FXML
//    public void initialize() throws IOException{
//        try {
//
//
//        }
//        catch(Exception e){
//            e.printStackTrace();
//        }
//    }


//    @FXML
//    public void initialize() throws IOException {
//
//
//
//    }


    public static void showResult() {
        data.clear();

        StationLogic stationLogic = Station.getInstance().getStationLogic();
        StationPropertice stationPropertice = (StationPropertice) Station.getInstance().getList().get("stationPropertice");
        if (stationPropertice != null) {
            data.add(new Table("استان", stationPropertice.getProvince()));
            data.add(new Table("شهر", stationPropertice.getCity()));
            data.add(new Table("منطقه", stationPropertice.getArea()));
            data.add(new Table("آدرس", stationPropertice.getAddress()));
            data.add(new Table("ظرفیت نامی", stationPropertice.getNominalCapacity()));
            data.add(new Table("دمای محیط", String.valueOf(stationPropertice.getEnvironmentTemp())));
            data.add(new Table("سرعت باد", String.valueOf(stationPropertice.getWindVelocity())));
            data.add(new Table("دمای گاز ورودی به ایستگاه", String.valueOf(stationPropertice.getInputTemp())));
            data.add(new Table("فشار گاز ورودی به ایستگاه", String.valueOf(stationPropertice.getInputPressure())));
            data.add(new Table("دمای گاز خروجی از ایستگاه", String.valueOf(stationPropertice.getOutputTemp())));
            data.add(new Table("فشار گاز خروجی از ایستگاه", String.valueOf(stationPropertice.getOutputPressure())));
            data.add(new Table("دبی عبوری از ایستگاه", String.valueOf(stationPropertice.getDebi())));
            data.add(new Table("نیتروژن", String.valueOf(stationPropertice.getComponent()[0])));
            data.add(new Table("دی اکسید کربن", String.valueOf(stationPropertice.getComponent()[1])));
            data.add(new Table("متان", String.valueOf(stationPropertice.getComponent()[2])));
            data.add(new Table("اتان", String.valueOf(stationPropertice.getComponent()[3])));
            data.add(new Table("پروپان", String.valueOf(stationPropertice.getComponent()[4])));
            data.add(new Table("نرمال بوتان", String.valueOf(stationPropertice.getComponent()[5])));
            data.add(new Table("ایزو بوتان", String.valueOf(stationPropertice.getComponent()[6])));
            data.add(new Table("نرمال پنتان", String.valueOf(stationPropertice.getComponent()[7])));
            data.add(new Table("ایزو پنتان", String.valueOf(stationPropertice.getComponent()[8])));
            data.add(new Table("هگزان", String.valueOf(stationPropertice.getComponent()[9])));
            data.add(new Table("هپتان", String.valueOf(stationPropertice.getComponent()[10])));
            data.add(new Table("اکتان", String.valueOf(stationPropertice.getComponent()[11])));
            data.add(new Table("نونان", String.valueOf(stationPropertice.getComponent()[12])));
            data.add(new Table("دکان", String.valueOf(stationPropertice.getComponent()[13])));
            data.add(new Table("هیدروژن", String.valueOf(stationPropertice.getComponent()[14])));
            data.add(new Table("اکسیژن", String.valueOf(stationPropertice.getComponent()[15])));
            data.add(new Table("کربن منواکسید", String.valueOf(stationPropertice.getComponent()[16])));
            data.add(new Table("آب", String.valueOf(stationPropertice.getComponent()[17])));
            data.add(new Table("هیدروژن سولفید", String.valueOf(stationPropertice.getComponent()[18])));
            data.add(new Table("هلیوم", String.valueOf(stationPropertice.getComponent()[19])));
            data.add(new Table("آرگون", String.valueOf(stationPropertice.getComponent()[20])));
        }
        if (stationLogic != null) {
            if (stationLogic.getBeforeHeater() != null) {

                BasePipe beforeHeater = stationLogic.getBeforeHeater();
                data.add(new Table("خط لوله قبل از گرم کن", ""));

                data.add(new Table("دمای گاز ورودی", String.valueOf(beforeHeater.getTin())));
                data.add(new Table("فشار گاز ورودی", String.valueOf(beforeHeater.getPin())));
                data.add(new Table("دمای گاز خروجی", String.valueOf(beforeHeater.getTout())));
                data.add(new Table("فشار گاز خروجی", String.valueOf(beforeHeater.getPout())));
                data.add(new Table("اختلاف دما", String.valueOf(beforeHeater.getTin() - beforeHeater.getTout())));
                data.add(new Table("تلفات حرارتی", String.valueOf(beforeHeater.getConsumption())));

            }
        }

        if (stationLogic != null) {
            if (stationLogic.getHeaters() != null) {

                Heaters heaters = stationLogic.getHeaters();
                List<Heater> heater = heaters.getHeaters();
                data.add(new Table("اطلاعات گرم کن ", ""));
                int temp = 1;
                for (Heater h : heater) {

                    data.add(new Table("گرم کن " + temp, ""));
                    data.add(new Table("راندمان گرم کن " + temp, String.valueOf(h.getEfficiency())));

                    List<Burner> burners = h.getBurners();
                    int temp2 = 1;
                    for (Burner b : burners) {
                        data.add(new Table("دمای دودکش مشعل " + temp2, String.valueOf(b.getTstack())));
                        data.add(new Table("درصد اکسیژن مشعل " + temp2, String.valueOf(b.getOxygen())));
                        data.add(new Table("راندمان مشعل " + temp2, String.valueOf(b.getEfficiency())));
                        double tem = b.getConsumption();
                        data.add(new Table("مصرف مشعل " + temp2, String.valueOf(b.getConsumption())));

                        temp2++;
                    }
                    temp++;
                }
                data.add(new Table("مصرف گرمکن‌ها", String.valueOf(heaters.getConsumption())));
            }
        }

        if (stationLogic != null) {
            if (stationLogic.getAfterHeater() != null) {

                BasePipe afterHeater = stationLogic.getAfterHeater();
                data.add(new Table("خط لوله بعد از گرم کن", ""));
                data.add(new Table("دمای گاز ورودی", String.valueOf(afterHeater.getTin())));

                data.add(new Table("فشار گاز ورودی", String.valueOf(afterHeater.getPin())));
                data.add(new Table("دمای گاز خروجی", String.valueOf(afterHeater.getTout())));
                data.add(new Table("فشار گاز خروجی", String.valueOf(afterHeater.getPout())));
                data.add(new Table("اختلاف دما", String.valueOf(afterHeater.getTin() - afterHeater.getTout())));
                data.add(new Table("تلفات حرارتی", String.valueOf(afterHeater.getConsumption())));
            }
        }

        if (stationLogic != null) {
            if (stationLogic.getCollector() != null) {

                BasePipe collector = stationLogic.getCollector();
                data.add(new Table("اطلاعات کلکتور", ""));
                data.add(new Table("دمای گاز ورودی", String.valueOf(collector.getTin())));

                data.add(new Table("فشار گاز ورودی", String.valueOf(collector.getPin())));
                data.add(new Table("دمای گاز خروجی", String.valueOf(collector.getTout())));
                data.add(new Table("فشار گاز خروجی", String.valueOf(collector.getPout())));
                data.add(new Table("اختلاف دما", String.valueOf(collector.getTin() - collector.getTout())));
                data.add(new Table("تلفات حرارتی", String.valueOf(collector.getConsumption())));
            }
        }
        if (stationLogic != null) {
            if (stationLogic.getRuns() != null) {
                data.add(new Table("اطلاعات ران ها", ""));

                Runs runs = stationLogic.getRuns();
                List<BaseRun> run = runs.getRuns();
                int i = 1;
                for (BaseRun r : run) {
                    data.add(new Table("ران " + i, String.valueOf(r.getPin())));

                    data.add(new Table("فشار گاز ورودی", String.valueOf(r.getPin())));
                    data.add(new Table("دمای گاز خروجی", String.valueOf(r.getTout())));
                    data.add(new Table("فشار گاز خروجی", String.valueOf(r.getPout())));
                    data.add(new Table("اختلاف دما", String.valueOf(r.getTin() - r.getTout())));
                    data.add(new Table("تلفات حرارتی", String.valueOf(r.getConsumption())));
                    i++;
                }
            }
        }

        if (stationLogic != null) {
            if (stationLogic.getRegulator() != null) {
                Regulator regulator = stationLogic.getRegulator();
                data.add(new Table("رگولاتور", ""));
                data.add(new Table("دمای گاز ورودی", String.valueOf(regulator.getTin())));
                data.add(new Table("فشار گاز ورودی", String.valueOf(regulator.getPin())));
                data.add(new Table("دمای گاز خروجی", String.valueOf(regulator.getTout())));
                data.add(new Table("فشار گاز خروجی", String.valueOf(regulator.getPout())));
            }
        }


    }

    public void customResize(TableView<?> view) {

        AtomicLong width = new AtomicLong();
        view.getColumns().forEach(col -> {
            width.addAndGet((long) col.getWidth());
        });
        double tableWidth = view.getWidth();

        if (tableWidth > width.get()) {
            view.getColumns().forEach(col -> {
                col.setPrefWidth(col.getWidth() + ((tableWidth - width.get()) / view.getColumns().size()));
            });
        }
    }


    public void saveAction(ActionEvent actionEvent) throws IOException {

        FileChooser chooser = new FileChooser();
//        FileChooserBuilder fcb = FileChooserBuilder.create();
//        FileChooser fc = fcb.title("Open Dialog").build();
        chooser.setTitle("Select File");

//Set extension filter
        FileChooser.ExtensionFilter extFilterALL =
                new FileChooser.ExtensionFilter("All Files", "*.xls", "*.xlsx", "*.pdf",
                        "*.PDF");
        FileChooser.ExtensionFilter extFilterExcel =
                new FileChooser.ExtensionFilter("Excel files (*.xls, *.xlsx)", "*.xls", "*.xlsx");
        FileChooser.ExtensionFilter extFilterPDF =
                new FileChooser.ExtensionFilter("PDF files (*.pdf)", "*.PDF", "*.pdf");
        FileChooser.ExtensionFilter extFilterTIFF =
                new FileChooser.ExtensionFilter("TIFF files (*.tiff)", "*.TIF", "*.TIFF",
                        "*.tif", "*.tiff");

        chooser.getExtensionFilters().addAll(extFilterALL, extFilterExcel, extFilterPDF);
        File file = chooser.showOpenDialog(new Stage());
//        String filePath = file.getAbsolutePath();
        System.out.println(file.getName());
//        System.out.println(filePath);
        String fileExtension = null;
        String fileName = null;
        if (file != null) {

            fileName = file.getName();
            fileExtension = fileName.substring(fileName.indexOf(".") + 1, file.getName().length());
            System.out.println(">> fileExtension " + fileExtension);

        } else {
            return;
        }
        if (fileExtension.equals("xls") || fileExtension.equals("xlsx")) {

            System.out.println(file.toString());

            Workbook workbook = new HSSFWorkbook();
            Sheet spreadsheet = workbook.createSheet("result");

            Row row = spreadsheet.createRow(0);

            for (int j = 0; j < tableID.getColumns().size(); j++) {
                row.createCell(j).setCellValue(tableID.getColumns().get(j).getText());
            }

            for (int i = 0; i < tableID.getItems().size(); i++) {
                row = spreadsheet.createRow(i + 1);
                for (int j = 0; j < tableID.getColumns().size(); j++) {
                    if (tableID.getColumns().get(j).getCellData(i) != null) {
                        row.createCell(j).setCellValue(tableID.getColumns().get(j).getCellData(i).toString());
                    } else {
                        row.createCell(j).setCellValue("");
                    }
                }
            }

            FileOutputStream fileOut = new FileOutputStream(file.toString());
            workbook.write(fileOut);
            fileOut.close();
        } else if (fileExtension.equals("pdf") || fileExtension.equals("PDF")) {

            try {
                OutputStream pdffile = new FileOutputStream(new File(file.toString()));

                Document document = new Document();
                PdfWriter.getInstance(document, pdffile);

                document.open();
                document.add(new Paragraph("First iText PDF"));
                document.add(new Paragraph(new Date().toString()));

                document.addAuthor("Krishna Srinivasan");
                document.addCreationDate();
                document.addCreator("JavaBeat");
                document.addTitle("Sample PDF");


                //Create Paragraph
                Paragraph paragraph = new Paragraph("Title 1", new Font(Font.FontFamily.TIMES_ROMAN, 18,
                        Font.BOLD));


                //New line
                Font f = FontFactory.getFont("/sample/view/showResult/font/BNazanin.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
                Paragraph pr = new Paragraph("حسین چقدر خفنه", f);

                paragraph.add(new Paragraph(" "));
                String FONT = "resources/fonts/FreeSans.ttf";

                paragraph.add(new Paragraph("\u0915\u093e\u0930 \u092a\u093e\u0930\u094d\u0915\u093f\u0902\u0917", f));
                paragraph.add(new Paragraph("سلام", f));
                paragraph.add("Test Paragraph");
                paragraph.add(new Paragraph(" "));
                document.add(paragraph);

                //Create a table in PDF
                PdfPTable pdfTable = new PdfPTable(2);
                PdfPCell cell1 = new PdfPCell(new Phrase("مقدار" , f));
                cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell1.setRunDirection(PdfWriter.RUN_DIRECTION_RTL);
                pdfTable.addCell(cell1);

                cell1 = new PdfPCell(new Phrase("نام" , f));
                cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell1.setRunDirection(PdfWriter.RUN_DIRECTION_RTL);
                pdfTable.addCell(cell1);

                pdfTable.setHeaderRows(1);

                for (int i = 0; i < tableID.getItems().size(); i++) {
                    for (int j = 0; j < tableID.getColumns().size(); j++) {
                        if (tableID.getColumns().get(j).getCellData(i) != null) {
                            cell1 = new PdfPCell(new Phrase(tableID.getColumns().get(j).getCellData(i).toString(), f));
                            cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
                            cell1.setRunDirection(PdfWriter.RUN_DIRECTION_RTL);
                        } else {
                            cell1 = new PdfPCell(new Phrase("", f));
                            cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
                            cell1.setRunDirection(PdfWriter.RUN_DIRECTION_RTL);
                        }
                        pdfTable.addCell(cell1);
                    }
                }



//                pdfTable.addCell("ستون ۱ سطح ۱");
//                pdfTable.addCell("Row 1 Col 2");
//                pdfTable.addCell("Row 1 Col 3");
//
//                pdfTable.addCell("Row 2 Col 1");
//                pdfTable.addCell("Row 2 Col 2");
//                pdfTable.addCell("Row 2 Col 3");

                document.add(pdfTable);

                document.close();
                pdffile.close();

            } catch (DocumentException e) {
                e.printStackTrace();
            }

//        Platform.exit();
        }
    }
}
