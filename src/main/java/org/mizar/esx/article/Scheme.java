package org.mizar.esx.article;

import java.util.*;
import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;

@Setter
@Getter
@NoArgsConstructor

public class Scheme extends EsxElement {

    private String idnr;
    private String nr;
    private String spelling;

    public Scheme(Element element) {
        super(element);
        this.idnr = Misc.assignAttrValue(element,"idnr");
        this.nr = Misc.assignAttrValue(element,"nr");
        this.spelling = Misc.assignAttrValue(element,"spelling");
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
