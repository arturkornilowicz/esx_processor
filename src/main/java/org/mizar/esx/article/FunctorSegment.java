package org.mizar.esx.article;

import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;
import org.mizar.esx.design.EsxElementFactory;

@Setter
@Getter
@NoArgsConstructor

public class FunctorSegment extends EsxElement implements SchemaInputSegmentInterface {

    private String position;

    private Variables variables;
    private TypeList argumentTypes;
    private TypeSpecification resultType;

    public FunctorSegment(Element element) {
        super(element);
        this.position = Misc.assignAttrValue(element, "position");
    }

    @Override
    public String toString() {
        return variables + " (" + argumentTypes + ") " + resultType;
    }

    @Override
    public void process() {
        ESX_Processor.actions.actionFunctorSegmentBeforeVariables(this);
        setVariables((Variables) EsxElementFactory.create(getElement().element("Variables")));
        ESX_Processor.actions.actionFunctorSegmentAfterVariables(this);

        ESX_Processor.actions.actionFunctorSegmentBeforeArgumentTypes(this);
        setArgumentTypes((TypeList) EsxElementFactory.create(getElement().element("Type-List")));
        ESX_Processor.actions.actionFunctorSegmentAfterArgumentTypes(this);

        ESX_Processor.actions.actionFunctorSegmentBeforeResultType(this);
        setResultType((TypeSpecification) EsxElementFactory.create(getElement().element("Type-Specification")));
        ESX_Processor.actions.actionFunctorSegmentAfterResultType(this);
    }
}
