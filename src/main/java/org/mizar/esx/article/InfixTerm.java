package org.mizar.esx.article;

import java.util.*;

import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;
import org.mizar.esx.design.EsxElementFactory;

@Setter
@Getter
@NoArgsConstructor

public class InfixTerm extends EsxElement implements TermInterface {

    private String absoluteconstrMMLId;
    private String absoluteorigconstrMMLId;
    private String absolutepatternMMLId;
    private String constrnr;
    private String formatnr;
    private String leftargscount;
    private String nr;
    private String originalnr;
    private String patternnr;
    private String position;
    private String sort;
    private String spelling;

    private Arguments arguments;

    public InfixTerm(Element element) {
        super(element);
        this.absoluteconstrMMLId = Misc.assignAttrValue(element, "absoluteconstrMMLId");
        this.absoluteorigconstrMMLId = Misc.assignAttrValue(element, "absoluteorigconstrMMLId");
        this.absolutepatternMMLId = Misc.assignAttrValue(element, "absolutepatternMMLId");
        this.constrnr = Misc.assignAttrValue(element, "constrnr");
        this.formatnr = Misc.assignAttrValue(element, "formatnr");
        this.leftargscount = Misc.assignAttrValue(element, "leftargscount");
        this.nr = Misc.assignAttrValue(element, "nr");
        this.originalnr = Misc.assignAttrValue(element, "originalnr");
        this.patternnr = Misc.assignAttrValue(element, "patternnr");
        this.position = Misc.assignAttrValue(element, "position");
        this.sort = Misc.assignAttrValue(element, "sort");
        this.spelling = Misc.assignAttrValue(element, "spelling");
    }

    @Override
    public String toString() {
        return spelling + " [" + arguments + "]";
    }

    @Override
    public void process() {
        ESX_Processor.actions.actionInfixTermBeforeArguments(this);
        setArguments((Arguments) EsxElementFactory.create(getElement().element("Arguments")));
        ESX_Processor.actions.actionInfixTermAfterArguments(this);
    }
}
