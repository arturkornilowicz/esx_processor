package org.mizar.esx.article;

import java.util.*;
import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;

@Setter
@Getter
@NoArgsConstructor

public class FuncSynonym extends Item {

    private PatternInterface synonym;
    private PatternShapedExpression original;

    public FuncSynonym(Element element) {
        super(element);
    }

    @Override
    public String toString() {
        return "synonym " + synonym + " for " + original;
    }
}
