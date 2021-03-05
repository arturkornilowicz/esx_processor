package org.mizar.esx.article;

import java.util.*;

import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;
import org.mizar.esx.design.EsxElementFactory;

@Setter
@Getter
@NoArgsConstructor

public class StructurePattern extends EsxElement implements PatternInterface {

    private String absoluteconstrMMLId;
    private String absolutepatternMMLId;
    private String constr;
    private String formatdes;
    private String formatnr;
    private String patternnr;
    private String position;
    private String spelling;

    private Loci loci;

    public StructurePattern(Element element) {
        super(element);
        this.absoluteconstrMMLId = Misc.assignAttrValue(element, "absoluteconstrMMLId");
        this.absolutepatternMMLId = Misc.assignAttrValue(element, "absolutepatternMMLId");
        this.constr = Misc.assignAttrValue(element, "constr");
        this.formatdes = Misc.assignAttrValue(element, "formatdes");
        this.formatnr = Misc.assignAttrValue(element, "formatnr");
        this.patternnr = Misc.assignAttrValue(element, "patternnr");
        this.position = Misc.assignAttrValue(element, "position");
        this.spelling = Misc.assignAttrValue(element, "spelling");
    }

    @Override
    public String toString() {
        return loci != null ? loci.toString() : "";
    }

    @Override
    public void process() {
        ESX_Processor.actions.actionStructurePatternBeforeLoci(this);
        setLoci((Loci) EsxElementFactory.create(getElement().element("Loci")));
        ESX_Processor.actions.actionStructurePatternAfterLoci(this);
    }
}
