package org.mizar.esx.article;

import java.util.*;

import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;
import org.mizar.esx.design.EsxElementFactory;

@Setter
@Getter
@NoArgsConstructor

public class Conditions extends EsxElement {

    private ArrayList<Proposition> propositions = new ArrayList<>();

    public Conditions(Element element) {
        super(element);
    }

    @Override
    public String toString() {
        return "that " + propositions.toString();
    }

    @Override
    public void process() {
        ESX_Processor.actions.actionConditionsBeforePropositions(this);
        for (Element element : getElement().elements())
            getPropositions().add((Proposition) EsxElementFactory.create(element));
        ESX_Processor.actions.actionConditionsAfterPropositions(this);
    }
}
