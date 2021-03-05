package org.mizar.esx.article;

import java.util.*;

import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;
import org.mizar.esx.design.EsxElementFactory;

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
        this.position = Misc.assignAttrValue(element, "position");
    }

    @Override
    public String toString() {
        return "cluster " + predecessor + " -> " + successor + " for " + type;
    }

    @Override
    public void process() {
        ESX_Processor.actions.actionConditionalRegistrationBeforePredecessor(this);
        setPredecessor((AdjectiveCluster) EsxElementFactory.create(getElement().elements().get(0)));
        ESX_Processor.actions.actionConditionalRegistrationAfterPredecessor(this);

        ESX_Processor.actions.actionConditionalRegistrationBeforeSuccessor(this);
        setSuccessor((AdjectiveCluster) EsxElementFactory.create(getElement().elements().get(1)));
        ESX_Processor.actions.actionConditionalRegistrationAfterSuccessor(this);

        ESX_Processor.actions.actionConditionalRegistrationBeforeType(this);
        setType((TypeInterface) EsxElementFactory.create(getElement().elements().get(2)));
        ESX_Processor.actions.actionConditionalRegistrationAfterType(this);
    }
}
