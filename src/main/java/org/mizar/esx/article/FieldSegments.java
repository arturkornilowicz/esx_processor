package org.mizar.esx.article;

import java.util.*;
import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;

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
}
