package org.mizar.esx.article;

import java.util.*;
import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;

@Setter
@Getter
@NoArgsConstructor

public class PartialDefiniensList extends EsxElement {

    private ArrayList<PartialDefiniens> partialDefiniens = new ArrayList<>();

    public PartialDefiniensList(Element element) {
        super(element);
    }

    @Override
    public String toString() { return partialDefiniens.toString(); }
}
