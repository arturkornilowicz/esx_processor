package org.mizar.esx.article;

import java.util.*;
import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;

@Setter
@Getter
@NoArgsConstructor

public class CorrectnessConditions extends EsxElement {

    private ArrayList<CorrectnessConditionInterface> correctnessConditions = new ArrayList<>();

    public CorrectnessConditions(Element element) {
        super(element);
    }

    @Override
    public String toString() {
        return "correctness";
    }
}
