package org.mizar.esx.article;

import java.util.*;

import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;
import org.mizar.esx.design.EsxElementFactory;

@Setter
@Getter
@NoArgsConstructor

public class LociEquality extends EsxElement {

    private String position;

    private Locus locus_1;
    private Locus locus_2;

    public LociEquality(Element element) {
        super(element);
        this.position = Misc.assignAttrValue(element, "position");
    }

    @Override
    public String toString() {
        return locus_1 + " = " + locus_2;
    }

    @Override
    public void process() {
        ESX_Processor.actions.actionLociEqualityBeforeLocus_1(this);
        setLocus_1((Locus) EsxElementFactory.create(getElement().elements().get(0)));
        ESX_Processor.actions.actionLociEqualityAfterLocus_1(this);

        ESX_Processor.actions.actionLociEqualityBeforeLocus_2(this);
        setLocus_2((Locus) EsxElementFactory.create(getElement().elements().get(1)));
        ESX_Processor.actions.actionLociEqualityAfterLocus_2(this);
    }
}
