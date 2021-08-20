package com.kodigo.group4;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class FileHandler {

    List<Flight> flightList = new ArrayList<>();
    Flight flight;
    Random random = new Random(234);

    public List<Flight> openFile(String fileName) {
        String pathFile = "GeneratedFiles/" + fileName;
        try (FileInputStream file = new FileInputStream(new File(pathFile))) {

            XSSFWorkbook book = new XSSFWorkbook(file);

            XSSFSheet sheet = book.getSheetAt(0);

            Iterator<Row> rowIterator = sheet.iterator();

            StringBuilder sb = new StringBuilder();
            Row row;
            int i = 1;
            while (rowIterator.hasNext()) {
                row = rowIterator.next();
                if(row.getRowNum()==0){
                    continue; //just skip the rows if row number is 0 or 1
                }
                flight = new Flight();
                flight.setFlightNumber(sheet.getRow(i).getCell(0).getStringCellValue());
                flight.setAirline(sheet.getRow(i).getCell(1).getStringCellValue());
                flight.setAircraftType(sheet.getRow(i).getCell(2).getStringCellValue());
                flight.setStatus(sheet.getRow(i).getCell(3).getStringCellValue());
                flight.setOriginCountry(sheet.getRow(i).getCell(4).getStringCellValue());
                flight.setOriginCity(sheet.getRow(i).getCell(5).getStringCellValue());
                flight.setDestinationCountry(sheet.getRow(i).getCell(6).getStringCellValue());
                flight.setDestinationCity(sheet.getRow(i).getCell(7).getStringCellValue());
                flight.setDepartureDate(sheet.getRow(i).getCell(8).getStringCellValue());
                flight.setDepartureTime(sheet.getRow(i).getCell(9).getStringCellValue());
                flight.setArrivalDate(sheet.getRow(i).getCell(10).getStringCellValue());
                flight.setArrivalTime(sheet.getRow(i).getCell(11).getStringCellValue());
                flight.setIncident(sheet.getRow(i).getCell(12).getStringCellValue());
                flightList.add(flight);
                i++;
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
            //System.out.println(sb.toString().split(" "));
        }   catch(IOException ex){
            System.out.println("the file could not open "+ex);
        }
        System.out.println("File uploaded successfully...");
        return flightList;
    }

    void createExcelFile(List<Flight> list){
        System.out.println("===============================");
        System.out.println("Creating excel file...");
        try {
            FileOutputStream fileOut = new FileOutputStream("GeneratedFiles/"+"Flights.xlsx");
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet();
            //creating the headers
            Row row = sheet.createRow(0);
            row.createCell(0).setCellValue("Flight Number");
            row.createCell(1).setCellValue("Airline");
            row.createCell(2).setCellValue("Aircraft type");
            row.createCell(3).setCellValue("Status");
            row.createCell(4).setCellValue("Origin Country");
            row.createCell(5).setCellValue("Origin City");
            row.createCell(6).setCellValue("Destination Country");
            row.createCell(7).setCellValue("Destination City");
            row.createCell(8).setCellValue("Departure date");
            row.createCell(9).setCellValue("Departure time");
            row.createCell(10).setCellValue("Arrival date");
            row.createCell(11).setCellValue("Arrival time");
            row.createCell(12).setCellValue("Incidents");
            //get the list which u want
            //List<Flight> flightList = getNamesList();
            int rowNum = 1;
            for (Flight flight : list ) {
                Row row1 = sheet.createRow(rowNum++);
                row1.createCell(0).setCellValue((flight.getFlightNumber()));
                row1.createCell(1).setCellValue((flight.getAirline()));
                row1.createCell(2).setCellValue((flight.getAircraftType()));
                row1.createCell(3).setCellValue((flight.getStatus()));
                row1.createCell(4).setCellValue((flight.getOriginCountry()));
                row1.createCell(5).setCellValue((flight.getOriginCity()));
                row1.createCell(6).setCellValue((flight.getDestinationCountry()));
                row1.createCell(7).setCellValue((flight.getDestinationCity()));
                row1.createCell(8).setCellValue((flight.getDepartureDate()));
                row1.createCell(9).setCellValue((flight.getDepartureTime()));
                row1.createCell(10).setCellValue((flight.getArrivalDate()));
                row1.createCell(11).setCellValue((flight.getArrivalTime()));
                row1.createCell(12).setCellValue((flight.getIncident()));
            }
            workbook.write(fileOut);
        }catch (Exception e){
            System.out.println("Error while adding data to file " + e);
        }
        System.out.println("Excel file created successfully...");
    }

}
