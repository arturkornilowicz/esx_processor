package org.mizar.esx.article;

import java.util.*;

import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;

@Setter
@Getter
@NoArgsConstructor

public class PlaceholderTerm extends EsxElement {

    private String nr;
    private String position;
    private String sort;
    private String spelling;
    private String varnr;

    public PlaceholderTerm(Element element) {
        super(element);
        this.nr = Misc.assignAttrValue(element, "nr");
        this.position = Misc.assignAttrValue(element, "position");
        this.sort = Misc.assignAttrValue(element, "sort");
        this.spelling = Misc.assignAttrValue(element, "spelling");
        this.varnr = Misc.assignAttrValue(element, "varnr");
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
