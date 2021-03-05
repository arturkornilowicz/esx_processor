package org.mizar.esx.article;

import java.util.*;

import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;

@Setter
@Getter
@NoArgsConstructor

public class RightCircumflexSymbol extends EsxElement {

    private String formatnr;
    private String nr;
    private String position;
    private String spelling;

    public RightCircumflexSymbol(Element element) {
        super(element);
        this.formatnr = Misc.assignAttrValue(element, "formatnr");
        this.nr = Misc.assignAttrValue(element, "nr");
        this.position = Misc.assignAttrValue(element, "position");
        this.spelling = Misc.assignAttrValue(element, "spelling");
    }

    @Override
    public String toString() {
        return spelling;
    }

    @Override
    public void process() {
        ESX_Processor.actions.actionRightCircumflexSymbol(this);
    }
}
