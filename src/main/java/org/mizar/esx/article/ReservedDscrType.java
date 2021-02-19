package org.mizar.esx.article;

import java.util.*;
import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;

@Setter
@Getter
@NoArgsConstructor

public class ReservedDscrType extends EsxElement {

    private String idnr;
    private String nr;
    private String position;
    private String sort;

    public ReservedDscrType(Element element) {
        super(element);
        this.idnr = Misc.assignAttrValue(element,"idnr");
        this.nr = Misc.assignAttrValue(element,"nr");
        this.position = Misc.assignAttrValue(element,"position");
        this.sort = Misc.assignAttrValue(element,"sort");
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
