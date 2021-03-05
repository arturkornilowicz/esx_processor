package org.mizar.esx.article;

import java.util.*;

import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;
import org.mizar.esx.design.EsxElementFactory;

@Setter
@Getter
@NoArgsConstructor

public class CorrectnessCondition extends Item {

    private CorrectnessConditionInterface correctnessCondition;
    private JustificationInterface justification;

    public CorrectnessCondition(Element element) {
        super(element);
    }

    @Override
    public String toString() {
        return correctnessCondition + " " + justification;
    }

    @Override
    public void process() {
        ESX_Processor.actions.actionCorrectnessConditionBeforeCorrectnessCondition(this);
        setCorrectnessCondition((CorrectnessConditionInterface) EsxElementFactory.create(getElement().elements().get(0)));
        ESX_Processor.actions.actionCorrectnessConditionAfterCorrectnessCondition(this);

        ESX_Processor.actions.actionCorrectnessConditionBeforeJustification(this);
        setJustification((JustificationInterface) EsxElementFactory.create(getElement().elements().get(1)));
        ESX_Processor.actions.actionCorrectnessConditionAfterJustification(this);
    }
}
