package org.mizar.esx.article;

import java.util.*;
import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;

@Setter
@Getter
@NoArgsConstructor

public class LociEquality extends EsxElement {

    private String position;

    private Locus locus_1;
    private Locus locus_2;

    public LociEquality(Element element) {
        super(element);
        this.position = Misc.assignAttrValue(element,"position");
    }

    @Override
    public String toString() {
        return locus_1 + " = " + locus_2;
    }
}
