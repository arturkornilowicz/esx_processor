package org.mizar.esx.article;

import java.util.*;
import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;

@Setter
@Getter
@NoArgsConstructor

public class MultiRelationFormula extends EsxElement implements FormulaInterface {

    private String position;
    private String sort;

    private FormulaInterface formula;
    private ArrayList<RightSideOfRelationFormula> rightFormulas = new ArrayList<>();

    public MultiRelationFormula(Element element) {
        super(element);
        this.position = Misc.assignAttrValue(element,"position");
        this.sort = Misc.assignAttrValue(element,"sort");
    }

    @Override
    public String toString() {
        return formula + " .= " + rightFormulas;
    }
}
