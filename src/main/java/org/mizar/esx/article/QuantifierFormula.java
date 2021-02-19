package org.mizar.esx.article;

import java.util.*;
import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;

@Setter
@Getter
@NoArgsConstructor

public class QuantifierFormula extends EsxElement implements FormulaInterface {

    private VariableSegments variableSegments;
    private FormulaInterface scope;

    public QuantifierFormula(Element element) {
        super(element);
    }

    @Override
    public String toString() {
        return variableSegments + " " + scope;
    }
}
