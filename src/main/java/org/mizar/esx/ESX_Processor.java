package org.mizar.esx;

import lombok.*;
import org.dom4j.*;
import org.mizar.esx.actions.Actions;
import org.mizar.esx.article.*;
import org.mizar.esx.design.EsxElementFactory;
import org.mizar.esx.xml.XMLApplication;

@Setter
@Getter

public class ESX_Processor extends XMLApplication {

    private TextProper textProper;

    public static Actions actions;

    public ESX_Processor(String pathName, String fileName, String fileExtension) {
        super(pathName, fileName, fileExtension);
        this.actions = new Actions() {
        };
    }

    public ESX_Processor(String pathName, String fileName, String fileExtension, Actions actions) {
        super(pathName, fileName, fileExtension);
        this.actions = actions;
    }

    public static Definiens processDefiniens(Element e) {
        if (e == null)
            return null;
        Definiens result = null;
        result = (Definiens) EsxElementFactory.create(e, "shape", "kind");
        return result;
    }

    public static PartialDefiniensListInterface processPartialDefiniensList(Element e, String shape) {
        PartialDefiniensListInterface result = null;

        actions.actionPartialDefiniensListBefore(result);
        result = (PartialDefiniensListInterface) EsxElementFactory.create(e, "shape");
        actions.actionPartialDefiniensListAfter(result);

        return result;
    }

    // todo NIE przenosic
    private Block processBlock(Element e) {
        Block result = null;
        actions.actionBlockBefore(result);
        result = (Block) EsxElementFactory.create(e);
        actions.actionBlockAfter(result);
        BlocksItems.lastItem().setBlock(result);
        return result;
    }

    private Item processItem(Element e) {
        Item result = null;
        actions.actionItemBefore(result);
        result = (Item) EsxElementFactory.create(e);
        actions.actionItemAfter(result);
        BlocksItems.lastBlock().addItem(result);
        BlocksItems.addItem(result);
        return result;
    }

    private void preProcess(Element e) {
        switch (e.getName()) {
            case "Text-Proper":
                this.textProper = (TextProper) EsxElementFactory.create(e);
                BlocksItems.addBlock(this.textProper);
                break;
            case "Item":
                processItem(e.elements().get(0));
                break;
            case "Block":
                BlocksItems.addBlock(processBlock(e));
                break;
//            default:
//                Errors.error(e, "Missing Element in preProcess");
        }
    }

    private void processItemEnd(Element e) {
        switch (e.attributeValue("kind")) {
            case "Section-Pragma":
            case "Definition-Item":
            case "Generalization":
            case "Default-Generalization":
            case "Pragma":
                break;
            default:
        }
    }

    private void postProcess(Element e) {
        switch (e.getName()) {
            case "Text-Proper":
                BlocksItems.removeLastBlock();
                break;
            case "Item":
                break;
            case "Block":
                BlocksItems.removeLastBlock();
                break;
        }
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
