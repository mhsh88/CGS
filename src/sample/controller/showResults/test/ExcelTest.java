package sample.controller.showResults.test;


import javafx.scene.control.TableView;
import org.dhatim.fastexcel.Workbook;
import org.dhatim.fastexcel.Worksheet;
import sample.model.showResultEntity.Table;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class ExcelTest {

    public void excelTest(String file, TableView<Table> tableID, String sheetName){
        try (OutputStream os = new BufferedOutputStream(new FileOutputStream(file),2048)){
            Workbook wb = new Workbook(os, "BEHIN Simulator", "1.0");
            Worksheet ws = wb.newWorksheet(sheetName);
//            ws.value(0, 0, "This is a string in A1");
//            ws.value(0, 1, new Date());
//            ws.value(0, 2, 1234);
//            ws.value(0, 3, 123456L);
//            ws.value(0, 4, 1.234);

            for (int i = 0; i < tableID.getItems().size(); i++) {

                for (int j = 0; j < tableID.getColumns().size(); j++) {
                    if (tableID.getColumns().get(j).getCellData(i) != null) {
                        ws.value(i, j, tableID.getColumns().get(j).getCellData(i).toString());
                    } else {
                        ws.value(i, j, "");
                    }
                }
            }
            wb.finish();
        }
        catch (Exception e){
            e.printStackTrace();

        }

    }
}
