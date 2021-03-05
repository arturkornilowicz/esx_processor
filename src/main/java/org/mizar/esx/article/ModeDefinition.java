package org.mizar.esx.article;

import java.util.*;

import lombok.*;
import org.dom4j.*;
import org.mizar.esx.*;
import org.mizar.esx.design.EsxElementFactory;

@Setter
@Getter
@NoArgsConstructor

public class ModeDefinition extends Item {

    private String MMLId;

    private Redefine redefine;
    private ModePattern pattern;
    private ModeDescriptionInterface modeDescription;

    public ModeDefinition(Element element) {
        super(element);
        this.MMLId = Misc.assignAttrValue(element, "MMLId");
    }

    @Override
    public String toString() {
        return redefine + "mode " + pattern + " " + modeDescription;
    }

    @Override
    public void process() {
        ESX_Processor.actions.actionModeDefinitionBeforeRedefine(this);
        setRedefine((Redefine) EsxElementFactory.create(getElement().element("Redefine")));
        ESX_Processor.actions.actionModeDefinitionAfterRedefine(this);

        ESX_Processor.actions.actionModeDefinitionBeforePattern(this);
        setPattern((ModePattern) EsxElementFactory.create(getElement().elements().get(1)));
        ESX_Processor.actions.actionModeDefinitionAfterPattern(this);

        ESX_Processor.actions.actionModeDefinitionBeforeModeDescription(this);
        setModeDescription((ModeDescriptionInterface) EsxElementFactory.create(getElement().elements().get(2)));
        ESX_Processor.actions.actionModeDefinitionAfterModeDescription(this);
    }
}
