package org.mizar.esx.article;

import java.util.*;
import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;

@Setter
@Getter
@NoArgsConstructor

public class TypeList extends EsxElement {

    private ArrayList<TypeInterface> types = new ArrayList<>();

    public TypeList(Element element) {
        super(element);
    }

    @Override
    public String toString() {
        return types.toString();
    }
}
