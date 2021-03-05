package org.mizar.esx.article;

import java.util.*;

import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;
import org.mizar.esx.design.EsxElementFactory;

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
        this.position = Misc.assignAttrValue(element, "position");
    }

    @Override
    public String toString() {
        return "cluster " + term + " -> " + adjectiveCluster + (type != null ? " for " + type : "");
    }

    @Override
    public void process() {
        ESX_Processor.actions.actionFunctorialRegistrationBeforeTerm(this);
        setTerm((TermInterface) EsxElementFactory.create(getElement().elements().get(0)));
        ESX_Processor.actions.actionFunctorialRegistrationAfterTerm(this);

        ESX_Processor.actions.actionFunctorialRegistrationBeforeAdjectiveCluster(this);
        setAdjectiveCluster((AdjectiveCluster) EsxElementFactory.create(getElement().elements().get(1)));
        ESX_Processor.actions.actionFunctorialRegistrationAfterAdjectiveCluster(this);

        if (getElement().elements().size() > 2) {
            ESX_Processor.actions.actionFunctorialRegistrationBeforeType(this);
            setType((TypeInterface) EsxElementFactory.create(getElement().elements().get(2)));
            ESX_Processor.actions.actionFunctorialRegistrationAfterType(this);
        }
    }
}
