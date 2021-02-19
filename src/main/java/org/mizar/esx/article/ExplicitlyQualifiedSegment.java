package org.mizar.esx.article;

import java.util.*;
import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;

@Setter
@Getter
@NoArgsConstructor

public class ExplicitlyQualifiedSegment extends EsxElement implements VariableSegmentInterface {

    private String position;

    private Variables variables;
    private TypeInterface type;

    public ExplicitlyQualifiedSegment(Element element) {
        super(element);
        this.position = Misc.assignAttrValue(element,"position");
    }

    @Override
    public String toString() {
        return variables + " " + type;
    }
}
