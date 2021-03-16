package org.mizar.esx.article;

import java.util.*;

import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;
import org.mizar.esx.design.EsxElementFactory;

@Setter
@Getter
@NoArgsConstructor

public class ConstantDefinition extends Item {

    private ArrayList<Equating> equatings = new ArrayList<>();

    public ConstantDefinition(Element element) {
        super(element);
    }

    @Override
    public String toString() {
        return "set " + equatings;
    }

    @Override
    public void process() {
        for (Element element: getElement().elements())
            getEquatings().add((Equating) EsxElementFactory.create(element));
    }
}
