package org.mizar.esx.article;

import java.util.*;

import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;
import org.mizar.esx.design.EsxElementFactory;

@Setter
@Getter
@NoArgsConstructor

public class AggregateTerm extends EsxElement implements TermInterface {

    private String absoluteconstrMMLId;
    private String absolutepatternMMLId;
    private String constrnr;
    private String formatnr;
    private String nr;
    private String patternnr;
    private String position;
    private String sort;
    private String spelling;

    private Arguments arguments;

    public AggregateTerm(Element element) {
        super(element);
        this.absoluteconstrMMLId = Misc.assignAttrValue(element, "absoluteconstrMMLId");
        this.absolutepatternMMLId = Misc.assignAttrValue(element, "absolutepatternMMLId");
        this.constrnr = Misc.assignAttrValue(element, "constrnr");
        this.formatnr = Misc.assignAttrValue(element, "formatnr");
        this.nr = Misc.assignAttrValue(element, "nr");
        this.patternnr = Misc.assignAttrValue(element, "patternnr");
        this.position = Misc.assignAttrValue(element, "position");
        this.sort = Misc.assignAttrValue(element, "sort");
        this.spelling = Misc.assignAttrValue(element, "spelling");
    }

    @Override
    public String toString() {
        return spelling + "(#" + arguments + "#)";
    }

    @Override
    public void process() {
        ESX_Processor.actions.actionAggregateTermBeforeArguments(this);
        setArguments((Arguments) EsxElementFactory.create(getElement().element("Arguments")));
        ESX_Processor.actions.actionAggregateTermAfterArguments(this);
    }
}
