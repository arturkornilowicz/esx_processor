package org.mizar.esx.article;

import java.util.*;

import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;
import org.mizar.esx.design.EsxElementFactory;

@Setter
@Getter
@NoArgsConstructor

public class ExistentialQuantifierFormula extends QuantifierFormula {

    private String bracketed;
    private String position;
    private String sort;

    public ExistentialQuantifierFormula(Element element) {
        super(element);
        this.bracketed = Misc.assignAttrValue(element, "bracketed");
        this.position = Misc.assignAttrValue(element, "position");
        this.sort = Misc.assignAttrValue(element, "sort");
    }

    @Override
    public String toString() {
        return "ex " + getVariableSegments() + " st " + getScope();
    }

    @Override
    public void process() {
        ESX_Processor.actions.actionExistentialQuantifierFormulaBeforeVariableSegments(this);
        setVariableSegments((VariableSegments) EsxElementFactory.create(getElement().element("Variable-Segments")));
        ESX_Processor.actions.actionExistentialQuantifierFormulaAfterVariableSegments(this);

        ESX_Processor.actions.actionExistentialQuantifierFormulaBeforeScope(this);
        setScope((Scope) EsxElementFactory.create(getElement().element("Scope")));
        ESX_Processor.actions.actionExistentialQuantifierFormulaAfterScope(this);
    }
}
