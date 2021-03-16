package org.mizar.esx.article;

import java.util.*;

import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;
import org.mizar.esx.design.EsxElementFactory;

@Setter
@Getter
@NoArgsConstructor

public class StraightforwardJustification extends EsxElement implements JustificationInterface {

    private String position;

    private ArrayList<ReferenceInterface> references = new ArrayList<>();

    public StraightforwardJustification(Element element) {
        super(element);
        this.position = Misc.assignAttrValue(element, "position");
    }

    @Override
    public String toString() { return references.size() > 0 ? "by " + references : ""; }


    @Override
    public void process() {
        ESX_Processor.actions.actionStraightforwardJustificationBefore(this);
        for (Element element : getElement().elements())
            getReferences().add((ReferenceInterface) EsxElementFactory.create(element));
        ESX_Processor.actions.actionStraightforwardJustificationAfter(this);
    }
}
