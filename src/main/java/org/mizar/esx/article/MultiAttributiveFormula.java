package org.mizar.esx.article;

import java.util.*;

import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;
import org.mizar.esx.design.EsxElementFactory;

@Setter
@Getter
@NoArgsConstructor

public class MultiAttributiveFormula extends EsxElement implements FormulaInterface {

    private String bracketed;
    private String position;
    private String sort;

    private TermInterface subject;
    private AdjectiveCluster adjectiveCluster;

    public MultiAttributiveFormula(Element element) {
        super(element);
        this.bracketed = Misc.assignAttrValue(element, "bracketed");
        this.position = Misc.assignAttrValue(element, "position");
        this.sort = Misc.assignAttrValue(element, "sort");
    }

    @Override
    public String toString() {
        return subject + " is " + adjectiveCluster;
    }

    @Override
    public void process() {
        ESX_Processor.actions.actionMultiAttributiveFormulaBeforeTerm(this);
        setSubject((TermInterface) EsxElementFactory.create(getElement().elements().get(0)));
        ESX_Processor.actions.actionMultiAttributiveFormulaAfterTerm(this);

        ESX_Processor.actions.actionMultiAttributiveFormulaBeforeAdjectiveCluster(this);
        setAdjectiveCluster((AdjectiveCluster) EsxElementFactory.create(getElement().element("Adjective-Cluster")));
        ESX_Processor.actions.actionMultiAttributiveFormulaAfterAdjectiveCluster(this);
    }
}
