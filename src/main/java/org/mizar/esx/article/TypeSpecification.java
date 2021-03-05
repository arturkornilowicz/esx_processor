package org.mizar.esx.article;

import java.util.*;

import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;
import org.mizar.esx.design.EsxElementFactory;

@Setter
@Getter
@NoArgsConstructor

public class TypeSpecification extends EsxElement {

    private TypeInterface type;

    public TypeSpecification(Element element) {
        super(element);
    }

    @Override
    public String toString() {
        return type != null ? "-> " + type.toString() : "";
    }

    @Override
    public void process() {
        if (getElement() != null) {
            ESX_Processor.actions.actionTypeSpecificationBeforeType(this);
            setType((TypeInterface) EsxElementFactory.create(getElement().elements().get(0)));
            ESX_Processor.actions.actionTypeSpecificationAfterType(this);
        }
    }
}
