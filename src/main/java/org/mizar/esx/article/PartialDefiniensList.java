package org.mizar.esx.article;

import java.util.*;

import lombok.*;
import org.dom4j.*;
import org.mizar.esx.ESX_Processor;
import org.mizar.esx.design.EsxElementFactory;

@Setter
@Getter
@NoArgsConstructor

public class PartialDefiniensList<E extends PartialDefiniens> extends EsxElement implements PartialDefiniensListInterface {

    private ArrayList<E> partialDefiniens = new ArrayList<>();

    public PartialDefiniensList(Element element) {
        super(element);
    }

    @Override
    public String toString() {
        return partialDefiniens.toString();
    }
}
