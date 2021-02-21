package org.mizar.esx.article;

import lombok.*;
import org.dom4j.*;

@Setter
@Getter
@NoArgsConstructor

public class Pragma extends Item {

    private PragmaInterface pragma;

    public Pragma(Element element) {
        super(element);
    }

    @Override
    public String toString() {
        return pragma.toString();
    }
}
