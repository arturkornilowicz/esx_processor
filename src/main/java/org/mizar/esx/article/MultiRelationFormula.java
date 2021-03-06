package org.mizar.esx.article;

import java.util.*;

import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;
import org.mizar.esx.design.EsxElementFactory;

@Setter
@Getter
@NoArgsConstructor

public class MultiRelationFormula extends EsxElement implements FormulaInterface {

    private String position;
    private String sort;

    private FormulaInterface formula;
    private ArrayList<RightSideOfRelationFormula> rightFormulas = new ArrayList<>();

    public MultiRelationFormula(Element element) {
        super(element);
        this.position = Misc.assignAttrValue(element, "position");
        this.sort = Misc.assignAttrValue(element, "sort");
    }

    @Override
    public String toString() {
        return formula + " .= " + rightFormulas;
    }

    @Override
    public void process() {
        ESX_Processor.actions.actionMultiRelationFormulaBeforeFormula(this);
        setFormula((FormulaInterface) EsxElementFactory.create(getElement().elements().get(0)));
        ESX_Processor.actions.actionMultiRelationFormulaAfterFormula(this);

        ESX_Processor.actions.actionMultiRelationFormulaBeforeRightSideOfRelationFormula(this);
        for (int i = 1; i < getElement().elements().size(); i++)
            getRightFormulas().add((RightSideOfRelationFormula) EsxElementFactory.create(getElement().elements().get(i)));
        ESX_Processor.actions.actionMultiRelationFormulaAfterRightSideOfRelationFormula(this);
    }
}
