package org.mizar.esx.article;

import java.util.*;
import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;

@Setter
@Getter
@NoArgsConstructor

public class Link extends EsxElement {

    private String labelnr;
    private String position;

    public Link(Element element) {
        super(element);
        this.labelnr = Misc.assignAttrValue(element,"labelnr");
        this.position = Misc.assignAttrValue(element,"position");
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
