package org.mizar.esx.article;

import java.util.*;
import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;

@Setter
@Getter
@NoArgsConstructor

public class Selector extends EsxElement {

    private String nr;
    private String position;
    private String spelling;

    private Locus locus;

    public Selector(Element element) {
        super(element);
        this.nr = Misc.assignAttrValue(element,"nr");
        this.position = Misc.assignAttrValue(element,"position");
        this.spelling = Misc.assignAttrValue(element,"spelling");
    }

    @Override
    public String toString() {
        return locus.toString();
    }
}
