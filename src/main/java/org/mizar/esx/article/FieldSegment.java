package org.mizar.esx.article;

import java.util.*;
import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;

@Setter
@Getter
@NoArgsConstructor

public class FieldSegment extends EsxElement {

    private String position;

    private Selectors selectors;
    private TypeInterface type;

    public FieldSegment(Element element) {
        super(element);
        this.position = Misc.assignAttrValue(element,"position");
    }

    @Override
    public String toString() {
        return selectors + " -> " + type;
    }
}
