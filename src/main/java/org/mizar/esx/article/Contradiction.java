package org.mizar.esx.article;

import java.util.*;

import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;

@Setter
@Getter
@NoArgsConstructor

public class Contradiction extends EsxElement implements FormulaInterface {

    private String position;
    private String sort;

    public Contradiction(Element element) {
        super(element);
        this.position = Misc.assignAttrValue(element, "position");
        this.sort = Misc.assignAttrValue(element, "sort");
    }

    @Override
    public String toString() {
        return "contradiction";
    }

    @Override
    public void process() {
        ESX_Processor.actions.actionContradiction(this);
    }
}
