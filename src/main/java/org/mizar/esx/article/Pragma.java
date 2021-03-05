package org.mizar.esx.article;

import lombok.*;
import org.dom4j.*;
import org.mizar.esx.ESX_Processor;
import org.mizar.esx.design.EsxElementFactory;

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

    @Override
    public void process() {
        ESX_Processor.actions.actionPragmaBefore(this);
        setPragma((PragmaInterface) EsxElementFactory.create(getElement().elements().get(0)));
        ESX_Processor.actions.actionPragmaAfter(this);
    }
}
