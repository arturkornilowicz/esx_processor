package org.mizar.esx.article;

import java.util.*;

import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;
import org.mizar.esx.design.EsxElementFactory;

@Setter
@Getter
@NoArgsConstructor

public class DefiniensMeansComplex extends DefiniensComplex {

    public DefiniensMeansComplex(Element element) {
        super(element);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public void process() {
        ESX_Processor.actions.actionDefiniensMeansBeforePartialDefiniensList(this);
        // TODO
//        setPartialDefiniensList((PartialDefiniensListMeans)EsxElementFactory.create(getElement().element("Partial-Definiens-List")));
        setPartialDefiniensList(ESX_Processor.processPartialDefiniensList(getElement().element("Partial-Definiens-List"), "formula"));
        ESX_Processor.actions.actionDefiniensMeansAfterPartialDefiniensList(this);

        ESX_Processor.actions.actionDefiniensMeansBeforeOtherwise(this);
        setOtherwise((OtherwiseMeans) EsxElementFactory.create(getElement().element("Otherwise"), "shape"));
        ESX_Processor.actions.actionDefiniensMeansAfterOtherwise(this);
    }
}
