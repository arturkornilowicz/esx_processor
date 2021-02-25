package org.mizar.esx.errors;

import java.io.*;
import java.util.*;
import org.dom4j.*;

public class Errors {

    private static TreeSet<String> errors = new TreeSet<>();
    private static int errorNbr;

    private String fileName;

    public Errors(String fileName) {
        this.fileName = fileName;
    }

    public static void error(Element e, String kind) {
        errorNbr++;
        errors.add(kind + ": " + e.getName());
    }

    public static void printErrors() {
        System.out.println(errorNbr + " errors found:\n" + errors);
    }

    public void writeErrors() {
        FileWriter fw = null;
        BufferedWriter bw = null;
        PrintWriter out = null;
        try {
            fw = new FileWriter("esx_errors.txt", true);
            bw = new BufferedWriter(fw);
            out = new PrintWriter(bw);
            out.println("#" + fileName);
            for (String error : errors)
                out.println("  ERROR: " + error);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
