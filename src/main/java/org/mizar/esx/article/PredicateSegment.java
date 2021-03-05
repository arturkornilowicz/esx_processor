package org.mizar.esx.article;

import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;
import org.mizar.esx.design.EsxElementFactory;

@Setter
@Getter
@NoArgsConstructor

public class PredicateSegment extends EsxElement implements SchemaInputSegmentInterface {

    private String position;

    private Variables variables;
    private TypeList argumentTypes;

    public PredicateSegment(Element element) {
        super(element);
        this.position = Misc.assignAttrValue(element, "position");
    }

    @Override
    public String toString() {
        return variables + "[" + argumentTypes + "]";
    }

    @Override
    public void process() {
        ESX_Processor.actions.actionPredicateSegmentBeforeVariables(this);
        setVariables((Variables) EsxElementFactory.create(getElement().element("Variables")));
        ESX_Processor.actions.actionPredicateSegmentAfterVariables(this);

        ESX_Processor.actions.actionPredicateSegmentBeforeArgumentTypes(this);
        setArgumentTypes((TypeList) EsxElementFactory.create(getElement().element("Type-List")));
        ESX_Processor.actions.actionPredicateSegmentAfterArgumentTypes(this);
    }
}
