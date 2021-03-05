package org.mizar.esx.article;

import java.util.*;

import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;
import org.mizar.esx.design.EsxElementFactory;

@Setter
@Getter
@NoArgsConstructor

public class ExpandableMode extends EsxElement implements ModeDescriptionInterface {

    private TypeInterface type;

    public ExpandableMode(Element element) {
        super(element);
    }

    @Override
    public String toString() {
        return "is " + type;
    }

    @Override
    public void process() {
        ESX_Processor.actions.actionExpandableModeBeforeType(this);
        setType((TypeInterface) EsxElementFactory.create(getElement().elements().get(0)));
        ESX_Processor.actions.actionExpandableModeAfterType(this);
    }
}
