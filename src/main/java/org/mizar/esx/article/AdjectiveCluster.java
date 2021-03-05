package org.mizar.esx.article;

import java.util.*;

import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;
import org.mizar.esx.design.EsxElementFactory;

@Setter
@Getter
@NoArgsConstructor

public class AdjectiveCluster extends EsxElement {

    private ArrayList<Attribute> attributes = new ArrayList<>();

    public AdjectiveCluster(Element element) {
        super(element);
    }

    @Override
    public String toString() {
        return attributes.toString();
    }

    @Override
    public void process() {
        ESX_Processor.actions.actionAdjectiveClusterBeforeAttributes(this);
        for (Element element : getElement().elements())
            getAttributes().add((Attribute) EsxElementFactory.create(element));
        ESX_Processor.actions.actionAdjectiveClusterAfterAttributes(this);
    }
}
