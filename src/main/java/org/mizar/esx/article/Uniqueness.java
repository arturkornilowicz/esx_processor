package org.mizar.esx.article;

import java.util.*;

import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;

@Setter
@Getter
@NoArgsConstructor

public class Uniqueness extends EsxElement implements CorrectnessConditionInterface {

    public Uniqueness(Element element) {
        super(element);
    }

    @Override
    public String toString() {
        return "uniqueness";
    }

    @Override
    public void process() {
        ESX_Processor.actions.actionUniqueness(this);
    }
}
