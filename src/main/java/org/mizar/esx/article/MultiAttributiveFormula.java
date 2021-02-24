package org.mizar.esx.article;

import java.util.*;
import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;

@Setter
@Getter
@NoArgsConstructor

public class MultiAttributiveFormula extends EsxElement implements FormulaInterface {

    private String bracketed;
    private String position;
    private String sort;

    private TermInterface subject;
    private AdjectiveCluster adjectiveCluster;

    public MultiAttributiveFormula(Element element) {
        super(element);
        this.bracketed = Misc.assignAttrValue(element,"bracketed");
        this.position = Misc.assignAttrValue(element,"position");
        this.sort = Misc.assignAttrValue(element,"sort");
    }

    @Override
    public String toString() {
        return subject + " is " + adjectiveCluster;
    }
}
