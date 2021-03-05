package org.mizar.esx.article;

import java.util.*;

import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;
import org.mizar.esx.design.EsxElementFactory;

@Setter
@Getter
@NoArgsConstructor

public class BinaryFormula extends EsxElement implements FormulaInterface {

    private FormulaInterface arg1;
    private FormulaInterface arg2;

    public BinaryFormula(Element element) {
        super(element);
    }

    @Override
    public String toString() {
        return arg1 + " " + arg2;
    }

    @Override
    public void process() {
        ESX_Processor.actions.actionBinaryFormulaBeforeArg1(this);
        setArg1((FormulaInterface) EsxElementFactory.create(getElement().elements().get(0)));
        ESX_Processor.actions.actionBinaryFormulaAfterArg1(this);

        ESX_Processor.actions.actionBinaryFormulaBeforeArg2(this);
        setArg2((FormulaInterface) EsxElementFactory.create(getElement().elements().get(1)));
        ESX_Processor.actions.actionBinaryFormulaAfterArg2(this);
    }
}
