package org.mizar.esx.article;

import java.util.*;
import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;

@Setter
@Getter
@NoArgsConstructor

public class ReservationSegment extends EsxElement {

    private String position;

    private Variables variables;
    private VariableSegments variableSegments;
    private TypeInterface type;

    public ReservationSegment(Element element) {
        super(element);
        this.position = Misc.assignAttrValue(element,"position");
    }

    @Override
    public String toString() {
        return variables + " for " + type;
    }
}
