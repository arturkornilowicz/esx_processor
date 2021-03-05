package org.mizar.esx.article;

import java.util.*;

import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;
import org.mizar.esx.design.EsxElementFactory;
import org.mizar.esx.errors.Errors;

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

    @Override
    public void process() {
        ESX_Processor.actions.actionClusterBeforeCluster(this);
        setCluster((ClusterRegistrationInterface) EsxElementFactory.create(getElement().elements().get(0)));
        ESX_Processor.actions.actionClusterAfterCluster(this);
    }
}
