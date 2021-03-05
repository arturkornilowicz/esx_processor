package org.mizar.esx.article;

import java.util.*;

import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;
import org.mizar.esx.design.EsxElementFactory;

@Setter
@Getter
@NoArgsConstructor

public class FlexaryConjunctiveFormula extends BinaryFormula {

    private String bracketed;
    private String position;
    private String sort;

    public FlexaryConjunctiveFormula(Element element) {
        super(element);
        this.bracketed = Misc.assignAttrValue(element, "bracketed");
        this.position = Misc.assignAttrValue(element, "position");
        this.sort = Misc.assignAttrValue(element, "sort");
    }

    @Override
    public String toString() {
        return getArg1() + " &...& " + getArg2();
    }

    @Override
    public void process() {
        ESX_Processor.actions.actionFlexaryConjunctiveFormulaBeforeArg1(this);
        setArg1((FormulaInterface) EsxElementFactory.create(getElement().elements().get(0)));
        ESX_Processor.actions.actionFlexaryConjunctiveFormulaAfterArg1(this);

        ESX_Processor.actions.actionFlexaryConjunctiveFormulaBeforeArg2(this);
        setArg2((FormulaInterface) EsxElementFactory.create(getElement().elements().get(1)));
        ESX_Processor.actions.actionFlexaryConjunctiveFormulaAfterArg2(this);
    }
}
