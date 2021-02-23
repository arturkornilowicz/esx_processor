package org.mizar.esx.article;

import java.util.*;
import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;

@Setter
@Getter
@NoArgsConstructor

public class Correctness extends Item {

    private CorrectnessConditions correctnessConditions;
    private JustificationInterface justification;

    public Correctness(Element element) {
        super(element);
    }

    @Override
    public String toString() {
        return correctnessConditions + " " + justification;
    }
}
