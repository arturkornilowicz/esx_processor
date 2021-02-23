package org.mizar.esx.article;

import java.util.*;
import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;

@Setter
@Getter
@NoArgsConstructor

public class CorrectnessCondition extends Item {

    private CorrectnessConditionInterface correctnessCondition;
    private JustificationInterface justification;

    public CorrectnessCondition(Element element) {
        super(element);
    }

    @Override
    public String toString() {
        return correctnessCondition + " " + justification;
    }
}
