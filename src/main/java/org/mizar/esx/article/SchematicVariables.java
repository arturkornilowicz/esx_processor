package org.mizar.esx.article;

import java.util.*;

import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;
import org.mizar.esx.design.EsxElementFactory;

@Setter
@Getter
@NoArgsConstructor

public class SchematicVariables extends EsxElement {

    private ArrayList<SchemaInputSegmentInterface> segments = new ArrayList<>();

    public SchematicVariables(Element element) {
        super(element);
    }

    @Override
    public String toString() {
        return segments.toString();
    }

    @Override
    public void process() {
        ESX_Processor.actions.actionSchematicVariablesBefore(this);
        for (Element element : getElement().elements())
            getSegments().add((SchemaInputSegmentInterface) EsxElementFactory.create(element));
        ESX_Processor.actions.actionSchematicVariablesAfter(this);
    }
}
