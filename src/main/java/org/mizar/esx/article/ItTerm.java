package org.mizar.esx.article;

import java.util.*;

import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;

@Setter
@Getter
@NoArgsConstructor

public class ItTerm extends EsxElement implements TermInterface {

    private String position;
    private String sort;

    public ItTerm(Element element) {
        super(element);
        this.position = Misc.assignAttrValue(element, "position");
        this.sort = Misc.assignAttrValue(element, "sort");
    }

    @Override
    public String toString() {
        return "it";
    }

    @Override
    public void process() {
        ESX_Processor.actions.actionItTerm(this);
    }
}
