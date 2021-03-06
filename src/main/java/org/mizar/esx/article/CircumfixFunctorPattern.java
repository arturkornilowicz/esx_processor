package org.mizar.esx.article;

import java.util.*;

import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;
import org.mizar.esx.design.EsxElementFactory;

@Setter
@Getter
@NoArgsConstructor

public class CircumfixFunctorPattern extends EsxElement implements PatternInterface {

    private String absoluteconstrMMLId;
    private String absoluteorigconstrMMLId;
    private String absoluteorigpatternMMLId;
    private String absolutepatternMMLId;
    private String constr;
    private String formatdes;
    private String formatnr;
    private String origconstrnr;
    private String origpatternnr;
    private String patternnr;
    private String position;
    private String spelling;

    private RightCircumflexSymbol rightCircumflexSymbol;
    private Loci loci;

    public CircumfixFunctorPattern(Element element) {
        super(element);
        this.absoluteconstrMMLId = Misc.assignAttrValue(element, "absoluteconstrMMLId");
        this.absoluteorigconstrMMLId = Misc.assignAttrValue(element, "absoluteorigconstrMMLId");
        this.absoluteorigpatternMMLId = Misc.assignAttrValue(element, "absoluteorigpatternMMLId");
        this.absolutepatternMMLId = Misc.assignAttrValue(element, "absolutepatternMMLId");
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
        return spelling + loci + rightCircumflexSymbol;
    }

    @Override
    public void process() {
        ESX_Processor.actions.actionCircumfixFunctorPatternBeforeRightCircumflexSymbol(this);
        setRightCircumflexSymbol((RightCircumflexSymbol) EsxElementFactory.create(getElement().element("Right-Circumflex-Symbol")));
        ESX_Processor.actions.actionCircumfixFunctorPatternAfterRightCircumflexSymbol(this);

        ESX_Processor.actions.actionCircumfixFunctorPatternBeforeLoci(this);
        setLoci((Loci) EsxElementFactory.create(getElement().element("Loci")));
        ESX_Processor.actions.actionCircumfixFunctorPatternAfterLoci(this);
    }
}
