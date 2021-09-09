package com.kodigo.group4;

import lombok.Getter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.sql.SQLOutput;
import java.util.*;

public class FileHandler {

    Scanner scanner = new Scanner(System.in);
    Headers header = new Headers();
    FileFactory fileFactory = new FileFactory();
    FileAbstract fileCreator = new FileCreator();

    public void requestInformation(){
        header.showAddInformationFileHeader();
        System.out.println("Write the file name: ");
        fileFactory.setFileName(scanner.next());
        System.out.println("Write file extension: ");
        fileFactory.setExtension(scanner.next());
        IFile file = fileCreator.selectFileType(fileFactory.getExtension());
        file.readFile(fileFactory.getFileName());
    }
    public void exportFile(){
        System.out.println("Write file extension: ");
        fileFactory.setExtension(scanner.next());
        IFile file = fileCreator.selectFileType(fileFactory.getExtension());
        file.createFile(FlightList.getFlightList());
    }
}
