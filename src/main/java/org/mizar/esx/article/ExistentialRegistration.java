package org.mizar.esx.article;

import java.util.*;
import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;

@Setter
@Getter
@NoArgsConstructor

public class ExistentialRegistration extends EsxElement implements ClusterRegistrationInterface {

    private String position;

    private AdjectiveCluster adjectiveCluster;
    private TypeInterface type;

    public ExistentialRegistration(Element element) {
        super(element);
        this.position = Misc.assignAttrValue(element,"position");
    }

    @Override
    public String toString() {
        return "cluster " + adjectiveCluster + " for " + type;
    }
}
