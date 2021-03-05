package org.mizar.esx.article;

import java.util.*;

import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;
import org.mizar.esx.design.EsxElementFactory;

@Setter
@Getter
@NoArgsConstructor

public class VariableSegments extends EsxElement {

    private ArrayList<VariableSegmentInterface> variableSegments = new ArrayList<>();

    public VariableSegments(Element element) {
        super(element);
    }

    @Override
    public String toString() {
        return variableSegments.toString();
    }

    @Override
    public void process() {
        ESX_Processor.actions.actionVariableSegmentsBefore(this);
        for (Element element : getElement().elements())
            getVariableSegments().add((VariableSegmentInterface) EsxElementFactory.create(element));
        ESX_Processor.actions.actionVariableSegmentsAfter(this);
    }
}
