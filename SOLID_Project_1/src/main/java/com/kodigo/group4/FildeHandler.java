package com.kodigo.group4;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

    public void WriteFile() throws IOException {
        WeatherApp weatherApp = new WeatherApp();
        String prue = weatherApp.weatherInformationRetriever("Comalapa,sv").toString();


        FlightLister flightLister_var = new FlightLister();
        List<Flight> flightList = new ArrayList<Flight>();
        flightList = flightLister_var.listFlights();

        ArrayList headers = new ArrayList();


        Workbook wb = new HSSFWorkbook();
        Sheet sheet = wb.createSheet("sheet");
        Row row = sheet.createRow(0);
        Cell cell = row.createCell(0);
        cell.setCellValue ("Weather : "+prue);
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 11));
        Row row1 = sheet.createRow(1);
        Cell cell1 = row1.createCell(1);
        cell1.setCellValue ("Flight Number");
        sheet.addMergedRegion(new CellRangeAddress(1, 1, 1, 5));
        Row row2 = sheet.createRow(2);
        Cell cell2 = row2.createCell(2);
        cell2.setCellValue ("Status");
        sheet.addMergedRegion(new CellRangeAddress(1, 1, 1, 6));



        FileOutputStream out = new FileOutputStream("C:\\users\\lenovo\\desktop\\Excel.xlsx");
        wb.write(out);
        out.close();


    }
}
