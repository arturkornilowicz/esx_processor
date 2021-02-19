package org.mizar.esx;

import lombok.*;
import org.dom4j.*;
import org.mizar.esx.article.*;
import org.mizar.esx.xml.XMLApplication;

@Setter
@Getter

public class ESX_Processor extends XMLApplication {

    private TextProper textProper;

    public ESX_Processor(String pathName, String fileName, String fileExtension) {
        super(pathName, fileName, fileExtension);
    }

    private void preProcess(Element e) {
    }

    private void postProcess(Element e) {
    }

    private void treeWalk(Document document) {
        preProcess(document.getRootElement());
        treeWalk(document.getRootElement());
        postProcess(document.getRootElement());
    }

    private void treeWalk(Element element) {
        for (Element elem : element.elements()) {
            preProcess(elem);
            treeWalk(elem);
            postProcess(elem);
        }
    }

    public void processArticle() {
        treeWalk(getXmlDocument());
    }
}
