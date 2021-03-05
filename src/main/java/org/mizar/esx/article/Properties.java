package org.mizar.esx.article;

import java.util.*;

import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;
import org.mizar.esx.design.EsxElementFactory;

@Setter
@Getter
@NoArgsConstructor

public class Properties extends EsxElement {

    private String property;
    private String sort;

    private TypeInterface type;

    public Properties(Element element) {
        super(element);
        this.property = Misc.assignAttrValue(element, "property");
        this.sort = Misc.assignAttrValue(element, "sort");
    }

    @Override
    public String toString() {
        return property + " " + type;
    }

    @Override
    public void process() {
        if (getElement().elements().size() > 0) {
            ESX_Processor.actions.actionPropertiesBeforeType(this);
            setType((TypeInterface) EsxElementFactory.create(getElement().elements().get(0)));
            ESX_Processor.actions.actionPropertiesAfterType(this);
        }
    }
}
