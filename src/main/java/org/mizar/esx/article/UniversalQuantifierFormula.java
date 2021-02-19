package org.mizar.esx.article;

import java.util.*;
import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;

@Setter
@Getter
@NoArgsConstructor

public class UniversalQuantifierFormula extends EsxElement implements FormulaInterface {

    private String bracketed;
    private String position;
    private String sort;

    private VariableSegments variableSegments;
    private FormulaInterface scope;

    public UniversalQuantifierFormula(Element element) {
        super(element);
        this.bracketed = Misc.assignAttrValue(element,"bracketed");
        this.position = Misc.assignAttrValue(element,"position");
        this.sort = Misc.assignAttrValue(element,"sort");
    }

    @Override
    public String toString() {
        return "" + variableSegments + " " + scope;
    }
}
