package org.mizar.esx.article;

import java.util.*;

import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;
import org.mizar.esx.design.EsxElementFactory;

@Setter
@Getter
@NoArgsConstructor

public class GlobalChoiceTerm extends EsxElement implements TermInterface {

    private String position;
    private String sort;

    private TypeInterface type;

    public GlobalChoiceTerm(Element element) {
        super(element);
        this.position = Misc.assignAttrValue(element, "position");
        this.sort = Misc.assignAttrValue(element, "sort");
    }

    @Override
    public String toString() {
        return "the " + type;
    }

    @Override
    public void process() {
        ESX_Processor.actions.actionGlobalChoiceTermBeforeType(this);
        setType((TypeInterface) EsxElementFactory.create(getElement().elements().get(0)));
        ESX_Processor.actions.actionGlobalChoiceTermAfterType(this);
    }
}
