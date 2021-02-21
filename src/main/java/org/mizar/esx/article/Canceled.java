package org.mizar.esx.article;

import java.util.*;
import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;

@Setter
@Getter
@NoArgsConstructor

public class Canceled extends EsxElement implements PragmaInterface {

    private String MMLId;
    private String amount;
    private String kind;
    private String position;

    public Canceled(Element element) {
        super(element);
        this.MMLId = Misc.assignAttrValue(element,"MMLId");
        this.amount = Misc.assignAttrValue(element,"amount");
        this.kind = Misc.assignAttrValue(element,"kind");
        this.position = Misc.assignAttrValue(element,"position");
    }

    @Override
    public String toString() { return "::$" + kind + " " + amount; }
}
