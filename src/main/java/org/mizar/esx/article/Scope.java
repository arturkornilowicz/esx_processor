package org.mizar.esx.article;

import java.util.*;
import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;

@Setter
@Getter
@NoArgsConstructor

public class Scope extends EsxElement {

    FormulaInterface formula;

    public Scope(Element element) {
        super(element);
    }

    @Override
    public String toString() {
        return formula.toString();
    }
}
