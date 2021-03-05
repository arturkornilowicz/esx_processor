package org.mizar.esx.article;

import java.util.*;

import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;

@Setter
@Getter
@NoArgsConstructor

public class NotionName extends EsxElement implements PragmaInterface {

    private String inscription;
    private String position;

    public NotionName(Element element) {
        super(element);
        this.inscription = Misc.assignAttrValue(element, "inscription");
        this.position = Misc.assignAttrValue(element, "position");
    }

    @Override
    public String toString() {
        return "::$N " + inscription;
    }

    @Override
    public void process() {
        ESX_Processor.actions.actionNotionName(this);
    }
}
