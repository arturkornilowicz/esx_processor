package org.mizar.esx.article;

import java.util.*;

import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;
import org.mizar.esx.design.EsxElementFactory;

@Setter
@Getter
@NoArgsConstructor

public class Ancestors extends EsxElement {

    private ArrayList<TypeInterface> ancestors = new ArrayList<>();

    public Ancestors(Element element) {
        super(element);
    }

    @Override
    public String toString() {
        return "(" + ancestors + ")";
    }

    @Override
    public void process() {
        ESX_Processor.actions.actionAncestorsBefore(this);
        for (Element element : getElement().elements())
            getAncestors().add((TypeInterface) EsxElementFactory.create(element));
        ESX_Processor.actions.actionAncestorsAfter(this);
    }
}
