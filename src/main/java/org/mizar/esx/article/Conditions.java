package org.mizar.esx.article;

import java.util.*;
import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;

@Setter
@Getter
@NoArgsConstructor

public class Conditions extends EsxElement {

    private ArrayList<Proposition> propositions = new ArrayList<>();

    public Conditions(Element element) {
        super(element);
    }

    @Override
    public String toString() {
        return "that " + propositions.toString();
    }
}
