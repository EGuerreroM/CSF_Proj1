package com.kodigo.group4;

import java.util.*;

public class FileHandler {

    Scanner scanner = new Scanner(System.in);
    Headers header = new Headers();
    FileObject fileObject = new FileObject();
    FileAbstract fileCreator = new FileCreator();

    public void requestInformation(){
        header.showAddInformationFileHeader();
        System.out.println("Write the file name: ");
        fileObject.setFileName(scanner.next());
        System.out.println("Write file extension: ");
        fileObject.setExtension(scanner.next());
        IFile file = fileCreator.selectFileType(fileObject.getExtension());
        file.readFile(fileObject.getFileName());
    }
    public void exportFile(){
        header.showExportFileHeader();
        System.out.println("Write file extension (avoid dot): ");
        String extension = scanner.next();
        fileObject.setExtension(extension);
        IFile file = fileCreator.selectFileType(fileObject.getExtension());
        file.createFile(FlightList.getFlightList());
    }
}
