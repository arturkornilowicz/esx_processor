package org.mizar.esx.article;

import java.util.*;

import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;

@Setter
@Getter
@NoArgsConstructor

public class Reducibility extends EsxElement implements CorrectnessConditionInterface {

    public Reducibility(Element element) {
        super(element);
    }

    @Override
    public String toString() {
        return "reducibility";
    }

    @Override
    public void process() {
        ESX_Processor.actions.actionReducibility(this);
    }
}
