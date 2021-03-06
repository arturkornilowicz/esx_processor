package org.mizar.esx.article;

import java.util.*;

import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;

@Setter
@Getter
@NoArgsConstructor

public class NumeralTerm extends EsxElement implements TermInterface {

    private String number;
    private String position;
    private String sort;

    public NumeralTerm(Element element) {
        super(element);
        this.number = Misc.assignAttrValue(element, "number");
        this.position = Misc.assignAttrValue(element, "position");
        this.sort = Misc.assignAttrValue(element, "sort");
    }

    @Override
    public String toString() {
        return number;
    }

    @Override
    public void process() {
        ESX_Processor.actions.actionNumeralTerm(this);
    }
}
