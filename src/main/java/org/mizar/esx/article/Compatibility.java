package org.mizar.esx.article;

import java.util.*;

import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;

@Setter
@Getter
@NoArgsConstructor

public class Compatibility extends EsxElement implements CorrectnessConditionInterface {

    public Compatibility(Element element) {
        super(element);
    }

    @Override
    public String toString() {
        return "compatibility";
    }

    @Override
    public void process() {
        ESX_Processor.actions.actionCompatibility(this);
    }
}
