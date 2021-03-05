package org.mizar.esx.article;

import java.util.*;

import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;
import org.mizar.esx.design.EsxElementFactory;

@Setter
@Getter
@NoArgsConstructor

public class AttrSynonym extends Item {

    private AttributePattern synonym;
    private PatternShapedExpression original;

    public AttrSynonym(Element element) {
        super(element);
    }

    @Override
    public String toString() {
        return "synonym " + synonym + " for " + original;
    }

    @Override
    public void process() {
        ESX_Processor.actions.actionAttrSynonymBeforeSynonym(this);
        setSynonym((AttributePattern) EsxElementFactory.create(getElement().element("Attribute-Pattern")));
        ESX_Processor.actions.actionAttrSynonymAfterSynonym(this);

        ESX_Processor.actions.actionAttrSynonymBeforeOriginal(this);
        setOriginal((PatternShapedExpression) EsxElementFactory.create(getElement().element("Pattern-Shaped-Expression")));
        ESX_Processor.actions.actionAttrSynonymAfterOriginal(this);
    }
}
