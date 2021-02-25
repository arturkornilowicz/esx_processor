package org.mizar.esx.article;

import java.util.*;
import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;

@Setter
@Getter
@NoArgsConstructor

public class StructureDefinition extends Item {

    private Ancestors ancestors;
    private PatternInterface pattern;
    private FieldSegments fieldSegments;
    private StructurePatternsRendering structurePatternsRendering;

    public StructureDefinition(Element element) {
        super(element);
    }

    @Override
    public String toString() {
        return ancestors + " " + pattern + "\n(#" + fieldSegments + "#)" + "\nRENDER: " + structurePatternsRendering;
    }
}
