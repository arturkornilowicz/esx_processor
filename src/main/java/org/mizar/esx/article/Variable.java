package org.mizar.esx.article;

import java.util.*;
import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;

@Setter
@Getter
@NoArgsConstructor

public class Variable extends EsxElement {

    private String idnr;
    private String kind;
    private String origin;
    private String position;
    private String serialnr;
    private String spelling;
    private String varnr;

    public Variable(Element element) {
        super(element);
        this.idnr = Misc.assignAttrValue(element,"idnr");
        this.kind = Misc.assignAttrValue(element,"kind");
        this.origin = Misc.assignAttrValue(element,"origin");
        this.position = Misc.assignAttrValue(element,"position");
        this.serialnr = Misc.assignAttrValue(element,"serialnr");
        this.spelling = Misc.assignAttrValue(element,"spelling");
        this.varnr = Misc.assignAttrValue(element,"varnr");
    }

    @Override
    public String toString() {
        return spelling;
    }
}
