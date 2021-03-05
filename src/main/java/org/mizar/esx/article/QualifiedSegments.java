package org.mizar.esx.article;

import java.util.*;

import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;
import org.mizar.esx.design.EsxElementFactory;

@Setter
@Getter
@NoArgsConstructor

public class QualifiedSegments extends EsxElement {

    private ArrayList<VariableSegmentInterface> qualifiedSegments = new ArrayList<>();

    public QualifiedSegments(Element element) {
        super(element);
    }

    @Override
    public String toString() {
        return qualifiedSegments.toString();
    }

    @Override
    public void process() {
        ESX_Processor.actions.actionQualifiedSegmentsBefore(this);
        for (Element element : getElement().elements()) {
            getQualifiedSegments().add((VariableSegmentInterface) EsxElementFactory.create(element));
        }
        ESX_Processor.actions.actionQualifiedSegmentsAfter(this);
    }
}
