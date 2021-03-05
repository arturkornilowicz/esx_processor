package org.mizar.esx.article;

import java.util.*;

import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;

@Setter
@Getter
@NoArgsConstructor

public class Substitution extends EsxElement {

    private String freevarnr;
    private String kind;
    private String varnr;

    public Substitution(Element element) {
        super(element);
        this.freevarnr = Misc.assignAttrValue(element, "freevarnr");
        this.kind = Misc.assignAttrValue(element, "kind");
        this.varnr = Misc.assignAttrValue(element, "varnr");
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public void process() {
        ESX_Processor.actions.actionSubstitution(this);
    }
}
