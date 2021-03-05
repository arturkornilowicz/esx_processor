package org.mizar.esx.article;

import lombok.*;
import org.dom4j.*;

@Setter
@Getter
@NoArgsConstructor

public class DefiniensComplex extends Definiens {

    private PartialDefiniensListInterface partialDefiniensList;
    private Otherwise otherwise;

    public DefiniensComplex(Element element) {
        super(element);
    }

    @Override
    public String toString() {
        return partialDefiniensList + " " + otherwise;
    }
}
