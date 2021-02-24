package org.mizar.esx.article;

import java.util.*;
import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;

@Setter
@Getter
@NoArgsConstructor

public class FunctorialRegistration extends EsxElement implements ClusterRegistrationInterface {

    private String position;

    private TermInterface term;
    private AdjectiveCluster adjectiveCluster;
    private TypeInterface type;

    public FunctorialRegistration(Element element) {
        super(element);
        this.position = Misc.assignAttrValue(element,"position");
    }

    @Override
    public String toString() {
        return "cluster " + term + " -> " + adjectiveCluster + (type != null ? " for " + type : "");
    }
}
