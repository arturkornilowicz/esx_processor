package org.mizar.esx.article;

import java.util.*;
import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;

@Setter
@Getter
@NoArgsConstructor

public class TextProper extends EsxElement {

    private String articleext;
    private String articleid;
    private String position;

    public TextProper(Element element) {
        super(element);
        this.articleext = Misc.assignAttrValue(element,"articleext");
        this.articleid = Misc.assignAttrValue(element,"articleid");
        this.position = Misc.assignAttrValue(element,"position");
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
