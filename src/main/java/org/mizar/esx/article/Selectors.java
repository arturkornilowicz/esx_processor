package org.mizar.esx.article;

import java.util.*;
import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;

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
}
