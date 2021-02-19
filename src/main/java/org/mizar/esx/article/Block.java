package org.mizar.esx.article;

import java.util.*;
import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;

@Setter
@Getter
@NoArgsConstructor

public class Block extends EsxElement {

    private String endposition;
    private String kind;
    private String position;

    public Block(Element element) {
        super(element);
        this.endposition = Misc.assignAttrValue(element,"endposition");
        this.kind = Misc.assignAttrValue(element,"kind");
        this.position = Misc.assignAttrValue(element,"position");
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
