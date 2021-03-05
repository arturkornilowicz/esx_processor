package org.mizar.esx.article;

import java.util.*;

import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;
import org.mizar.esx.design.EsxElementFactory;

@Setter
@Getter
@NoArgsConstructor

public class UniversalQuantifierFormula extends QuantifierFormula {

    private String bracketed;
    private String position;
    private String sort;

    private Restriction restriction;

    public UniversalQuantifierFormula(Element element) {
        super(element);
        this.bracketed = Misc.assignAttrValue(element, "bracketed");
        this.position = Misc.assignAttrValue(element, "position");
        this.sort = Misc.assignAttrValue(element, "sort");
    }

    @Override
    public String toString() {
        return "for " + getVariableSegments() + (restriction != null ? " st " + restriction : "") + " holds " + getScope();
    }

    @Override
    public void process() {
        ESX_Processor.actions.actionUniversalQuantifierFormulaBeforeVariableSegments(this);
        setVariableSegments((VariableSegments) EsxElementFactory.create(getElement().element("Variable-Segments")));
        ESX_Processor.actions.actionUniversalQuantifierFormulaAfterVariableSegments(this);

        ESX_Processor.actions.actionUniversalQuantifierFormulaBeforeRestriction(this);
        setRestriction((Restriction) EsxElementFactory.create(getElement().element("Restriction")));
        ESX_Processor.actions.actionUniversalQuantifierFormulaAfterRestriction(this);

        ESX_Processor.actions.actionUniversalQuantifierFormulaBeforeScope(this);
        setScope((Scope) EsxElementFactory.create(getElement().element("Scope")));
        ESX_Processor.actions.actionUniversalQuantifierFormulaAfterScope(this);
    }
}
