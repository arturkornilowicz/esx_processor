package org.mizar.esx;

import org.mizar.esx.actions.Actions;
import org.mizar.esx.article.*;
import org.mizar.esx.errors.*;

class TeX implements Actions {

    @Override
    public void actionSection(SectionPragma result) {
        System.out.println("BEGIN");
    }

    @Override
    public void actionTheoremItemAfterProposition(TheoremItem result) {
        System.out.println(result.getProposition().getLabel());
    }

    @Override
    public void actionReservationBeforeReservationSegments(Reservation result) {
        System.out.println("From now on ...");
    }

    @Override
    public void actionPragmaAfter(Pragma result) {
        System.out.println(result.getPragma());
    }

    @Override
    public void actionVariable(Variable result) {
        System.out.println(result.getSpelling());
    }
}

public class Testy extends ESX_Processor {

    public Testy(String pathName, String fileName, String fileExtension) {
        super(pathName, fileName, fileExtension);
    }

    public Testy(String pathName, String fileName, String fileExtension, Actions actions) {
        super(pathName, fileName, fileExtension, actions);
    }

    public static void main(String[] args) {
        Testy app = new Testy("d:/users/artur/mizar/test", "gwizdka", ".esx", new TeX());
        System.out.println(app.getFileName() + " processing.");
        Errors errors = new Errors(app.getFileName());
        boolean RTE = false;
        try {
            app.processArticle();
//            System.out.println("Article:\n" + app.getTextProper());
//            System.out.println("\nTESTY:\n");
//            System.out.println(app.getTextProper().getItems().size());
//
//            for (int i = 0; i < app.getTextProper().getItems().size(); i++) {
//                if (app.getTextProper().getItems().get(i).getBlock() != null) {
//                    System.out.println(app.getTextProper().getItems().get(i).getBlock().getKind());
//                    System.out.println(app.getTextProper().getItems().get(i).getBlock().getItems().size() + " item(s)");
//                }
//            }
        } catch (Exception e) {
            RTE = true;
            e.printStackTrace();
        } finally {
            errors.printErrors();
            errors.writeErrors(RTE);
        }
    }
}
