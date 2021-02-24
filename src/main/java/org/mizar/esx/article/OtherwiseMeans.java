package org.mizar.esx.article;

import java.util.*;
import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;

@Setter
@Getter
@NoArgsConstructor

public class OtherwiseMeans extends Otherwise {

    private FormulaInterface formula;

    public OtherwiseMeans(Element element) {
        super(element);
    }

    @Override
    public String toString() {
        return "otherwise " + formula;
    }
}
