package org.mizar.esx.article;

import lombok.*;
import org.dom4j.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class EsxElement {

    private Element element;

    @Override
    public String toString() { return element.getName(); }
}
