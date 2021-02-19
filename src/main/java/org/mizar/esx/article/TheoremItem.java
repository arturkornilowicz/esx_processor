package org.mizar.esx.article;

import java.util.*;
import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;

@Setter
@Getter
@NoArgsConstructor

public class TheoremItem extends Item {

    private String MMLId;

    private Proposition proposition;
    private JustificationInterface justification;

    public TheoremItem(Element element) {
        super(element);
        this.MMLId = Misc.assignAttrValue(element,"MMLId");
    }

    @Override
    public String toString() {
        return "theorem ::" + getMMLId() + "\n" + proposition + "\n" + justification + ";";
    }
}
