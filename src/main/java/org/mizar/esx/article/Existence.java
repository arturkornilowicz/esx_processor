package org.mizar.esx.article;

import java.util.*;

import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;

@Setter
@Getter
@NoArgsConstructor

public class Existence extends EsxElement implements CorrectnessConditionInterface {

    public Existence(Element element) {
        super(element);
    }

    @Override
    public String toString() {
        return "existence";
    }


    @Override
    public void process() {
        ESX_Processor.actions.actionExistence(this);
    }
}
