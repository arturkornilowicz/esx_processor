package org.mizar.esx.article;

import java.util.*;

import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;
import org.mizar.esx.design.EsxElementFactory;

@Setter
@Getter
@NoArgsConstructor

public class SingleAssumption extends EsxElement implements AssumptionInterface {

    private String position;

    private Proposition proposition;

    public SingleAssumption(Element element) {
        super(element);
        this.position = Misc.assignAttrValue(element, "position");
    }

    @Override
    public String toString() {
        return proposition.toString();
    }

    @Override
    public void process() {
        ESX_Processor.actions.actionSingleAssumptionBeforeProposition(this);
        setProposition((Proposition) EsxElementFactory.create(getElement().element("Proposition")));
        ESX_Processor.actions.actionSingleAssumptionAfterProposition(this);
    }
}
