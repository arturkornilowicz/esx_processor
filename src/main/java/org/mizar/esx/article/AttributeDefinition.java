package org.mizar.esx.article;

import java.util.*;

import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;
import org.mizar.esx.design.EsxElementFactory;

@Setter
@Getter
@NoArgsConstructor

public class AttributeDefinition extends Item {

    private String MMLId;

    private Redefine redefine;
    private AttributePattern pattern;
    private Definiens definiens;

    public AttributeDefinition(Element element) {
        super(element);
        this.MMLId = Misc.assignAttrValue(element, "MMLId");
    }

    @Override
    public String toString() {
        return redefine + "attr " + pattern + "\n" + definiens;
    }

    @Override
    public void process() {
        ESX_Processor.actions.actionAttributeDefinitionBeforeRedefine(this);
        setRedefine((Redefine) EsxElementFactory.create(getElement().element("Redefine")));
        ESX_Processor.actions.actionAttributeDefinitionAfterRedefine(this);

        ESX_Processor.actions.actionAttributeDefinitionBeforePattern(this);
        setPattern((AttributePattern) EsxElementFactory.create(getElement().elements().get(1)));
        ESX_Processor.actions.actionAttributeDefinitionAfterPattern(this);

        ESX_Processor.actions.actionAttributeDefinitionBeforeDefiniens(this);
        // TODO
//        setDefiniens((Definiens)EsxElementFactory.create(getElement().element("Definiens")));
        setDefiniens(ESX_Processor.processDefiniens(getElement().element("Definiens")));
        ESX_Processor.actions.actionAttributeDefinitionAfterDefiniens(this);
    }
}
