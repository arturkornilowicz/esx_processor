package org.mizar.esx;

import org.mizar.esx.errors.*;

public class App extends ESX_Processor {

    public App(String pathName, String fileName, String fileExtension) {
        super(pathName, fileName, fileExtension);
    }

    public static void main(String[] args ) {
        App app = new App("text","xboole_1",".esx");
        app.processArticle();
        System.out.println("Article:\n" + app.getTextProper());
        Errors.printErrors();
    }
}
