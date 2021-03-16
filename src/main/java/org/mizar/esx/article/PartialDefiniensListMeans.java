package org.mizar.esx.article;

import java.util.*;

import lombok.*;
import org.dom4j.*;
import org.mizar.esx.ESX_Processor;
import org.mizar.esx.design.EsxElementFactory;

@Setter
@Getter
@NoArgsConstructor

public class PartialDefiniensListMeans extends PartialDefiniensList<PartialDefiniensMeans> {

    public PartialDefiniensListMeans(Element element) {
        super(element);
    }

    @Override
    public String toString() {
        return getPartialDefiniens().toString();
    }

    @Override
    public void process() {
        ESX_Processor.actions.actionPartialDefiniensListBeforeDefiniensMeans(this);
        for (Element element : getElement().elements())
            getPartialDefiniens().add((PartialDefiniensMeans) EsxElementFactory.create(element, "shape"));
        ESX_Processor.actions.actionPartialDefiniensListAfterDefiniensMeans(this);
    }
}
