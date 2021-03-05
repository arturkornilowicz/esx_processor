package org.mizar.esx.article;

import java.util.*;

import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;
import org.mizar.esx.design.EsxElementFactory;

@Setter
@Getter
@NoArgsConstructor

public class ExistentialAssumption extends Item {

    private QualifiedSegments qualifiedSegments;
    private Conditions conditions;

    public ExistentialAssumption(Element element) {
        super(element);
    }

    @Override
    public String toString() {
        return "given " + qualifiedSegments + " such " + conditions;
    }

    @Override
    public void process() {
        ESX_Processor.actions.actionExistentialAssumptionBeforeQualifiedSegments(this);
        setQualifiedSegments((QualifiedSegments) EsxElementFactory.create(getElement().element("Qualified-Segments")));
        ESX_Processor.actions.actionExistentialAssumptionAfterQualifiedSegments(this);

        ESX_Processor.actions.actionExistentialAssumptionBeforeConditions(this);
        setConditions((Conditions) EsxElementFactory.create(getElement().element("Conditions")));
        ESX_Processor.actions.actionExistentialAssumptionAfterConditions(this);
    }
}
