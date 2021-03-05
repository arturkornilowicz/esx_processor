package org.mizar.esx.article;

import java.util.*;

import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;
import org.mizar.esx.design.EsxElementFactory;

@Setter
@Getter
@NoArgsConstructor

public class Selectors extends EsxElement {

    private ArrayList<Selector> selectors = new ArrayList<>();

    public Selectors(Element element) {
        super(element);
    }

    @Override
    public String toString() {
        return selectors.toString();
    }

    @Override
    public void process() {
        ESX_Processor.actions.actionSelectorsBefore(this);
        for (Element element : getElement().elements())
            getSelectors().add((Selector) EsxElementFactory.create(element));
        ESX_Processor.actions.actionSelectorsAfter(this);
    }
}
