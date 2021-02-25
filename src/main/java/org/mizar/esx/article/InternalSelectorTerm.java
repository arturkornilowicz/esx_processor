package org.mizar.esx.article;

import java.util.*;
import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;

@Setter
@Getter
@NoArgsConstructor

public class InternalSelectorTerm extends EsxElement implements TermInterface {

    private String absolutenr;
    private String nr;
    private String originnr;
    private String position;
    private String sort;
    private String spelling;
    private String varnr;

    public InternalSelectorTerm(Element element) {
        super(element);
        this.absolutenr = Misc.assignAttrValue(element,"absolutenr");
        this.nr = Misc.assignAttrValue(element,"nr");
        this.originnr = Misc.assignAttrValue(element,"originnr");
        this.position = Misc.assignAttrValue(element,"position");
        this.sort = Misc.assignAttrValue(element,"sort");
        this.spelling = Misc.assignAttrValue(element,"spelling");
        this.varnr = Misc.assignAttrValue(element,"varnr");
    }

    @Override
    public String toString() {
        return spelling;
    }
}
