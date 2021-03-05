package org.mizar.esx.article;

import java.util.*;

import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;
import org.mizar.esx.design.EsxElementFactory;

@Setter
@Getter
@NoArgsConstructor

public class StandardMode extends EsxElement implements ModeDescriptionInterface {

    private TypeSpecification typeSpecification;
    private Definiens definiens;

    public StandardMode(Element element) {
        super(element);
    }

    @Override
    public String toString() {
        return typeSpecification + "\n" + definiens;
    }

    @Override
    public void process() {
        ESX_Processor.actions.actionStandardModeBeforeTypeSpecification(this);
        setTypeSpecification((TypeSpecification) EsxElementFactory.create(getElement().element("Type-Specification")));
        ESX_Processor.actions.actionStandardModeAfterTypeSpecification(this);

        ESX_Processor.actions.actionStandardModeBeforeDefiniens(this);
        // TODO
//        setDefiniens((Definiens) EsxElementFactory.create(getElement().element("Definiens")));
        setDefiniens(ESX_Processor.processDefiniens(getElement().element("Definiens")));
        ESX_Processor.actions.actionStandardModeAfterDefiniens(this);
    }
}
