package org.mizar.esx.article;

import java.util.*;
import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;
import org.w3c.dom.Attr;

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
}
