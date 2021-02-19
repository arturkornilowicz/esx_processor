package org.mizar.esx.article;

import java.util.*;
import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;

@Setter
@Getter
@NoArgsConstructor

public class UnaryFormula extends EsxElement implements FormulaInterface {

    private FormulaInterface arg;

    public UnaryFormula(Element element) {
        super(element);
    }

    @Override
    public String toString() {
        return arg.toString();
    }
}
