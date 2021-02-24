package org.mizar.esx.article;

import java.util.*;
import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;

@Setter
@Getter
@NoArgsConstructor

public class Reduction extends Item {

    private TermInterface leftTerm;
    private TermInterface rightTerm;

    public Reduction(Element element) {
        super(element);
    }

    @Override
    public String toString() {
        return "reduce " + leftTerm + " to " + rightTerm;
    }
}
