package org.mizar.esx.article;

import java.util.*;
import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;

@Setter
@Getter
@NoArgsConstructor

public class Substitutions extends EsxElement {

    private ArrayList<Substitution> substitutions = new ArrayList<>();

    public Substitutions(Element element) {
        super(element);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
