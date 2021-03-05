package org.mizar.esx.article;

import java.util.*;

import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;
import org.mizar.esx.design.EsxElementFactory;

@Setter
@Getter
@NoArgsConstructor

public class Correctness extends Item {

    private CorrectnessConditions correctnessConditions;
    private JustificationInterface justification;

    public Correctness(Element element) {
        super(element);
    }

    @Override
    public String toString() {
        return correctnessConditions + " " + justification;
    }

    @Override
    public void process() {
        ESX_Processor.actions.actionCorrectnessBeforeCorrectnessConditions(this);
        setCorrectnessConditions((CorrectnessConditions) EsxElementFactory.create(getElement().element("Correctness-Conditions")));
        ESX_Processor.actions.actionCorrectnessAfterCorrectnessConditions(this);

        ESX_Processor.actions.actionCorrectnessBeforeJustification(this);
        setJustification((JustificationInterface) EsxElementFactory.create(getElement().elements().get(1)));
        ESX_Processor.actions.actionCorrectnessAfterJustification(this);
    }
}
