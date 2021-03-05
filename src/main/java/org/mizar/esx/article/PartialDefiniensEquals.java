package org.mizar.esx.article;

import java.util.*;

import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;
import org.mizar.esx.design.EsxElementFactory;

@Setter
@Getter
@NoArgsConstructor

public class PartialDefiniensEquals extends PartialDefiniens {

    private TermInterface term;
    private FormulaInterface guard;

    public PartialDefiniensEquals(Element element) {
        super(element);
    }

    @Override
    public String toString() {
        return term + " if " + guard;
    }

    @Override
    public void process() {
        ESX_Processor.actions.actionPartialDefiniensEqualsBeforeTerm(this);
        setTerm((TermInterface) EsxElementFactory.create(getElement().elements().get(0)));
        ESX_Processor.actions.actionPartialDefiniensEqualsAfterTerm(this);

        ESX_Processor.actions.actionPartialDefiniensEqualsBeforeGuard(this);
        setGuard((FormulaInterface) EsxElementFactory.create(getElement().elements().get(1)));
        ESX_Processor.actions.actionPartialDefiniensEqualsAfterGuard(this);
    }
}
