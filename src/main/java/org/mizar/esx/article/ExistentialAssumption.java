package org.mizar.esx.article;

import java.util.*;
import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;

@Setter
@Getter
@NoArgsConstructor

public class ExistentialAssumption extends Item {

    private QualifiedSegments qualifiedSegments;
    private Conditions conditions;

    public ExistentialAssumption(Element element) {
        super(element);
    }

    @Override
    public String toString() {
        return "given " + qualifiedSegments + " such " + conditions;
    }
}
