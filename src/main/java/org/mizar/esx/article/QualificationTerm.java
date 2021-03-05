package org.mizar.esx.article;

import java.util.*;

import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;
import org.mizar.esx.design.EsxElementFactory;

@Setter
@Getter
@NoArgsConstructor

public class QualificationTerm extends EsxElement implements TermInterface {

    private String position;
    private String sort;

    private TermInterface term;
    private TypeInterface type;

    public QualificationTerm(Element element) {
        super(element);
        this.position = Misc.assignAttrValue(element, "position");
        this.sort = Misc.assignAttrValue(element, "sort");
    }

    @Override
    public String toString() {
        return term + " is " + type;
    }

    @Override
    public void process() {
        ESX_Processor.actions.actionQualificationTermBeforeTerm(this);
        setTerm((TermInterface) EsxElementFactory.create(getElement().elements().get(0)));
        ESX_Processor.actions.actionQualificationTermAfterTerm(this);

        ESX_Processor.actions.actionQualificationTermBeforeType(this);
        setType((TypeInterface) EsxElementFactory.create(getElement().elements().get(1)));
        ESX_Processor.actions.actionQualificationTermAfterType(this);
    }
}
