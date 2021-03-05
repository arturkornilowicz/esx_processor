package org.mizar.esx.article;

import java.util.*;

import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;
import org.mizar.esx.design.EsxElementFactory;

@Setter
@Getter
@NoArgsConstructor

public class CollectiveAssumption extends EsxElement implements AssumptionInterface {

    private String position;

    private Conditions conditions;

    public CollectiveAssumption(Element element) {
        super(element);
        this.position = Misc.assignAttrValue(element, "position");
    }

    @Override
    public String toString() {
        return conditions.toString();
    }

    @Override
    public void process() {
        ESX_Processor.actions.actionCollectiveAssumptionBeforeConditions(this);
        setConditions((Conditions) EsxElementFactory.create(getElement().element("Conditions")));
        ESX_Processor.actions.actionCollectiveAssumptionAfterConditions(this);
    }
}
