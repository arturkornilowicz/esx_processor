package org.mizar.esx.article;

import java.util.*;
import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;

@Setter
@Getter
@NoArgsConstructor

public class PredicateSegment extends EsxElement implements SchemaInputSegment {

    private String position;

    private Variables variables;
    private TypeList argumentTypes;

    public PredicateSegment(Element element) {
        super(element);
        this.position = Misc.assignAttrValue(element,"position");
    }

    @Override
    public String toString() {
        return variables + "[" + argumentTypes + "]";
    }
}
