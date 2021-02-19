package org.mizar.esx.article;

import java.util.*;
import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;

@Setter
@Getter
@NoArgsConstructor

public class QualifyingFormula extends EsxElement implements FormulaInterface {

    private String bracketed;
    private String position;
    private String sort;

    private TermInterface term;
    private TypeInterface type;

    public QualifyingFormula(Element element) {
        super(element);
        this.bracketed = Misc.assignAttrValue(element,"bracketed");
        this.position = Misc.assignAttrValue(element,"position");
        this.sort = Misc.assignAttrValue(element,"sort");
    }

    @Override
    public String toString() {
        return term + " is " + type;
    }
}
