package org.mizar.esx.article;

import java.util.*;

import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;

@Setter
@Getter
@NoArgsConstructor

public class Redefine extends EsxElement {

    private String occurs;

    public Redefine(Element element) {
        super(element);
        this.occurs = Misc.assignAttrValue(element, "occurs");
    }

    @Override
    public String toString() {
        return occurs.equals("true") ? "redefine " : "";
    }

    @Override
    public void process() {
        ESX_Processor.actions.actionRedefine(this);
    }
}
