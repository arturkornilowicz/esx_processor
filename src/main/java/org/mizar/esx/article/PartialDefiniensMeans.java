package org.mizar.esx.article;

import java.util.*;

import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;
import org.mizar.esx.design.EsxElementFactory;

@Setter
@Getter
@NoArgsConstructor

public class PartialDefiniensMeans extends PartialDefiniens {

    private FormulaInterface formula;
    private FormulaInterface guard;

    public PartialDefiniensMeans(Element element) {
        super(element);
    }

    @Override
    public String toString() {
        return formula + " if " + guard;
    }

    @Override
    public void process() {
        ESX_Processor.actions.actionPartialDefiniensMeansBeforeFormula(this);
        setFormula((FormulaInterface) EsxElementFactory.create(getElement().elements().get(0)));
        ESX_Processor.actions.actionPartialDefiniensMeansAfterFormula(this);

        ESX_Processor.actions.actionPartialDefiniensMeansBeforeGuard(this);
        setGuard((FormulaInterface) EsxElementFactory.create(getElement().elements().get(1)));
        ESX_Processor.actions.actionPartialDefiniensMeansAfterGuard(this);
    }
}
