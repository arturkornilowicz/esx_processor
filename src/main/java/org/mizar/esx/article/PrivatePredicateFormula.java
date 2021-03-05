package org.mizar.esx.article;

import java.util.*;

import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;
import org.mizar.esx.design.EsxElementFactory;

@Setter
@Getter
@NoArgsConstructor

public class PrivatePredicateFormula extends EsxElement implements FormulaInterface {

    private String constrnr;
    private String idnr;
    private String nr;
    private String position;
    private String serialnr;
    private String sort;
    private String spelling;

    private Arguments arguments;

    public PrivatePredicateFormula(Element element) {
        super(element);
        this.constrnr = Misc.assignAttrValue(element, "constrnr");
        this.idnr = Misc.assignAttrValue(element, "idnr");
        this.nr = Misc.assignAttrValue(element, "nr");
        this.position = Misc.assignAttrValue(element, "position");
        this.serialnr = Misc.assignAttrValue(element, "serialnr");
        this.sort = Misc.assignAttrValue(element, "sort");
        this.spelling = Misc.assignAttrValue(element, "spelling");
    }

    @Override
    public String toString() {
        return spelling + "[" + arguments + "]";
    }

    @Override
    public void process() {
        ESX_Processor.actions.actionPrivatePredicateFormulaBeforeArguments(this);
        setArguments((Arguments) EsxElementFactory.create(getElement().element("Arguments")));
        ESX_Processor.actions.actionPrivatePredicateFormulaAfterArguments(this);
    }
}
