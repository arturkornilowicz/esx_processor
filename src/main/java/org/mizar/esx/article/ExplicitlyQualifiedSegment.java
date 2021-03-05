package org.mizar.esx.article;

import java.util.*;

import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;
import org.mizar.esx.design.EsxElementFactory;

@Setter
@Getter
@NoArgsConstructor

public class ExplicitlyQualifiedSegment extends EsxElement implements VariableSegmentInterface {

    private String position;

    private Variables variables;
    private TypeInterface type;

    public ExplicitlyQualifiedSegment(Element element) {
        super(element);
        this.position = Misc.assignAttrValue(element, "position");
    }

    @Override
    public String toString() {
        return variables + " " + type;
    }

    @Override
    public void process() {
        ESX_Processor.actions.actionExplicitlyQualifiedSegmentBeforeVariables(this);
        setVariables((Variables) EsxElementFactory.create(getElement().element("Variables")));
        ESX_Processor.actions.actionExplicitlyQualifiedSegmentAfterVariables(this);

        ESX_Processor.actions.actionExplicitlyQualifiedSegmentBeforeType(this);
        setType((TypeInterface) EsxElementFactory.create(getElement().elements().get(1)));
        ESX_Processor.actions.actionExplicitlyQualifiedSegmentAfterType(this);
    }
}
