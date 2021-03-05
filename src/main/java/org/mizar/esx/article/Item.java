package org.mizar.esx.article;

import java.util.*;

import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;

@Setter
@Getter
@NoArgsConstructor

public class Item extends EsxElement {

    private String endposition;
    private String kind;
    private String position;

    private Block block;

    public Item(Element element) {
        super(element);
        this.endposition = Misc.assignAttrValue(element, "endposition");
        this.kind = Misc.assignAttrValue(element, "kind");
        this.position = Misc.assignAttrValue(element, "position");
    }

    @Override
    public String toString() {
        return getElement().getName() + (block != null ? "\n" + block : "");
    }
}
