package org.mizar.esx.article;

import java.util.*;
import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;

@Setter
@Getter
@NoArgsConstructor

public class FunctorDefinition extends Item {

    private String MMLId;

    private Redefine redefine;
    private PatternInterface pattern;
    private TypeSpecification typeSpecification;
    private Definiens definiens;

    public FunctorDefinition(Element element) {
        super(element);
        this.MMLId = Misc.assignAttrValue(element,"MMLId");
    }

    @Override
    public String toString() {
        return redefine + "func " + pattern + " " + typeSpecification + "\n" + definiens;
    }
}
