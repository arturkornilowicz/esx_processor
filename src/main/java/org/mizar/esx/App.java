package org.mizar.esx;

import org.mizar.esx.errors.*;

public class App extends ESX_Processor {

    public App(String pathName, String fileName, String fileExtension) {
        super(pathName, fileName, fileExtension);
    }

    public static void main(String[] args ) {
        App app = new App("text","tarski",".esx");
        try {
            app.processArticle();
            System.out.println("Article:\n" + app.getTextProper());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Errors.printErrors();
        }
    }
}
