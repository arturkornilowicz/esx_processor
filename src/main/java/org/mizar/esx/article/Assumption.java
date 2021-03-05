package org.mizar.esx.article;

import java.util.*;

import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;
import org.mizar.esx.design.EsxElementFactory;
import org.mizar.esx.errors.Errors;

@Setter
@Getter
@NoArgsConstructor

public class Assumption extends Item {

    private AssumptionInterface assumption;

    public Assumption(Element element) {
        super(element);
    }

    @Override
    public String toString() {
        return "assume " + assumption.toString();
    }

    @Override
    public void process() {
        ESX_Processor.actions.actionAssumptionBeforeAssumption(this);
        setAssumption((AssumptionInterface) EsxElementFactory.create(getElement().elements().get(0)));
        ESX_Processor.actions.actionAssumptionAfterAssumption(this);
    }
}
