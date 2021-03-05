package org.mizar.esx.article;

import java.util.*;

import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;
import org.mizar.esx.design.EsxElementFactory;

@Setter
@Getter
@NoArgsConstructor

public class FuncSynonym extends Item {

    private PatternInterface synonym;
    private PatternShapedExpression original;

    public FuncSynonym(Element element) {
        super(element);
    }

    @Override
    public String toString() {
        return "synonym " + synonym + " for " + original;
    }

    @Override
    public void process() {
        ESX_Processor.actions.actionFuncSynonymBeforeSynonym(this);
        setSynonym((PatternInterface) EsxElementFactory.create(getElement().elements().get(0)));
        ESX_Processor.actions.actionFuncSynonymAfterSynonym(this);

        ESX_Processor.actions.actionFuncSynonymBeforeOriginal(this);
        setOriginal((PatternShapedExpression) EsxElementFactory.create(getElement().element("Pattern-Shaped-Expression")));
        ESX_Processor.actions.actionFuncSynonymAfterOriginal(this);
    }
}
