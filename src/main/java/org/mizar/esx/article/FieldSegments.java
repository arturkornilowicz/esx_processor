package org.mizar.esx.article;

import java.util.*;

import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;
import org.mizar.esx.design.EsxElementFactory;

@Setter
@Getter
@NoArgsConstructor

public class FieldSegments extends EsxElement {

    private ArrayList<FieldSegment> fieldSegments = new ArrayList<>();

    public FieldSegments(Element element) {
        super(element);
    }

    @Override
    public String toString() {
        return fieldSegments.toString();
    }

    @Override
    public void process() {
        ESX_Processor.actions.actionFieldSegmentsBefore(this);
        for (Element element : getElement().elements())
            getFieldSegments().add((FieldSegment) EsxElementFactory.create(element));
        ESX_Processor.actions.actionFieldSegmentsAfter(this);
    }
}
