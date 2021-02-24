package org.mizar.esx.article;

import java.util.*;
import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;

@Setter
@Getter
@NoArgsConstructor

public class Cluster extends Item {

    private ClusterRegistrationInterface cluster;

    public Cluster(Element element) {
        super(element);
    }

    @Override
    public String toString() {
        return cluster.toString();
    }
}
