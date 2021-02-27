package org.mizar.esx.article;

import java.util.*;
import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;

@Setter
@Getter
@NoArgsConstructor

public class ModeDefinition extends Item {

    private String MMLId;

    private Redefine redefine;
    private ModePattern pattern;
    private ModeDescriptionInterface modeDescription;

    public ModeDefinition(Element element) {
        super(element);
        this.MMLId = Misc.assignAttrValue(element,"MMLId");
    }

    @Override
    public String toString() { return redefine + "mode " + pattern + " " + modeDescription; }
}
