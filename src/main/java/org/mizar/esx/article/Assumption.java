package org.mizar.esx.article;

import java.util.*;
import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;

@Setter
@Getter
@NoArgsConstructor

public class Assumption extends Item {

    private AssumptionInterface assumption;

    public Assumption(Element element) {
        super(element);
    }

    @Override
    public String toString() {
        return "assume " + assumption.toString();
    }
}
