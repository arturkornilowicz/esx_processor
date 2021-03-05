package org.mizar.esx.article;

import java.util.*;

import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;
import org.mizar.esx.design.EsxElementFactory;

@Setter
@Getter
@NoArgsConstructor

public class Restriction extends EsxElement {

    FormulaInterface formula;

    public Restriction(Element element) {
        super(element);
    }

    @Override
    public String toString() {
        return "" + formula;
    }

    @Override
    public void process() {
        if (getElement() == null)
            return;
        ESX_Processor.actions.actionRestrictionBeforeFormula(this);
        setFormula((FormulaInterface) EsxElementFactory.create(getElement().elements().get(0)));
        ESX_Processor.actions.actionRestrictionAfterFormula(this);
    }
}
