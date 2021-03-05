package org.mizar.esx.article;

import java.util.*;

import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;
import org.mizar.esx.design.EsxElementFactory;

@Setter
@Getter
@NoArgsConstructor

public class Loci extends EsxElement {

    private ArrayList<Locus> loci = new ArrayList<>();

    public Loci(Element element) {
        super(element);
    }

    @Override
    public String toString() {
        return loci.toString();
    }

    @Override
    public void process() {
        ESX_Processor.actions.actionLociBefore(this);
        for (Element element : getElement().elements()) {
            getLoci().add((Locus) EsxElementFactory.create(element));
        }
        ESX_Processor.actions.actionLociAfter(this);
    }
}

