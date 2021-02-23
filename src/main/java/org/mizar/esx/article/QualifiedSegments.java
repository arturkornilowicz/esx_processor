package org.mizar.esx.article;

import java.util.*;
import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;

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
}
