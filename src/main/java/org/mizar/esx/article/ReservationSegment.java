package org.mizar.esx.article;

import java.util.*;

import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;
import org.mizar.esx.design.EsxElementFactory;

@Setter
@Getter
@NoArgsConstructor

public class ReservationSegment extends EsxElement {

    private String position;

    private Variables variables;
    private VariableSegments variableSegments;
    private TypeInterface type;

    public ReservationSegment(Element element) {
        super(element);
        this.position = Misc.assignAttrValue(element, "position");
    }

    @Override
    public String toString() {
        return variables + " for " + type;
    }

    @Override
    public void process() {
        ESX_Processor.actions.actionReservationSegmentBeforeVariables(this);
        setVariables((Variables) EsxElementFactory.create(getElement().element("Variables")));
        ESX_Processor.actions.actionReservationSegmentAfterVariables(this);

        ESX_Processor.actions.actionReservationSegmentBeforeVariableSegments(this);
        setVariableSegments((VariableSegments) EsxElementFactory.create(getElement().element("Variable-Segments")));
        ESX_Processor.actions.actionReservationSegmentAfterVariableSegments(this);

        ESX_Processor.actions.actionReservationSegmentBeforeType(this);
        setType((TypeInterface) EsxElementFactory.create(getElement().elements().get(2)));
        ESX_Processor.actions.actionReservationSegmentAfterType(this);
    }
}
