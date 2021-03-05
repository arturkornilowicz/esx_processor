package org.mizar.esx.article;

import java.util.*;

import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;
import org.mizar.esx.design.EsxElementFactory;

@Setter
@Getter
@NoArgsConstructor

public class SimpleFraenkelTerm extends EsxElement implements TermInterface {

    private String position;
    private String sort;

    private VariableSegments variableSegments;
    private TermInterface term;

    public SimpleFraenkelTerm(Element element) {
        super(element);
        this.position = Misc.assignAttrValue(element, "position");
        this.sort = Misc.assignAttrValue(element, "sort");
    }

    @Override
    public String toString() {
        return "the set of all " + term + " where " + variableSegments;
    }

    @Override
    public void process() {
        ESX_Processor.actions.actionSimpleFraenkelTermBeforeVariableSegments(this);
        setVariableSegments((VariableSegments) EsxElementFactory.create(getElement().elements().get(0)));
        ESX_Processor.actions.actionSimpleFraenkelTermAfterVariableSegments(this);

        ESX_Processor.actions.actionSimpleFraenkelTermBeforeTerm(this);
        setTerm((TermInterface) EsxElementFactory.create(getElement().elements().get(1)));
        ESX_Processor.actions.actionSimpleFraenkelTermAfterTerm(this);
    }
}
