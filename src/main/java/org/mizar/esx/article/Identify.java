package org.mizar.esx.article;

import java.util.*;

import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;
import org.mizar.esx.design.EsxElementFactory;

@Setter
@Getter
@NoArgsConstructor

public class Identify extends Item {

    private PatternShapedExpression leftPatternShapedExpression;
    private PatternShapedExpression rightPatternShapedExpression;
    private LociEqualities lociEqualities;

    public Identify(Element element) {
        super(element);
    }

    @Override
    public String toString() {
        return "identify " + leftPatternShapedExpression + " with " + rightPatternShapedExpression + " " + lociEqualities;
    }

    @Override
    public void process() {
        ESX_Processor.actions.actionIdentifyBeforeLeftPatternShapedExpression(this);
        setLeftPatternShapedExpression((PatternShapedExpression) EsxElementFactory.create(getElement().elements().get(1)));
        ESX_Processor.actions.actionIdentifyAfterLeftPatternShapedExpression(this);

        ESX_Processor.actions.actionIdentifyBeforeRightPatternShapedExpression(this);
        setRightPatternShapedExpression((PatternShapedExpression) EsxElementFactory.create(getElement().elements().get(0)));
        ESX_Processor.actions.actionIdentifyAfterRightPatternShapedExpression(this);

        ESX_Processor.actions.actionIdentifyBeforeLociEqualities(this);
        setLociEqualities((LociEqualities) EsxElementFactory.create(getElement().element("Loci-Equalities")));
        ESX_Processor.actions.actionIdentifyAfterLociEqualities(this);
    }
}
