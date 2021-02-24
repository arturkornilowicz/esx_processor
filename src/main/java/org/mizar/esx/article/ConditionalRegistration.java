package org.mizar.esx.article;

import java.util.*;
import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;

@Setter
@Getter
@NoArgsConstructor

public class ConditionalRegistration extends EsxElement implements ClusterRegistrationInterface {

    private String position;

    private AdjectiveCluster predecessor;
    private AdjectiveCluster successor;
    private TypeInterface type;

    public ConditionalRegistration(Element element) {
        super(element);
        this.position = Misc.assignAttrValue(element,"position");
    }

    @Override
    public String toString() {
        return "cluster " + predecessor + " -> " + successor + " for " + type;
    }
}
