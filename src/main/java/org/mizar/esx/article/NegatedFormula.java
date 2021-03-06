package org.mizar.esx.article;

import java.util.*;

import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;
import org.mizar.esx.design.EsxElementFactory;

@Setter
@Getter
@NoArgsConstructor

public class NegatedFormula extends UnaryFormula {

    private String bracketed;
    private String position;
    private String sort;

    public NegatedFormula(Element element) {
        super(element);
        this.bracketed = Misc.assignAttrValue(element, "bracketed");
        this.position = Misc.assignAttrValue(element, "position");
        this.sort = Misc.assignAttrValue(element, "sort");
    }

    @Override
    public String toString() {
        return "not " + getArg();
    }

    @Override
    public void process() {
        ESX_Processor.actions.actionNegatedFormulaBeforeArg(this);
        setArg((FormulaInterface) EsxElementFactory.create(getElement().elements().get(0)));
        ESX_Processor.actions.actionNegatedFormulaAfterArg(this);
    }
}
