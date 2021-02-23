package org.mizar.esx.article;

import java.util.*;
import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;

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
}
