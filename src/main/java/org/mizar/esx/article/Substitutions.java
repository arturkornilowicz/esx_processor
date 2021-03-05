package org.mizar.esx.article;

import java.util.*;

import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;
import org.mizar.esx.design.EsxElementFactory;

@Setter
@Getter
@NoArgsConstructor

public class Substitutions extends EsxElement {

    private ArrayList<Substitution> substitutions = new ArrayList<>();

    public Substitutions(Element element) {
        super(element);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public void process() {
        ESX_Processor.actions.actionSubstitutionsBefore(this);
        for (Element element : getElement().elements())
            getSubstitutions().add((Substitution) EsxElementFactory.create(element));
        ESX_Processor.actions.actionSubstitutionsAfter(this);
    }
}
