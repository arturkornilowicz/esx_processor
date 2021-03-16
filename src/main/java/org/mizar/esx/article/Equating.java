package org.mizar.esx.article;

import java.util.*;

import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;
import org.mizar.esx.design.EsxElementFactory;

@Setter
@Getter
@NoArgsConstructor

public class Equating extends EsxElement {

    private Variable variable;
    private TermInterface term;

    public Equating(Element element) {
        super(element);
    }

    @Override
    public String toString() {
        return variable + " = " + term;
    }

    @Override
    public void process() {
        setVariable((Variable) EsxElementFactory.create(getElement().element("Variable")));
        setTerm((TermInterface) EsxElementFactory.create(getElement().elements().get(1)));
    }
}
