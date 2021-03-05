package org.mizar.esx.article;

import java.util.*;

import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;
import org.mizar.esx.design.EsxElementFactory;

@Setter
@Getter
@NoArgsConstructor

public class ImplicitlyQualifiedSegment extends EsxElement implements VariableSegmentInterface {

    private String position;

    private Variable variable;
    private TypeInterface type;

    public ImplicitlyQualifiedSegment(Element element) {
        super(element);
        this.position = Misc.assignAttrValue(element, "position");
    }

    @Override
    public String toString() {
        return "" + variable;
    }

    @Override
    public void process() {
        ESX_Processor.actions.actionImplicitlyQualifiedSegmentBeforeVariable(this);
        setVariable((Variable) EsxElementFactory.create(getElement().element("Variable")));
        ESX_Processor.actions.actionImplicitlyQualifiedSegmentAfterVariable(this);

        ESX_Processor.actions.actionImplicitlyQualifiedSegmentBeforeType(this);
        setType((TypeInterface) EsxElementFactory.create(getElement().elements().get(1)));
        ESX_Processor.actions.actionImplicitlyQualifiedSegmentAfterType(this);
    }
}
