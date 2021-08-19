package com.kodigo.group4;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

public class FildeHandler {


    public void openFile() {
        String fileName = "Data.xlsx";
        String pathFile = "C:\\" + fileName;
        Flight flight=new Flight();
        try (FileInputStream file = new FileInputStream(new File(pathFile))) {

            XSSFWorkbook book = new XSSFWorkbook(file);

            XSSFSheet sheet = book.getSheetAt(0);

            Iterator<Row> rowIterator = sheet.iterator();


            StringBuilder sb = new StringBuilder();

            Row row;

            while (rowIterator.hasNext()) {
                row = rowIterator.next();

                Iterator<Cell> cellIterator = row.cellIterator();
                Cell cell;

                while (cellIterator.hasNext()) {

                    cell = cellIterator.next();

                    if (cell.getColumnIndex() == 0) {
                        sb.append(cell.toString()).append("\t");
                    } else {
                        sb.append(String.format("%-30s", cell.toString())).append("\t");
                    }

                }

                sb.append("\n");
            }

            System.out.println(sb.toString());
        }   catch(IOException ex){
            System.out.println("the file could not open "+ex);
        }

    }
}
