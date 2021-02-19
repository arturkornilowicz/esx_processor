package org.mizar.esx.article;

import java.util.*;
import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;

@Setter
@Getter
@NoArgsConstructor

public class SchemeJustification extends EsxElement {

    private String endposition;
    private String idnr;
    private String nr;
    private String position;
    private String schnr;
    private String spelling;

    public SchemeJustification(Element element) {
        super(element);
        this.endposition = Misc.assignAttrValue(element,"endposition");
        this.idnr = Misc.assignAttrValue(element,"idnr");
        this.nr = Misc.assignAttrValue(element,"nr");
        this.position = Misc.assignAttrValue(element,"position");
        this.schnr = Misc.assignAttrValue(element,"schnr");
        this.spelling = Misc.assignAttrValue(element,"spelling");
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
