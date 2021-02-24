package org.mizar.esx.article;

import java.util.*;
import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;

@Setter
@Getter
@NoArgsConstructor

public class PrivateFunctorTerm extends EsxElement implements TermInterface {

    private String idnr;
    private String nr;
    private String position;
    private String serialnr;
    private String sort;
    private String spelling;

    private Arguments arguments;

    public PrivateFunctorTerm(Element element) {
        super(element);
        this.idnr = Misc.assignAttrValue(element,"idnr");
        this.nr = Misc.assignAttrValue(element,"nr");
        this.position = Misc.assignAttrValue(element,"position");
        this.serialnr = Misc.assignAttrValue(element,"serialnr");
        this.sort = Misc.assignAttrValue(element,"sort");
        this.spelling = Misc.assignAttrValue(element,"spelling");
    }

    @Override
    public String toString() {
        return spelling + "(" + arguments + ")";
    }
}
