package org.mizar.esx.article;

import java.util.*;
import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;

@Setter
@Getter
@NoArgsConstructor

public class SchemeHead extends Item {

    private Scheme scheme;
    private SchematicVariables schematicVariables;
    private FormulaInterface formula;
    private ProvisionalFormulas provisionalFormulas;

    public SchemeHead(Element element) {
        super(element);
    }

    @Override
    public String toString() {
        return scheme + " " + schematicVariables + ":\n" + formula + " " + provisionalFormulas;
    }
}
