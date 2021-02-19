package org.mizar.esx.article;

import java.util.*;
import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;

@Setter
@Getter
@NoArgsConstructor

public class Label extends EsxElement {

    private String idnr;
    private String labelnr;
    private String position;
    private String serialnr;
    private String spelling;

    public Label(Element element) {
        super(element);
        this.idnr = Misc.assignAttrValue(element,"idnr");
        this.labelnr = Misc.assignAttrValue(element,"labelnr");
        this.position = Misc.assignAttrValue(element,"position");
        this.serialnr = Misc.assignAttrValue(element,"serialnr");
        this.spelling = Misc.assignAttrValue(element,"spelling");
    }

    @Override
    public String toString() {
        return idnr.equals("0") ? "" : (spelling + ":");
    }
}
