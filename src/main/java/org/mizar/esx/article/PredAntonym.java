package org.mizar.esx.article;

import java.util.*;

import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;
import org.mizar.esx.design.EsxElementFactory;

@Setter
@Getter
@NoArgsConstructor

public class PredAntonym extends Item {

    private PredicatePattern antonym;
    private PatternShapedExpression original;

    public PredAntonym(Element element) {
        super(element);
    }

    @Override
    public String toString() {
        return "antonym " + antonym + " for " + original;
    }

    @Override
    public void process() {
        ESX_Processor.actions.actionPredAntonymBeforeAntonym(this);
        setAntonym((PredicatePattern) EsxElementFactory.create(getElement().element("Predicate-Pattern")));
        ESX_Processor.actions.actionPredAntonymAfterAntonym(this);

        ESX_Processor.actions.actionPredAntonymBeforeOrginal(this);
        setOriginal((PatternShapedExpression) EsxElementFactory.create(getElement().element("Pattern-Shaped-Expression")));
        ESX_Processor.actions.actionPredAntonymAfterOrginal(this);
    }
}
