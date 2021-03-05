package org.mizar.esx.article;

import java.util.*;

import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;
import org.mizar.esx.design.EsxElementFactory;

@Setter
@Getter
@NoArgsConstructor

public class Reduction extends Item {

    private TermInterface leftTerm;
    private TermInterface rightTerm;

    public Reduction(Element element) {
        super(element);
    }

    @Override
    public String toString() {
        return "reduce " + leftTerm + " to " + rightTerm;
    }

    @Override
    public void process() {
        ESX_Processor.actions.actionReductionBeforeLeftTerm(this);
        setLeftTerm((TermInterface) EsxElementFactory.create(getElement().elements().get(0)));
        ESX_Processor.actions.actionReductionAfterLeftTerm(this);

        ESX_Processor.actions.actionReductionBeforeRightTerm(this);
        setRightTerm((TermInterface) EsxElementFactory.create(getElement().elements().get(1)));
        ESX_Processor.actions.actionReductionAfterRightTerm(this);
    }
}
