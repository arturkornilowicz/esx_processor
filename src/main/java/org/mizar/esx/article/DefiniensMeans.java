package org.mizar.esx.article;

import java.util.*;
import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;

@Setter
@Getter
@NoArgsConstructor

public class DefiniensMeans extends Definiens {

    private FormulaInterface formula;

    public DefiniensMeans(Element element) {
        super(element);
    }

    @Override
    public String toString() { return formula.toString(); }
}
