package org.mizar.esx.article;

import java.util.*;
import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;

@Setter
@Getter
@NoArgsConstructor

public class DefiniensEquals extends Definiens {

    private TermInterface term;

    public DefiniensEquals(Element element) {
        super(element);
    }

    @Override
    public String toString() { return term.toString(); }
}
