package org.mizar.esx.article;

import java.util.*;
import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;

@Setter
@Getter
@NoArgsConstructor

public class Proposition extends EsxElement {

    private String position;

    private Label label;
    private FormulaInterface formula;

    public Proposition(Element element) {
        super(element);
        this.position = Misc.assignAttrValue(element,"position");
    }

    @Override
    public String toString() {
        return label + " " + formula;
    }
}
