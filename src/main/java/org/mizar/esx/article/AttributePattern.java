package org.mizar.esx.article;

import java.util.*;

import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;
import org.mizar.esx.design.EsxElementFactory;

@Setter
@Getter
@NoArgsConstructor

public class AttributePattern extends EsxElement implements PatternInterface {

    private String absoluteconstrMMLId;
    private String absoluteorigconstrMMLId;
    private String absoluteorigpatternMMLId;
    private String absolutepatternMMLId;
    private String bracketed;
    private String constr;
    private String formatdes;
    private String formatnr;
    private String origconstrnr;
    private String origpatternnr;
    private String patternnr;
    private String position;
    private String spelling;

    private Locus subject;
    private Loci arguments;

    public AttributePattern(Element element) {
        super(element);
        this.absoluteconstrMMLId = Misc.assignAttrValue(element, "absoluteconstrMMLId");
        this.absoluteorigconstrMMLId = Misc.assignAttrValue(element, "absoluteorigconstrMMLId");
        this.absoluteorigpatternMMLId = Misc.assignAttrValue(element, "absoluteorigpatternMMLId");
        this.absolutepatternMMLId = Misc.assignAttrValue(element, "absolutepatternMMLId");
        this.bracketed = Misc.assignAttrValue(element, "bracketed");
        this.constr = Misc.assignAttrValue(element, "constr");
        this.formatdes = Misc.assignAttrValue(element, "formatdes");
        this.formatnr = Misc.assignAttrValue(element, "formatnr");
        this.origconstrnr = Misc.assignAttrValue(element, "origconstrnr");
        this.origpatternnr = Misc.assignAttrValue(element, "origpatternnr");
        this.patternnr = Misc.assignAttrValue(element, "patternnr");
        this.position = Misc.assignAttrValue(element, "position");
        this.spelling = Misc.assignAttrValue(element, "spelling");
    }

    @Override
    public String toString() {
        return subject + " is " + arguments + spelling;
    }

    @Override
    public void process() {
        ESX_Processor.actions.actionAttributePatternBeforeSubject(this);
        setSubject((Locus) EsxElementFactory.create(getElement().elements().get(0)));
        ESX_Processor.actions.actionAttributePatternAfterSubject(this);

        ESX_Processor.actions.actionAttributePatternBeforeArguments(this);
        setArguments((Loci) EsxElementFactory.create(getElement().elements().get(1)));
        ESX_Processor.actions.actionAttributePatternAfterArguments(this);
    }
}
