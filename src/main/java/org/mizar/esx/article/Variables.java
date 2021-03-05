package org.mizar.esx.article;

import java.util.*;

import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;
import org.mizar.esx.design.EsxElementFactory;

@Setter
@Getter
@NoArgsConstructor

public class Variables extends EsxElement {

    private ArrayList<Variable> variables = new ArrayList<>();

    public Variables(Element element) {
        super(element);
    }

    @Override
    public String toString() {
        return variables.toString();
    }

    @Override
    public void process() {
        ESX_Processor.actions.actionVariablesBefore(this);
        for (Element element : getElement().elements())
            getVariables().add((Variable) EsxElementFactory.create(element));
        ESX_Processor.actions.actionVariablesAfter(this);
    }
}
