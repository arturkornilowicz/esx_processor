package org.mizar.esx.article;

import java.util.*;

import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;
import org.mizar.esx.design.EsxElementFactory;

@Setter
@Getter
@NoArgsConstructor

public class PredicateDefinition extends Item {

    private String MMLId;

    private Redefine redefine;
    private PredicatePattern pattern;
    private Definiens definiens;

    public PredicateDefinition(Element element) {
        super(element);
        this.MMLId = Misc.assignAttrValue(element, "MMLId");
    }

    @Override
    public String toString() {
        return redefine + "pred " + pattern + "\n" + definiens;
    }

    @Override
    public void process() {
        ESX_Processor.actions.actionPredicateDefinitionBeforeRedefine(this);
        setRedefine((Redefine) EsxElementFactory.create(getElement().element("Redefine")));
        ESX_Processor.actions.actionPredicateDefinitionAfterRedefine(this);

        ESX_Processor.actions.actionPredicateDefinitionBeforePattern(this);
        setPattern((PredicatePattern) EsxElementFactory.create(getElement().elements().get(1)));
        ESX_Processor.actions.actionPredicateDefinitionAfterPattern(this);

        ESX_Processor.actions.actionPredicateDefinitionBeforeDefiniens(this);
        //TODO
        //        setDefiniens((Definiens) EsxElementFactory.create(getElement().element("Definiens")));
        setDefiniens(ESX_Processor.processDefiniens(getElement().element("Definiens")));
        ESX_Processor.actions.actionPredicateDefinitionAfterDefiniens(this);
    }
}
