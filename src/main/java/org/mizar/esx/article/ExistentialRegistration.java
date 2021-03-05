package org.mizar.esx.article;

import java.util.*;

import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;
import org.mizar.esx.design.EsxElementFactory;

@Setter
@Getter
@NoArgsConstructor

public class ExistentialRegistration extends EsxElement implements ClusterRegistrationInterface {

    private String position;

    private AdjectiveCluster adjectiveCluster;
    private TypeInterface type;

    public ExistentialRegistration(Element element) {
        super(element);
        this.position = Misc.assignAttrValue(element, "position");
    }

    @Override
    public String toString() {
        return "cluster " + adjectiveCluster + " for " + type;
    }

    @Override
    public void process() {
        ESX_Processor.actions.actionExistentialRegistrationBeforeAdjectiveCluster(this);
        setAdjectiveCluster((AdjectiveCluster) EsxElementFactory.create(getElement().elements().get(0)));
        ESX_Processor.actions.actionExistentialRegistrationAfterAdjectiveCluster(this);

        ESX_Processor.actions.actionExistentialRegistrationBeforeType(this);
        setType((TypeInterface) EsxElementFactory.create(getElement().elements().get(1)));
        ESX_Processor.actions.actionExistentialRegistrationAfterType(this);
    }
}
