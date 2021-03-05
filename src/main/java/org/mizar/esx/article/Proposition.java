package org.mizar.esx.article;

import java.util.*;

import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;
import org.mizar.esx.design.EsxElementFactory;

@Setter
@Getter
@NoArgsConstructor

public class Proposition extends EsxElement {

    private String position;

    private Label label;
    private FormulaInterface formula;

    public Proposition(Element element) {
        super(element);
        this.position = Misc.assignAttrValue(element, "position");
    }

    @Override
    public String toString() {
        return label + " " + formula;
    }

    @Override
    public void process() {
        ESX_Processor.actions.actionPropositionBeforeLabel(this);
        setLabel((Label) EsxElementFactory.create(getElement().element("Label")));
        ESX_Processor.actions.actionPropositionAfterLabel(this);

        ESX_Processor.actions.actionPropositionBeforeFormula(this);
        setFormula((FormulaInterface) EsxElementFactory.create(getElement().elements().get(1)));
        ESX_Processor.actions.actionPropositionAfterFormula(this);
    }
}
