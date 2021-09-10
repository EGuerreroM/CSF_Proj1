package com.kodigo.group4;

import java.util.*;

public class FileHandler {

    Scanner scanner = new Scanner(System.in);
    Header header = new Header();
    FileObject fileObject = new FileObject();
    FileAbstract fileCreator = new FileCreator();

    public boolean isNull(String extension){
        if (fileCreator.selectFileType(extension) == null){
            return true;
        }else{
            return false;
        }
    }

    public void requestInformation(){
        header.showAddInformationFileHeader();
        System.out.println("Write the file name: ");
        fileObject.setFileName(scanner.next());
        System.out.println("Write file extension: ");
        fileObject.setExtension(scanner.next());
        if (isNull(fileObject.getExtension())){
            Notificacions.error("File Creator");
        }else{
            IFile file = fileCreator.selectFileType(fileObject.getExtension());
            file.readFile(fileObject.getFileName());
        }
    }
    public void exportFile(){
        header.showExportFileHeader();
        System.out.println("Write file extension (avoid dot): ");
        String extension = scanner.next();
        fileObject.setExtension(extension);
        if (isNull(fileObject.getExtension())){
            Notificacions.error("File Creator");
        }else{
            IFile file = fileCreator.selectFileType(fileObject.getExtension());
            file.createFile(FlightList.getFlightList());
        }
    }
}
