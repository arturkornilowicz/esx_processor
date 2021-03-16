package org.mizar.esx.article;

import java.util.*;

import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;
import org.mizar.esx.design.EsxElementFactory;

@Setter
@Getter
@NoArgsConstructor

public class Block extends EsxElement implements JustificationInterface {

    private String endposition;
    private String kind;
    private String position;

    private List<Item> items = new ArrayList<>();

    public Block(Element element) {
        super(element);
        this.endposition = Misc.assignAttrValue(element, "endposition");
        this.kind = Misc.assignAttrValue(element, "kind");
        this.position = Misc.assignAttrValue(element, "position");
    }

    @Override
    public String toString() {
        String result = getElement().getName() + "\n";
        for (Item item : items)
            result += item + "\n";
        return result;
    }

    public void addItem(Item item) {
//        System.out.println("+++++ Item \"" + item + "\" added.");
        items.add(item);
    }
}
