package org.mizar.esx.article;

import java.util.*;
import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;

@Setter
@Getter
@NoArgsConstructor

public class Identify extends Item {

    private PatternShapedExpression leftPatternShapedExpression;
    private PatternShapedExpression rightPatternShapedExpression;
    private LociEqualities lociEqualities;

    public Identify(Element element) {
        super(element);
    }

    @Override
    public String toString() {
        return "identify " + leftPatternShapedExpression + " with " + rightPatternShapedExpression + " " + lociEqualities;
    }
}
