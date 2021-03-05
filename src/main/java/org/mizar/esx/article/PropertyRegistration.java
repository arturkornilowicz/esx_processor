package org.mizar.esx.article;

import java.util.*;

import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;
import org.mizar.esx.design.EsxElementFactory;

@Setter
@Getter
@NoArgsConstructor

public class PropertyRegistration extends Item {

    private Properties properties;
    private JustificationInterface justification;

    public PropertyRegistration(Element element) {
        super(element);
    }

    @Override
    public String toString() {
        return "sethood of " + properties + " " + justification;
    }

    @Override
    public void process() {
        ESX_Processor.actions.actionPropertyRegistrationBeforeProperties(this);
        setProperties((Properties) EsxElementFactory.create(getElement().element("Properties")));
        ESX_Processor.actions.actionPropertyRegistrationAfterProperties(this);

        ESX_Processor.actions.actionPropertyRegistrationBeforeJustification(this);
        setJustification((JustificationInterface) EsxElementFactory.create(getElement().elements().get(1)));
        ESX_Processor.actions.actionPropertyRegistrationAfterJustification(this);
    }
}
