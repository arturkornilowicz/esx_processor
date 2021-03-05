package org.mizar.esx.article;

import java.util.*;

import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;
import org.mizar.esx.design.EsxElementFactory;

@Setter
@Getter
@NoArgsConstructor

public class FreeVariableSegment extends EsxElement implements VariableSegmentInterface {

    private String position;

    private Variable variable;
    private TypeInterface type;

    public FreeVariableSegment(Element element) {
        super(element);
        this.position = Misc.assignAttrValue(element, "position");
    }

    @Override
    public String toString() {
        return variable.toString();
    }

    @Override
    public void process() {
        ESX_Processor.actions.actionFreeVariableSegmentBeforeVariable(this);
        setVariable((Variable) EsxElementFactory.create(getElement().element("Variable")));
        ESX_Processor.actions.actionFreeVariableSegmentAfterVariable(this);

        ESX_Processor.actions.actionFreeVariableSegmentBeforeType(this);
        setType((TypeInterface) EsxElementFactory.create(getElement().elements().get(1)));
        ESX_Processor.actions.actionFreeVariableSegmentAfterType(this);
    }
}
