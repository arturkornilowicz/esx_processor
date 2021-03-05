package org.mizar.esx.article;

import java.util.*;

import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;
import org.mizar.esx.design.EsxElementFactory;

@Setter
@Getter
@NoArgsConstructor

public class DefiniensMeans extends Definiens {

    private FormulaInterface formula;

    public DefiniensMeans(Element element) {
        super(element);
    }

    @Override
    public String toString() {
        return formula.toString();
    }

    @Override
    public void process() {
        ESX_Processor.actions.actionDefiniensMeansBeforeFormula(this);
        setFormula((FormulaInterface) EsxElementFactory.create(getElement().elements().get(1)));
        ESX_Processor.actions.actionDefiniensMeansAfterFormula(this);
    }
}
