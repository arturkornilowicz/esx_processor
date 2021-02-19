package org.mizar.esx.article;

import java.util.*;
import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;

@Setter
@Getter
@NoArgsConstructor

public class FreeVariableSegment extends EsxElement implements VariableSegmentInterface {

    private String position;

    private Variable variable;
    private TypeInterface type;

    public FreeVariableSegment(Element element) {
        super(element);
        this.position = Misc.assignAttrValue(element,"position");
    }

    @Override
    public String toString() {
        return variable.toString();
    }
}
