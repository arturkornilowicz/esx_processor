package org.mizar.esx.article;

import java.util.*;
import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;

@Setter
@Getter
@NoArgsConstructor

public class PartialDefiniensEquals extends PartialDefiniens {

    private TermInterface term;
    private FormulaInterface guard;

    public PartialDefiniensEquals(Element element) {
        super(element);
    }

    @Override
    public String toString() {
        return term + " if " + guard;
    }
}
