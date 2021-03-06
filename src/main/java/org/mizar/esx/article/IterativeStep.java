package org.mizar.esx.article;

import java.util.*;

import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;

@Setter
@Getter
@NoArgsConstructor

public class IterativeStep extends EsxElement {

    private String position;

    public IterativeStep(Element element) {
        super(element);
        this.position = Misc.assignAttrValue(element, "position");
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
