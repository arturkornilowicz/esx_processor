package org.mizar.esx.article;

import java.util.*;

import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;

@Setter
@Getter
@NoArgsConstructor

public class DefinitionItem extends Item {

    public DefinitionItem(Element element) {
        super(element);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public void process() {
        ESX_Processor.actions.actionDefinitionItem(this);
    }
}
