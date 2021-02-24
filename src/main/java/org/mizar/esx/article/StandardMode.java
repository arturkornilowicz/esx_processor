package org.mizar.esx.article;

import java.util.*;
import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;

@Setter
@Getter
@NoArgsConstructor

public class StandardMode extends EsxElement implements ModeDescriptionInterface {

    private TypeSpecification typeSpecification;
    private Definiens definiens;

    public StandardMode(Element element) {
        super(element);
    }

    @Override
    public String toString() {
        return typeSpecification + "\n" + definiens;
    }
}
