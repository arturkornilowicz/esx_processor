package org.mizar.esx.article;

import java.util.*;
import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;

@Setter
@Getter
@NoArgsConstructor

public class AttributeDefinition extends Item {

    private String MMLId;

    private Redefine redefine;
    private AttributePattern pattern;
    private Definiens definiens;

    public AttributeDefinition(Element element) {
        super(element);
        this.MMLId = Misc.assignAttrValue(element,"MMLId");
    }

    @Override
    public String toString() {
        return redefine + "attr " + pattern + "\n" + definiens;
    }
}
