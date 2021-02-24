package org.mizar.esx.article;

import java.util.*;
import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;

@Setter
@Getter
@NoArgsConstructor

public class LociEqualities extends EsxElement {

    ArrayList<LociEquality> lociEqualities = new ArrayList<>();

    public LociEqualities(Element element) {
        super(element);
    }

    @Override
    public String toString() {
        return lociEqualities.size() > 0 ? "when " + lociEqualities : "";
    }
}
