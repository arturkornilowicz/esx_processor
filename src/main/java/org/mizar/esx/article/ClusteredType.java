package org.mizar.esx.article;

import java.util.*;

import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;
import org.mizar.esx.design.EsxElementFactory;

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
        this.position = Misc.assignAttrValue(element, "position");
        this.sort = Misc.assignAttrValue(element, "sort");
    }

    @Override
    public String toString() {
        return adjectiveCluster + " " + type;
    }

    @Override
    public void process() {
        ESX_Processor.actions.actionClusteredTypeBeforeAdjectiveCluster(this);
        setAdjectiveCluster((AdjectiveCluster) EsxElementFactory.create(getElement().element("Adjective-Cluster")));
        ESX_Processor.actions.actionClusteredTypeAfterAdjectiveCluster(this);

        ESX_Processor.actions.actionClusteredTypeBeforeType(this);
        setType((TypeInterface) EsxElementFactory.create(getElement().elements().get(1)));
        ESX_Processor.actions.actionClusteredTypeAfterType(this);
    }
}
