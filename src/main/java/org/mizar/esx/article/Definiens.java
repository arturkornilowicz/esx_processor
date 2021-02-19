package org.mizar.esx.article;

import java.util.*;
import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;

@Setter
@Getter
@NoArgsConstructor

public class Definiens extends EsxElement {

    private String kind;
    private String position;
    private String shape;

    public Definiens(Element element) {
        super(element);
        this.kind = Misc.assignAttrValue(element,"kind");
        this.position = Misc.assignAttrValue(element,"position");
        this.shape = Misc.assignAttrValue(element,"shape");
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
