package org.mizar.esx.article;

import java.util.*;
import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;

@Setter
@Getter
@NoArgsConstructor

public class PredAntonym extends Item {

    private PatternInterface antonym;
    private PatternShapedExpression original;

    public PredAntonym(Element element) {
        super(element);
    }

    @Override
    public String toString() {
        return "antonym " + antonym + " for " + original;
    }
}
