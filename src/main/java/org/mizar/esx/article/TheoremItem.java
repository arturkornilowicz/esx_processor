package org.mizar.esx.article;

import java.util.*;

import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;
import org.mizar.esx.design.EsxElementFactory;

@Setter
@Getter
@NoArgsConstructor

public class TheoremItem extends Item {

    private String MMLId;

    private Proposition proposition;
    private JustificationInterface justification;

    public TheoremItem(Element element) {
        super(element);
        this.MMLId = Misc.assignAttrValue(element, "MMLId");
    }

    @Override
    public String toString() {
        return "theorem ::" + getMMLId() + "\n" + proposition + "\n" + justification + ";";
    }

    @Override
    public void process() {
        ESX_Processor.actions.actionTheoremItemBeforeProposition(this);
        setProposition((Proposition) EsxElementFactory.create(getElement().element("Proposition")));
        ESX_Processor.actions.actionTheoremItemAfterProposition(this);

        ESX_Processor.actions.actionTheoremItemBeforeJustification(this);
        setJustification((JustificationInterface) EsxElementFactory.create(getElement().elements().get(1)));
        ESX_Processor.actions.actionTheoremItemAfterJustification(this);
    }
}
