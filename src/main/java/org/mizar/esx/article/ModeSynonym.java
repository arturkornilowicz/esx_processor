package org.mizar.esx.article;

import java.util.*;

import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;
import org.mizar.esx.design.EsxElementFactory;

@Setter
@Getter
@NoArgsConstructor

public class ModeSynonym extends Item {

    private ModePattern synonym;
    private PatternShapedExpression original;

    public ModeSynonym(Element element) {
        super(element);
    }

    @Override
    public String toString() {
        return "synonym " + synonym + " for " + original;
    }

    @Override
    public void process() {
        ESX_Processor.actions.actionModeSynonymBeforeSynonym(this);
        setSynonym((ModePattern) EsxElementFactory.create(getElement().element("Mode-Pattern")));
        ESX_Processor.actions.actionModeSynonymAfterSynonym(this);

        ESX_Processor.actions.actionModeSynonymBeforeOriginal(this);
        setOriginal((PatternShapedExpression) EsxElementFactory.create(getElement().element("Pattern-Shaped-Expression")));
        ESX_Processor.actions.actionModeSynonymAfterOriginal(this);
    }
}
