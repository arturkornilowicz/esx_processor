package org.mizar.esx.article;

import java.util.*;

import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;
import org.mizar.esx.design.EsxElementFactory;

@Setter
@Getter
@NoArgsConstructor

public class StructurePatternsRendering extends EsxElement {

    private AggregateFunctorPattern aggregateFunctorPattern;
    private ForgetfulFunctorPattern forgetfulFunctorPattern;
    private StrictPattern strictPattern;
    private SelectorsList selectorsList;

    public StructurePatternsRendering(Element element) {
        super(element);
    }

    @Override
    public String toString() {
        return aggregateFunctorPattern + ", " + forgetfulFunctorPattern + ", " + strictPattern + ", " + selectorsList;
    }

    @Override
    public void process() {
        ESX_Processor.actions.actionStructurePatternsRenderingBeforeAggregateFunctorPattern(this);
        setAggregateFunctorPattern((AggregateFunctorPattern) EsxElementFactory.create(getElement().element("AggregateFunctor-Pattern")));
        ESX_Processor.actions.actionStructurePatternsRenderingAfterAggregateFunctorPattern(this);

        ESX_Processor.actions.actionStructurePatternsRenderingBeforeForgetfulFunctorPattern(this);
        setForgetfulFunctorPattern((ForgetfulFunctorPattern) EsxElementFactory.create(getElement().element("ForgetfulFunctor-Pattern")));
        ESX_Processor.actions.actionStructurePatternsRenderingAfterForgetfulFunctorPattern(this);

        ESX_Processor.actions.actionStructurePatternsRenderingBeforeStrictPattern(this);
        setStrictPattern((StrictPattern) EsxElementFactory.create(getElement().element("Strict-Pattern")));
        ESX_Processor.actions.actionStructurePatternsRenderingAfterStrictPattern(this);

        ESX_Processor.actions.actionStructurePatternsRenderingBeforeSelectorsList(this);
        setSelectorsList((SelectorsList) EsxElementFactory.create(getElement().element("Selectors-List")));
        ESX_Processor.actions.actionStructurePatternsRenderingAfterSelectorsList(this);
    }
}
