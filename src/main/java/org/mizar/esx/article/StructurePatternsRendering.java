package org.mizar.esx.article;

import java.util.*;
import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;

@Setter
@Getter
@NoArgsConstructor

public class StructurePatternsRendering extends EsxElement {

    private AggregateFunctorPattern aggregateFunctorPattern;
    private ForgetfulFunctorPattern forgetfulFunctorPattern;
    private StrictPattern strictPattern;
    private SelectorsList selectorsList;

    public StructurePatternsRendering(Element element) {
        super(element);
    }

    @Override
    public String toString() {
        return aggregateFunctorPattern + ", " + forgetfulFunctorPattern + ", " + strictPattern + ", " + selectorsList;
    }
}
