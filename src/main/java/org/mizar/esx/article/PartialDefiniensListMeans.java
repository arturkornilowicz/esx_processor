package org.mizar.esx.article;

import java.util.*;

import lombok.*;
import org.dom4j.*;
import org.mizar.esx.ESX_Processor;
import org.mizar.esx.design.EsxElementFactory;

@Setter
@Getter
@NoArgsConstructor

public class PartialDefiniensListMeans extends EsxElement implements PartialDefiniensListInterface {

    private ArrayList<PartialDefiniensMeans> partialDefiniens = new ArrayList<>();

    public PartialDefiniensListMeans(Element element) {
        super(element);
    }

    @Override
    public String toString() {
        return partialDefiniens.toString();
    }

    @Override
    public void process() {
        ESX_Processor.actions.actionPartialDefiniensListBeforeDefiniensMeans(this);
        for (Element element : getElement().elements())
            getPartialDefiniens().add((PartialDefiniensMeans) EsxElementFactory.create(element, "shape"));
        ESX_Processor.actions.actionPartialDefiniensListAfterDefiniensMeans(this);
    }
}
