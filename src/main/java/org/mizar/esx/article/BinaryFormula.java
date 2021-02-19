package org.mizar.esx.article;

import java.util.*;
import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;

@Setter
@Getter
@NoArgsConstructor

public class BinaryFormula extends EsxElement implements FormulaInterface {

    private FormulaInterface arg1;
    private FormulaInterface arg2;

    public BinaryFormula(Element element) {
        super(element);
    }

    @Override
    public String toString() {
        return arg1 + " " + arg2;
    }
}
