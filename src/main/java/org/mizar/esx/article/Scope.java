package org.mizar.esx.article;

import java.util.*;

import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;
import org.mizar.esx.design.EsxElementFactory;

@Setter
@Getter
@NoArgsConstructor

public class Scope extends EsxElement {

    FormulaInterface formula;

    public Scope(Element element) {
        super(element);
    }

    @Override
    public String toString() {
        return "" + formula;
    }

    @Override
    public void process() {
        ESX_Processor.actions.actionScopeBeforeFormula(this);
        setFormula((FormulaInterface) EsxElementFactory.create(getElement().elements().get(0)));
        ESX_Processor.actions.actionScopeAfterFormula(this);
    }
}
