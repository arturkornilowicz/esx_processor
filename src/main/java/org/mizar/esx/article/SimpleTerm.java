package org.mizar.esx.article;

import java.util.*;

import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;

@Setter
@Getter
@NoArgsConstructor

public class SimpleTerm extends EsxElement implements TermInterface {

    private String idnr;
    private String origin;
    private String position;
    private String serialnr;
    private String sort;
    private String spelling;
    private String varnr;

    public SimpleTerm(Element element) {
        super(element);
        this.idnr = Misc.assignAttrValue(element, "idnr");
        this.origin = Misc.assignAttrValue(element, "origin");
        this.position = Misc.assignAttrValue(element, "position");
        this.serialnr = Misc.assignAttrValue(element, "serialnr");
        this.sort = Misc.assignAttrValue(element, "sort");
        this.spelling = Misc.assignAttrValue(element, "spelling");
        this.varnr = Misc.assignAttrValue(element, "varnr");
    }

    @Override
    public String toString() {
        return spelling;
    }

    @Override
    public void process() {
        ESX_Processor.actions.actionSimpleTerm(this);
    }
}
