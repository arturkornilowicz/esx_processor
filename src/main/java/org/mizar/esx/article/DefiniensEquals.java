package org.mizar.esx.article;

import java.util.*;

import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;
import org.mizar.esx.design.EsxElementFactory;

@Setter
@Getter
@NoArgsConstructor

public class DefiniensEquals extends Definiens {

    private TermInterface term;

    public DefiniensEquals(Element element) {
        super(element);
    }

    @Override
    public String toString() {
        return term.toString();
    }

    @Override
    public void process() {
        ESX_Processor.actions.actionDefiniensEqualsBeforeTerm(this);
        setTerm((TermInterface) EsxElementFactory.create(getElement().elements().get(1)));
        ESX_Processor.actions.actionDefiniensEqualsAfterTerm(this);
    }
}
