package org.mizar.esx.article;

import java.util.*;

import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;

@Setter
@Getter
@NoArgsConstructor

public class TheoremReference extends EsxElement implements ReferenceInterface {

    private String nr;
    private String number;
    private String position;
    private String spelling;

    public TheoremReference(Element element) {
        super(element);
        this.nr = Misc.assignAttrValue(element, "nr");
        this.number = Misc.assignAttrValue(element, "number");
        this.position = Misc.assignAttrValue(element, "position");
        this.spelling = Misc.assignAttrValue(element, "spelling");
    }

    @Override
    public String toString() {
        return spelling + ":" + number;
    }
}
