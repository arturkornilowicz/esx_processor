package org.mizar.esx.article;

import java.util.*;

import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;
import org.mizar.esx.design.EsxElementFactory;

@Setter
@Getter
@NoArgsConstructor

public class FunctorDefinition extends Item {

    private String MMLId;

    private Redefine redefine;
    private PatternInterface pattern;
    private TypeSpecification typeSpecification;
    private Definiens definiens;

    public FunctorDefinition(Element element) {
        super(element);
        this.MMLId = Misc.assignAttrValue(element, "MMLId");
    }

    @Override
    public String toString() {
        return redefine + "func " + pattern + " " + typeSpecification + "\n" + definiens;
    }

    @Override
    public void process() {
        ESX_Processor.actions.actionFunctorDefinitionBeforeRedefine(this);
        setRedefine((Redefine) EsxElementFactory.create(getElement().element("Redefine")));
        ESX_Processor.actions.actionFunctorDefinitionAfterRedefine(this);

        ESX_Processor.actions.actionFunctorDefinitionBeforePattern(this);
        setPattern((PatternInterface) EsxElementFactory.create(getElement().elements().get(1)));
        ESX_Processor.actions.actionFunctorDefinitionAfterPattern(this);

        ESX_Processor.actions.actionFunctorDefinitionBeforeTypeSpecification(this);
        setTypeSpecification((TypeSpecification) EsxElementFactory.create(getElement().element("Type-Specification")));
        ESX_Processor.actions.actionFunctorDefinitionAfterTypeSpecification(this);

        ESX_Processor.actions.actionFunctorDefinitionBeforeDefiniens(this);
// TODO
        //        setDefiniens((Definiens)EsxElementFactory.create(getElement().element("Definiens")));
        setDefiniens(ESX_Processor.processDefiniens(getElement().element("Definiens")));
        ESX_Processor.actions.actionFunctorDefinitionAfterDefiniens(this);
    }
}
