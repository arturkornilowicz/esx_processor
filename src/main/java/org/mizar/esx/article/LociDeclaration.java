package org.mizar.esx.article;

import java.util.*;

import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;
import org.mizar.esx.design.EsxElementFactory;

@Setter
@Getter
@NoArgsConstructor

public class LociDeclaration extends Item {

    QualifiedSegments qualifiedSegments;

    public LociDeclaration(Element element) {
        super(element);
    }

    @Override
    public String toString() {
        return "let " + qualifiedSegments.toString();
    }

    @Override
    public void process() {
        ESX_Processor.actions.actionLociDeclarationBeforeQualifiedSegments(this);
        setQualifiedSegments((QualifiedSegments) EsxElementFactory.create(getElement().element("Qualified-Segments")));
        ESX_Processor.actions.actionLociDeclarationAfterQualifiedSegments(this);
    }
}
