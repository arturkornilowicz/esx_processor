package org.mizar.esx.article;

import java.util.*;
import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;

@Setter
@Getter
@NoArgsConstructor

public class Arguments extends EsxElement {

    private ArrayList<TermInterface> arguments = new ArrayList<>();

    public Arguments(Element element) {
        super(element);
    }

    @Override
    public String toString() {
        return arguments.toString();
    }
}
