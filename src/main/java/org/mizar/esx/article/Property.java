package org.mizar.esx.article;

import java.util.*;

import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;
import org.mizar.esx.design.EsxElementFactory;

@Setter
@Getter
@NoArgsConstructor

public class Property extends Item {

    private Properties properties;
    private JustificationInterface justification;

    public Property(Element element) {
        super(element);
    }

    @Override
    public String toString() {
        return properties + " " + justification;
    }

    @Override
    public void process() {
        ESX_Processor.actions.actionPropertyBeforeProperties(this);
        setProperties((Properties) EsxElementFactory.create(getElement().element("Properties")));
        ESX_Processor.actions.actionPropertyAfterProperties(this);

        ESX_Processor.actions.actionPropertyBeforeJustification(this);
        setJustification((JustificationInterface) EsxElementFactory.create(getElement().elements().get(1)));
        ESX_Processor.actions.actionPropertyAfterJustification(this);
    }
}
