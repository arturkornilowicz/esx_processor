package org.mizar.esx.article;

import java.util.*;
import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;

@Setter
@Getter
@NoArgsConstructor

public class Loci extends EsxElement {

    private ArrayList<Locus> loci = new ArrayList<>();

    public Loci(Element element) {
        super(element);
    }

    @Override
    public String toString() {
        return loci.toString();
    }
}
