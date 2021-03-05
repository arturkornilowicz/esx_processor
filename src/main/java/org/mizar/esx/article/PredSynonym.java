package org.mizar.esx.article;

import java.util.*;

import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;
import org.mizar.esx.design.EsxElementFactory;

@Setter
@Getter
@NoArgsConstructor

public class PredSynonym extends Item {

    private PredicatePattern synonym;
    private PatternShapedExpression original;

    public PredSynonym(Element element) {
        super(element);
    }

    @Override
    public String toString() {
        return "synonym " + synonym + " for " + original;
    }

    @Override
    public void process() {
        ESX_Processor.actions.actionPredSynonymBeforePattern(this);
        setSynonym((PredicatePattern) EsxElementFactory.create(getElement().element("Predicate-Pattern")));
        ESX_Processor.actions.actionPredSynonymAfterPattern(this);

        ESX_Processor.actions.actionPredSynonymBeforeOriginal(this);
        setOriginal((PatternShapedExpression) EsxElementFactory.create(getElement().element("Pattern-Shaped-Expression")));
        ESX_Processor.actions.actionPredSynonymAfterOriginal(this);
    }
}
