package org.mizar.esx.article;

import java.util.*;

import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;
import org.mizar.esx.design.EsxElementFactory;

@Setter
@Getter
@NoArgsConstructor

public class SchemeHead extends Item {

    private Scheme scheme;
    private SchematicVariables schematicVariables;
    private FormulaInterface formula;
    private ProvisionalFormulas provisionalFormulas;

    public SchemeHead(Element element) {
        super(element);
    }

    @Override
    public String toString() {
        return scheme + " " + schematicVariables + ":\n" + formula + " " + provisionalFormulas;
    }

    @Override
    public void process() {
        ESX_Processor.actions.actionSchemeHeadBeforeScheme(this);
        setScheme((Scheme) EsxElementFactory.create(getElement().element("Scheme")));
        ESX_Processor.actions.actionSchemeHeadAfterScheme(this);

        ESX_Processor.actions.actionSchemeHeadBeforeSchematicVariables(this);
        setSchematicVariables((SchematicVariables) EsxElementFactory.create(getElement().element("Schematic-Variables")));
        ESX_Processor.actions.actionSchemeHeadAfterSchematicVariables(this);

        ESX_Processor.actions.actionSchemeHeadBeforeFormula(this);
        setFormula((FormulaInterface) EsxElementFactory.create(getElement().elements().get(2)));
        ESX_Processor.actions.actionSchemeHeadAfterFormula(this);

        ESX_Processor.actions.actionSchemeHeadBeforeProvisionalFormulas(this);
        setProvisionalFormulas((ProvisionalFormulas) EsxElementFactory.create(getElement().element("Provisional-Formulas")));
        ESX_Processor.actions.actionSchemeHeadAfterProvisionalFormulas(this);
    }
}
