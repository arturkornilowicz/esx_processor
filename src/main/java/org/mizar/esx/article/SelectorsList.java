package org.mizar.esx.article;

import java.util.*;

import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;
import org.mizar.esx.design.EsxElementFactory;

@Setter
@Getter
@NoArgsConstructor

public class SelectorsList extends EsxElement {

    private ArrayList<SelectorFunctorPattern> selectorFunctorPatterns = new ArrayList<>();

    public SelectorsList(Element element) {
        super(element);
    }

    @Override
    public String toString() {
        return selectorFunctorPatterns.toString();
    }

    @Override
    public void process() {
        ESX_Processor.actions.actionSelectorsListBefore(this);
        for (Element element : getElement().elements())
            getSelectorFunctorPatterns().add((SelectorFunctorPattern) EsxElementFactory.create(element));
        ESX_Processor.actions.actionSelectorsListAfter(this);
    }
}
