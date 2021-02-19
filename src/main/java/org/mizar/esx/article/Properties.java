package org.mizar.esx.article;

import java.util.*;
import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;

@Setter
@Getter
@NoArgsConstructor

public class Properties extends EsxElement {

    private String property;
    private String sort;

    public Properties(Element element) {
        super(element);
        this.property = Misc.assignAttrValue(element,"property");
        this.sort = Misc.assignAttrValue(element,"sort");
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
