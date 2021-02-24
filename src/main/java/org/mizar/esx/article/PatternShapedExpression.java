package org.mizar.esx.article;

import java.util.*;
import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;

@Setter
@Getter
@NoArgsConstructor

public class PatternShapedExpression extends EsxElement {

    private PatternInterface pattern;

    public PatternShapedExpression(Element element) {
        super(element);
    }

    @Override
    public String toString() {
        return pattern.toString();
    }
}
