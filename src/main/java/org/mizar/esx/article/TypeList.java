package org.mizar.esx.article;

import java.util.*;

import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;
import org.mizar.esx.design.EsxElementFactory;

@Setter
@Getter
@NoArgsConstructor

public class TypeList extends EsxElement {

    private ArrayList<TypeInterface> types = new ArrayList<>();

    public TypeList(Element element) {
        super(element);
    }

    @Override
    public String toString() {
        return types.toString();
    }

    @Override
    public void process() {
        ESX_Processor.actions.actionTypeListBefore(this);
        for (Element element : getElement().elements())
            getTypes().add((TypeInterface) EsxElementFactory.create(element));
        ESX_Processor.actions.actionTypeListAfter(this);
    }
}
