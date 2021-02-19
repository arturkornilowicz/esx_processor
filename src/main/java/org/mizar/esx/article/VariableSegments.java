package org.mizar.esx.article;

import java.util.*;
import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;

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
}
