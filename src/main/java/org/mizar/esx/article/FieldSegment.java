package org.mizar.esx.article;

import java.util.*;

import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;
import org.mizar.esx.design.EsxElementFactory;

@Setter
@Getter
@NoArgsConstructor

public class FieldSegment extends EsxElement {

    private String position;

    private Selectors selectors;
    private TypeInterface type;

    public FieldSegment(Element element) {
        super(element);
        this.position = Misc.assignAttrValue(element, "position");
    }

    @Override
    public String toString() {
        return selectors + " -> " + type;
    }

    @Override
    public void process() {
        ESX_Processor.actions.actionFieldSegmentBeforeSelectors(this);
        setSelectors((Selectors) EsxElementFactory.create(getElement().element("Selectors")));
        ESX_Processor.actions.actionFieldSegmentAfterSelectors(this);

        ESX_Processor.actions.actionFieldSegmentBeforeType(this);
        setType((TypeInterface) EsxElementFactory.create(getElement().elements().get(1)));
        ESX_Processor.actions.actionFieldSegmentAfterType(this);
    }
}
