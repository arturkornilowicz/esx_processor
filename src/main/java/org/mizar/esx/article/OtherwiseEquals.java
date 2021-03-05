package org.mizar.esx.article;

import java.util.*;

import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;
import org.mizar.esx.design.EsxElementFactory;

@Setter
@Getter
@NoArgsConstructor

public class OtherwiseEquals extends Otherwise {

    private TermInterface term;

    public OtherwiseEquals(Element element) {
        super(element);
    }

    @Override
    public String toString() {
        return "otherwise " + term;
    }

    @Override
    public void process() {
        if (getElement().elements().size() > 0) {
            ESX_Processor.actions.actionOtherwiseEqualsBeforeTerm(this);
            setTerm((TermInterface) EsxElementFactory.create(getElement().elements().get(0)));
            ESX_Processor.actions.actionOtherwiseEqualsAfterTerm(this);
        }
    }
}
