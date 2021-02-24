package org.mizar.esx.article;

import java.util.*;
import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;

@Setter
@Getter
@NoArgsConstructor

public class DefiniensComplex extends Definiens {

    private PartialDefiniensList partialDefiniensList;
    private Otherwise otherwise;

    public DefiniensComplex(Element element) {
        super(element);
    }

    @Override
    public String toString() { return partialDefiniensList + " " + otherwise; }
}
