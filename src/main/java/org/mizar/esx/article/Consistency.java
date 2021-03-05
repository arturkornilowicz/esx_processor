package org.mizar.esx.article;

import java.util.*;

import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;

@Setter
@Getter
@NoArgsConstructor

public class Consistency extends EsxElement implements CorrectnessConditionInterface {

    public Consistency(Element element) {
        super(element);
    }

    @Override
    public String toString() {
        return "consistency";
    }

    @Override
    public void process() {
        ESX_Processor.actions.actionConsistency(this);
    }
}
