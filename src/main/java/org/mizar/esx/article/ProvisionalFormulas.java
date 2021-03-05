package org.mizar.esx.article;

import java.util.*;

import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;
import org.mizar.esx.design.EsxElementFactory;

@Setter
@Getter
@NoArgsConstructor

public class ProvisionalFormulas extends EsxElement {

    private ArrayList<Proposition> provisionals = new ArrayList<>();

    public ProvisionalFormulas(Element element) {
        super(element);
    }

    @Override
    public String toString() {
        return provisionals.size() > 0 ? "\nprovided " + provisionals.toString() : "";
    }

    @Override
    public void process() {
        ESX_Processor.actions.actionProvisionalFormulasBefore(this);
        for (Element element : getElement().elements())
            getProvisionals().add((Proposition) EsxElementFactory.create(element));
        ESX_Processor.actions.actionProvisionalFormulasAfter(this);
    }
}
