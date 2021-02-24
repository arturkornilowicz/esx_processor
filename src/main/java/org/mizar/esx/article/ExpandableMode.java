package org.mizar.esx.article;

import java.util.*;
import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;

@Setter
@Getter
@NoArgsConstructor

public class ExpandableMode extends EsxElement implements ModeDescriptionInterface {

    private TypeInterface type;

    public ExpandableMode(Element element) {
        super(element);
    }

    @Override
    public String toString() {
        return "is " + type;
    }
}
