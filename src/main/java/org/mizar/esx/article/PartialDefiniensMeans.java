package org.mizar.esx.article;

import java.util.*;
import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;

@Setter
@Getter
@NoArgsConstructor

public class PartialDefiniensMeans extends PartialDefiniens {

    private FormulaInterface formula;
    private FormulaInterface guard;

    public PartialDefiniensMeans(Element element) {
        super(element);
    }

    @Override
    public String toString() {
        return formula + " if " + guard;
    }
}
