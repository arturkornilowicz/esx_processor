package org.mizar.esx;

import org.mizar.esx.errors.*;

public class App extends ESX_Processor {

    public App(String pathName, String fileName, String fileExtension) {
        super(pathName, fileName, fileExtension);
    }

    public static void main(String[] args ) {
        App app = new App(args[0],args[1],".esx");
        System.out.println(app.getFileName() + " processing.");
        Errors errors = new Errors(app.getFileName());
        boolean RTE = false;
        try {
            app.processArticle();
//            System.out.println("Article:\n" + app.getTextProper());
        } catch (Exception e) {
            RTE = true;
            e.printStackTrace();
        } finally {
//            errors.printErrors();
            errors.writeErrors(RTE);
        }
    }
}
