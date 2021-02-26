package org.mizar.esx;

import org.mizar.esx.errors.*;

public class Testy extends ESX_Processor {

    public Testy(String pathName, String fileName, String fileExtension) {
        super(pathName, fileName, fileExtension);
    }

    public static void main(String[] args ) {
        Testy app = new Testy("text","a",".esx");
        System.out.println(app.getFileName() + " processing.");
        Errors errors = new Errors(app.getFileName());
        boolean RTE = false;
        try {
            app.processArticle();
            System.out.println("Article:\n" + app.getTextProper());
            System.out.println("\nTESTY:\n");
            System.out.println(app.getTextProper().getItems().size());

            for (int i = 0; i < app.getTextProper().getItems().size(); i++) {
                System.out.println(app.getTextProper().getItems().get(i).getBlock());
            }
        } catch (Exception e) {
            RTE = true;
            e.printStackTrace();
        } finally {
            errors.printErrors();
            errors.writeErrors(RTE);
        }
    }
}
