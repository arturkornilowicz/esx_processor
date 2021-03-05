package org.mizar.esx.article;

import java.util.*;

import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;
import org.mizar.esx.design.EsxElementFactory;

@Setter
@Getter
@NoArgsConstructor

public class OtherwiseMeans extends Otherwise {

    private FormulaInterface formula;

    public OtherwiseMeans(Element element) {
        super(element);
    }

    @Override
    public String toString() {
        return "otherwise " + formula;
    }

    @Override
    public void process() {
        if (getElement().elements().size() > 0) {
            ESX_Processor.actions.actionOtherwiseMeansBeforeFormula(this);
            setFormula((FormulaInterface) EsxElementFactory.create(getElement().elements().get(0)));
            ESX_Processor.actions.actionOtherwiseMeansAfterFormula(this);
        }
    }
}
