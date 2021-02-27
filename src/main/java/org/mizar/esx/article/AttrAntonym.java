package org.mizar.esx.article;

import java.util.*;
import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;

@Setter
@Getter
@NoArgsConstructor

public class AttrAntonym extends Item {

    private AttributePattern antonym;
    private PatternShapedExpression original;

    public AttrAntonym(Element element) {
        super(element);
    }

    @Override
    public String toString() {
        return "antonym " + antonym + " for " + original;
    }
}
