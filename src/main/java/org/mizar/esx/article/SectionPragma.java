package org.mizar.esx.article;

import java.util.*;

import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;

@Setter
@Getter
@NoArgsConstructor

public class SectionPragma extends Item {

    public SectionPragma(Element element) {
        super(element);
    }

    @Override
    public String toString() {
        return "begin";
    }

    @Override
    public void process() {
        ESX_Processor.actions.actionSection(this);
    }
}
