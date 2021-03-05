package org.mizar.esx.xml;

import lombok.*;
import org.dom4j.*;
import org.dom4j.io.*;

import java.io.*;

@Setter
@Getter

public class XMLApplication {

    private String pathName;
    private String fileName;
    private String fileExtension;
    private Document xmlDocument;

    public XMLApplication(String pathName, String fileName, String fileExtension) {
        this.pathName = pathName;
        this.fileName = fileName;
        this.fileExtension = fileExtension;
        readFile();
    }

    private void readFile() {
        try {
            File inputFile = new File(this.pathName + "/" + this.fileName + this.fileExtension);
            SAXReader reader = new SAXReader();
            this.xmlDocument = reader.read(inputFile);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
