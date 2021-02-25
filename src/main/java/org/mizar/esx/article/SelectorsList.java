package org.mizar.esx.article;

import java.util.*;
import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;

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
}
