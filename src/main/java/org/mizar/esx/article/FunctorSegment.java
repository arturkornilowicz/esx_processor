package org.mizar.esx.article;

import java.util.*;
import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;

@Setter
@Getter
@NoArgsConstructor

public class FunctorSegment extends EsxElement implements SchemaInputSegment {

    private String position;

    private Variables variables;
    private TypeList argumentTypes;
    private TypeSpecification resultType;

    public FunctorSegment(Element element) {
        super(element);
        this.position = Misc.assignAttrValue(element,"position");
    }

    @Override
    public String toString() {
        return variables + " (" + argumentTypes + ") " + resultType;
    }
}
