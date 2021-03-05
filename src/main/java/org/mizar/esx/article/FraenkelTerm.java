package org.mizar.esx.article;

import java.util.*;

import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;
import org.mizar.esx.design.EsxElementFactory;

@Setter
@Getter
@NoArgsConstructor

public class FraenkelTerm extends EsxElement implements TermInterface {

    private String position;
    private String sort;

    private VariableSegments variableSegments;
    private TermInterface term;
    private FormulaInterface formula;

    public FraenkelTerm(Element element) {
        super(element);
        this.position = Misc.assignAttrValue(element, "position");
        this.sort = Misc.assignAttrValue(element, "sort");
    }

    @Override
    public String toString() {
        return "{" + term + " " + variableSegments + " : " + formula + "}";
    }

    @Override
    public void process() {
        ESX_Processor.actions.actionFraenkelTermBeforeVariableSegments(this);
        setVariableSegments((VariableSegments) EsxElementFactory.create(getElement().elements().get(0)));
        ESX_Processor.actions.actionFraenkelTermAfterVariableSegments(this);

        ESX_Processor.actions.actionFraenkelTermBeforeTerm(this);
        setTerm((TermInterface) EsxElementFactory.create(getElement().elements().get(1)));
        ESX_Processor.actions.actionFraenkelTermAfterTerm(this);

        ESX_Processor.actions.actionFraenkelTermBeforeFormula(this);
        setFormula((FormulaInterface) EsxElementFactory.create(getElement().elements().get(2)));
        ESX_Processor.actions.actionFraenkelTermAfterFormula(this);
    }
}
