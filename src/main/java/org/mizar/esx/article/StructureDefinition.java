package org.mizar.esx.article;

import java.util.*;

import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;
import org.mizar.esx.design.EsxElementFactory;

@Setter
@Getter
@NoArgsConstructor

public class StructureDefinition extends Item {

    private Ancestors ancestors;
    private StructurePattern pattern;
    private FieldSegments fieldSegments;
    private StructurePatternsRendering structurePatternsRendering;

    public StructureDefinition(Element element) {
        super(element);
    }

    @Override
    public String toString() {
        return ancestors + " " + pattern + "\n(#" + fieldSegments + "#)" + "\nRENDER: " + structurePatternsRendering;
    }

    @Override
    public void process() {
        ESX_Processor.actions.actionStructureDefinitionBeforeAncestors(this);
        setAncestors((Ancestors) EsxElementFactory.create(getElement().element("Ancestors")));
        ESX_Processor.actions.actionStructureDefinitionAfterAncestors(this);

        ESX_Processor.actions.actionStructureDefinitionBeforePattern(this);
        setPattern((StructurePattern) EsxElementFactory.create(getElement().element("Structure-Pattern")));
        ESX_Processor.actions.actionStructureDefinitionAfterPattern(this);

        ESX_Processor.actions.actionStructureDefinitionBeforeFieldSegments(this);
        setFieldSegments((FieldSegments) EsxElementFactory.create(getElement().element("Field-Segments")));
        ESX_Processor.actions.actionStructureDefinitionAfterFieldSegments(this);

        ESX_Processor.actions.actionStructureDefinitionBeforeStructurePatternsRendering(this);
        setStructurePatternsRendering((StructurePatternsRendering) EsxElementFactory.create(getElement().element("Structure-Patterns-Rendering")));
        ESX_Processor.actions.actionStructureDefinitionAfterStructurePatternsRendering(this);
    }
}
