package org.mizar.esx.article;

import java.util.*;

import lombok.*;
import org.dom4j.*;
import org.mizar.esx.ESX_Processor;
import org.mizar.esx.design.EsxElementFactory;

@Setter
@Getter
@NoArgsConstructor

public class PartialDefiniensListEquals extends EsxElement implements PartialDefiniensListInterface {

    private ArrayList<PartialDefiniensEquals> partialDefiniens = new ArrayList<>();

    public PartialDefiniensListEquals(Element element) {
        super(element);
    }

    @Override
    public String toString() {
        return partialDefiniens.toString();
    }

    @Override
    public void process() {
        ESX_Processor.actions.actionPartialDefiniensListBeforeDefiniensEquals(this);
        for (Element element : getElement().elements())
            getPartialDefiniens().add((PartialDefiniensEquals) EsxElementFactory.create(element, "shape"));
        ESX_Processor.actions.actionPartialDefiniensListAfterDefiniensEquals(this);

    }
}
