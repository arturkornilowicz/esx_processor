package org.mizar.esx.article;

import java.util.*;

import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;
import org.mizar.esx.design.EsxElementFactory;

@Setter
@Getter
@NoArgsConstructor

public class PatternShapedExpression extends EsxElement {

    private PatternInterface pattern;

    public PatternShapedExpression(Element element) {
        super(element);
    }

    @Override
    public String toString() {
        return pattern.toString();
    }

    @Override
    public void process() {
        ESX_Processor.actions.actionPatternShapedExpressionBeforePatter(this);
        setPattern((PatternInterface) EsxElementFactory.create(getElement().elements().get(0)));
        ESX_Processor.actions.actionPatternShapedExpressionAfterPatter(this);
    }
}
