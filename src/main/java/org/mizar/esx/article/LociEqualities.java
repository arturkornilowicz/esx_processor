package org.mizar.esx.article;

import java.util.*;

import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;
import org.mizar.esx.design.EsxElementFactory;

@Setter
@Getter
@NoArgsConstructor

public class LociEqualities extends EsxElement {

    ArrayList<LociEquality> lociEqualities = new ArrayList<>();

    public LociEqualities(Element element) {
        super(element);
    }

    @Override
    public String toString() {
        return lociEqualities.size() > 0 ? "when " + lociEqualities : "";
    }

    @Override
    public void process() {
        ESX_Processor.actions.actionLociEqualitiesBefore(this);
        for (Element element : getElement().elements())
            getLociEqualities().add((LociEquality) EsxElementFactory.create(element));
        ESX_Processor.actions.actionLociEqualitiesAfter(this);
    }
}
