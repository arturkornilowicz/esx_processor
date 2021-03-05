package org.mizar.esx.article;

import java.util.*;

import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;
import org.mizar.esx.design.EsxElementFactory;

@Setter
@Getter
@NoArgsConstructor

public class ReservedDscrType extends EsxElement implements TypeInterface {

    private String idnr;
    private String nr;
    private String position;
    private String sort;

    private Substitutions substitutions;
    private TypeInterface type;

    public ReservedDscrType(Element element) {
        super(element);
        this.idnr = Misc.assignAttrValue(element, "idnr");
        this.nr = Misc.assignAttrValue(element, "nr");
        this.position = Misc.assignAttrValue(element, "position");
        this.sort = Misc.assignAttrValue(element, "sort");
    }

    @Override
    public String toString() {
        return type.toString();
    }

    @Override
    public void process() {
        ESX_Processor.actions.actionReservedDscrTypeBeforeSubstitutions(this);
        setSubstitutions((Substitutions) EsxElementFactory.create(getElement().element("Substitutions")));
        ESX_Processor.actions.actionReservedDscrTypeAfterSubstitutions(this);

        ESX_Processor.actions.actionReservedDscrTypeBeforeType(this);
        setType((TypeInterface) EsxElementFactory.create(getElement().elements().get(1)));
        ESX_Processor.actions.actionReservedDscrTypeAfterType(this);
    }
}
