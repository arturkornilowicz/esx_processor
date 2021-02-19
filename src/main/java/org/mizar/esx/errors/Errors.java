package org.mizar.esx.errors;

import java.util.*;
import org.dom4j.*;

public class Errors {

    private static TreeSet<String> errors = new TreeSet<>();
    private static int errorNbr;

    public static void error(Element e, String kind) {
        errorNbr++;
        errors.add(kind + ": " + e.getName());
    }

    public static void printErrors() {
        System.out.println(errorNbr + " errors found:\n" + errors);
    }
}
