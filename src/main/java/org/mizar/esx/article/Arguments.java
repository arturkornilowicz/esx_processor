package org.mizar.esx.article;

import java.util.*;

import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;
import org.mizar.esx.design.EsxElementFactory;

@Setter
@Getter
@NoArgsConstructor

public class Arguments extends EsxElement {

    private ArrayList<TermInterface> arguments = new ArrayList<>();

    public Arguments(Element element) {
        super(element);
    }

    @Override
    public String toString() {
        return arguments.toString();
    }

    @Override
    public void process() {
        ESX_Processor.actions.actionArgumentsBeforeArguments(this);
        for (Element element : getElement().elements())
            getArguments().add((TermInterface) EsxElementFactory.create(element));
        ESX_Processor.actions.actionArgumentsAfterArguments(this);
    }
}
