package com.kodigo.group4;

public class FileCreator extends FileAbstract{

    public FileCreator(){
    }

    @Override
    public IFile selectFileType(String fileType) {
        IFile file = null;
        switch (fileType){
            case "xlsx":
                file = new ExcelFile();
                break;
            case "docx":
                //file = new WordFile();
                break;
            default:
                //file = null;
                Notificacions.error("File Creator");
        }
        return file;
    }
}
