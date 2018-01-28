package sample.controller.showResults;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
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
import sample.model.showResultEntity.Table;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicLong;

public class ShowResultsController implements Initializable {


    public TextField textField2;
    public GridPane gridPane;


    @FXML
    TableView<Table> tableID;
    @FXML
    TableView<Table> hydrateTable;
    @FXML
    TableColumn<Table, String> name;
    @FXML
    TableColumn<Table, String> value;
    @FXML
    TableColumn<Table, String> hydrateName;
    @FXML
    TableColumn<Table, String> hydrateValue;

    //    public TableView table;
    @FXML
    TextField textField = new TextField();


    public static ObservableList<Table> getData() {
        return data;
    }
    public static ObservableList<Table> getHydrateData() {return dataWithThydrate;}

    static final ObservableList<Table> data = FXCollections.observableArrayList();
    static final ObservableList<Table> dataWithThydrate = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {


        name.setCellValueFactory(new PropertyValueFactory<Table, String>("name"));
        value.setCellValueFactory(new PropertyValueFactory<Table, String>("value"));
        hydrateName.setCellValueFactory(new PropertyValueFactory<Table, String>("name"));
        hydrateValue.setCellValueFactory(new PropertyValueFactory<Table, String>("value"));

//        showResult();
        tableID.setItems(data);
        tableID.setColumnResizePolicy((param) -> true);
        Platform.runLater(() -> customResize(tableID));
        name.prefWidthProperty().bind(tableID.widthProperty().divide(2));
        value.prefWidthProperty().bind(tableID.widthProperty().divide(2));
//        showResult();
        hydrateTable.setItems(dataWithThydrate);
        hydrateTable.setColumnResizePolicy((param) -> true);
        Platform.runLater(() -> customResize(hydrateTable));
        hydrateName.prefWidthProperty().bind(hydrateTable.widthProperty().divide(2));
        hydrateValue.prefWidthProperty().bind(hydrateTable.widthProperty().divide(2));
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
