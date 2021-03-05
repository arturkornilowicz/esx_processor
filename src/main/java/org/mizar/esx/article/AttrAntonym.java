package org.mizar.esx.article;

import java.util.*;

import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;
import org.mizar.esx.design.EsxElementFactory;

@Setter
@Getter
@NoArgsConstructor

public class AttrAntonym extends Item {

    private AttributePattern antonym;
    private PatternShapedExpression original;

    public AttrAntonym(Element element) {
        super(element);
    }

    @Override
    public String toString() {
        return "antonym " + antonym + " for " + original;
    }

    @Override
    public void process() {
        ESX_Processor.actions.actionAttrAntonymBeforePattern(this);
        setAntonym((AttributePattern) EsxElementFactory.create(getElement().element("Attribute-Pattern")));
        ESX_Processor.actions.actionAttrAntonymAfterPattern(this);

        ESX_Processor.actions.actionAttrAntonymBeforeOriginal(this);
        setOriginal((PatternShapedExpression) EsxElementFactory.create(getElement().element("Pattern-Shaped-Expression")));
        ESX_Processor.actions.actionAttrAntonymAfterOriginal(this);
    }
}
