package org.mizar.esx.article;

import java.util.*;
import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;

@Setter
@Getter
@NoArgsConstructor

public class PredicateDefinition extends Item {

    private String MMLId;

    private Redefine redefine;
    private PatternInterface pattern;
    private Definiens definiens;

    public PredicateDefinition(Element element) {
        super(element);
        this.MMLId = Misc.assignAttrValue(element,"MMLId");
    }

    @Override
    public String toString() {
        return redefine + "pred " + pattern + "\n" + definiens;
    }
}
