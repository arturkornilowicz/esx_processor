package org.mizar.esx.article;

import java.util.*;
import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;

@Setter
@Getter
@NoArgsConstructor

public class DefiniensEqualsComplex extends DefiniensComplex {

    public DefiniensEqualsComplex(Element element) {
        super(element);
    }

    @Override
    public String toString() { return super.toString(); }
}
