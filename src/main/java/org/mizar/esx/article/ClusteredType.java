package org.mizar.esx.article;

import java.util.*;
import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;

@Setter
@Getter
@NoArgsConstructor

public class ClusteredType extends EsxElement implements TypeInterface {

    private String position;
    private String sort;

    private AdjectiveCluster adjectiveCluster;
    private TypeInterface type;

    public ClusteredType(Element element) {
        super(element);
        this.position = Misc.assignAttrValue(element,"position");
        this.sort = Misc.assignAttrValue(element,"sort");
    }

    @Override
    public String toString() {
        return adjectiveCluster + " " + type;
    }
}
