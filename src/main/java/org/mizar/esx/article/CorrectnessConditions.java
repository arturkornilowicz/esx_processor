package org.mizar.esx.article;

import java.util.*;

import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;
import org.mizar.esx.design.EsxElementFactory;

@Setter
@Getter
@NoArgsConstructor

public class CorrectnessConditions extends EsxElement {

    private ArrayList<CorrectnessConditionInterface> correctnessConditions = new ArrayList<>();

    public CorrectnessConditions(Element element) {
        super(element);
    }

    @Override
    public String toString() {
        return "correctness";
    }

    @Override
    public void process() {
        ESX_Processor.actions.actionCorrectnessConditionsBeforeCorrectnessConditions(this);
        for (Element element : getElement().elements())
            getCorrectnessConditions().add((CorrectnessConditionInterface) EsxElementFactory.create(element));
        ESX_Processor.actions.actionCorrectnessConditionsAfterCorrectnessConditions(this);
    }
}
