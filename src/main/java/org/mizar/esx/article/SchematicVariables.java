package org.mizar.esx.article;

import java.util.*;
import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;

@Setter
@Getter
@NoArgsConstructor

public class SchematicVariables extends EsxElement {

    private ArrayList<SchemaInputSegment> segments = new ArrayList<>();

    public SchematicVariables(Element element) {
        super(element);
    }

    @Override
    public String toString() {
        return segments.toString();
    }
}
