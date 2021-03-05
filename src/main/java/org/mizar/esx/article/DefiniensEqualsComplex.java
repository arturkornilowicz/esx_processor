package org.mizar.esx.article;

import java.util.*;

import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;
import org.mizar.esx.design.EsxElementFactory;

@Setter
@Getter
@NoArgsConstructor

public class DefiniensEqualsComplex extends DefiniensComplex {

    public DefiniensEqualsComplex(Element element) {
        super(element);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public void process() {
        ESX_Processor.actions.actionDefiniensEqualsBeforePartialDefiniensList(this);
//        TODO
//        setPartialDefiniensList((PartialDefiniensListEquals)(getElement().element("Partial-Definiens-List")));
        setPartialDefiniensList(ESX_Processor.processPartialDefiniensList(getElement().element("Partial-Definiens-List"), "term"));
        ESX_Processor.actions.actionDefiniensEqualsAfterPartialDefiniensList(this);

        ESX_Processor.actions.actionDefiniensEqualsBeforeOtherwise(this);
        setOtherwise((OtherwiseEquals) EsxElementFactory.create(getElement().element("Otherwise"), "shape"));
        ESX_Processor.actions.actionDefiniensEqualsAfterOtherwise(this);
    }
}
