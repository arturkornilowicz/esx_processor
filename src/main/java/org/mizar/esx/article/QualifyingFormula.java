package org.mizar.esx.article;

import java.util.*;

import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;
import org.mizar.esx.design.EsxElementFactory;

@Setter
@Getter
@NoArgsConstructor

public class QualifyingFormula extends EsxElement implements FormulaInterface {

    private String bracketed;
    private String position;
    private String sort;

    private TermInterface term;
    private TypeInterface type;

    public QualifyingFormula(Element element) {
        super(element);
        this.bracketed = Misc.assignAttrValue(element, "bracketed");
        this.position = Misc.assignAttrValue(element, "position");
        this.sort = Misc.assignAttrValue(element, "sort");
    }

    @Override
    public String toString() {
        return term + " is " + type;
    }

    @Override
    public void process() {
        ESX_Processor.actions.actionQualifyingFormulaBeforeTerm(this);
        setTerm((TermInterface) EsxElementFactory.create(getElement().elements().get(0)));
        ESX_Processor.actions.actionQualifyingFormulaAfterTerm(this);

        ESX_Processor.actions.actionQualifyingFormulaBeforeType(this);
        setType((TypeInterface) EsxElementFactory.create(getElement().elements().get(1)));
        ESX_Processor.actions.actionQualifyingFormulaAfterType(this);
    }
}
