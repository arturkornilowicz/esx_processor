package org.mizar.esx;

import lombok.*;
import org.dom4j.*;
import org.mizar.esx.article.*;
import org.mizar.esx.xml.XMLApplication;
import org.mizar.esx.errors.*;

@Setter
@Getter

public class ESX_Processor extends XMLApplication {

    private TextProper textProper;

    public ESX_Processor(String pathName, String fileName, String fileExtension) {
        super(pathName, fileName, fileExtension);
    }

    private Arguments processArguments(Element e) {
        Arguments result = new Arguments();
        for (Element element : e.elements())
            result.getArguments().add(processTerm(element));
        return result;
    }

    private ExplicitlyQualifiedSegment processExplicitlyQualifiedSegment(Element e) {
        ExplicitlyQualifiedSegment result = new ExplicitlyQualifiedSegment();
        result.setVariables(processVariables(e.element("Variables")));
        result.setType(processType(e.elements().get(1)));
        return result;
    }

    private FormulaInterface processFormula(Element e) {
        FormulaInterface result = null;
        switch (e.getName()) {
            case "Relation-Formula":
                result = processRelationFormula(e);
                break;
            case "Universal-Quantifier-Formula":
                result = processUniversalQuantifierFormula(e);
                break;
            default:
                Errors.error(e, "FORMULA");
        }
        return result;
    }

    private FreeVariableSegment processFreeVariableSegment(Element e) {
        FreeVariableSegment result = new FreeVariableSegment();
        result.setVariable(processVariable(e.element("Variable")));
        result.setType(processType(e.elements().get(1)));
        return result;
    }

    private ImplicitlyQualifiedSegment processImplicitlyQualifiedSegment(Element e) {
        ImplicitlyQualifiedSegment result = new ImplicitlyQualifiedSegment();
        result.setVariable(processVariable(e.element("Variable")));
        result.setType(processType(e.elements().get(1)));
        return result;
    }

    private JustificationInterface processJustification(Element e) {
        JustificationInterface result = null;
        return result;
    }

    private Label processLabel(Element e) {
        Label result = new Label(e);
        return result;
    }

    private NumeralTerm processNumeralTerm(Element e) {
        return new NumeralTerm(e);
    }

    private Proposition processProposition(Element e) {
        Proposition result = new Proposition();
        result.setLabel(processLabel(e.element("Label")));
        result.setFormula(processFormula(e.elements().get(1)));
        return result;
    }

    private RelationFormula processRelationFormula(Element e) {
        RelationFormula result = new RelationFormula(e);
        result.setArguments(processArguments(e.element("Arguments")));
        return result;
    }

    private Reservation processReservation(Element e) {
        Reservation result = new Reservation(e);
        for (Element element: e.elements())
            result.getReservationSegments().add(processReservationSegment(element));
        return result;
    }

    private ReservationSegment processReservationSegment(Element e) {
        ReservationSegment result = new ReservationSegment(e);
        result.setVariables(processVariables(e.element("Variables")));
        result.setVariableSegments(processVariableSegments(e.element("Variable-Segments")));
        result.setType(processType(e.elements().get(2)));
        return result;
    }

    private ReservedDscrType processReservedDscrType(Element e) {
        ReservedDscrType result = new ReservedDscrType(e);
        result.setSubstitutions(processSubstitutions(e.element("Substitutions")));
        result.setType(processType(e.elements().get(1)));
        return result;
    }

    private SectionPragma processSection(Element e) {
        SectionPragma result = new SectionPragma(e);
        return result;
    }

    private SimpleTerm processSimpleTerm(Element e) {
        return new SimpleTerm(e);
    }

    private StandardType processStandardType(Element e) {
        StandardType result = new StandardType(e);
        return result;
    }

    private Substitutions processSubstitutions(Element e) {
        Substitutions result = new Substitutions();
        return result;
    }

    private TermInterface processTerm(Element e) {
        TermInterface result = null;
        switch (e.getName()) {
            case "Numeral-Term":
                result = processNumeralTerm(e);
                break;
            case "Simple-Term":
                result = processSimpleTerm(e);
                break;
            default:
                Errors.error(e, "UNKNOWN TERM");
        }
        return result;
    }

    private TextProper processTextProper(Element e) {
        TextProper result = new TextProper(e);
        return result;
    }

    private TheoremItem processTheoremItem(Element e) {
        TheoremItem result = new TheoremItem(e);
        result.setProposition(processProposition(e.element("Proposition")));
        result.setJustification(processJustification(e.elements().get(1)));
        return result;
    }

    private TypeInterface processType(Element e) {
        TypeInterface result = null;
        switch (e.getName()) {
            case "ReservedDscr-Type":
                result = processReservedDscrType(e);
                break;
            case "Standard-Type":
                result = processStandardType(e);
                break;
            default:
                Errors.error(e, "UNKNOWN TYPE");
        }
        return result;
    }

    private UniversalQuantifierFormula processUniversalQuantifierFormula(Element e) {
        UniversalQuantifierFormula result = new UniversalQuantifierFormula(e);
        result.setVariableSegments(processVariableSegments(e.element("Variable-Segments")));
        result.setScope(processFormula(e.elements().get(1)));
        return result;
    }

    private Variable processVariable(Element e) {
        return new Variable(e);
    }

    private Variables processVariables(Element e) {
        Variables result = new Variables();
        for (Element element : e.elements())
            result.getVariables().add(processVariable(element));
        return result;
    }

    private VariableSegmentInterface processVariableSegment(Element e) {
        VariableSegmentInterface result = null;
        switch (e.getName()) {
            case "Explicitly-Qualified-Segment":
                result = processExplicitlyQualifiedSegment(e);
                break;
            case "Free-Variable-Segment":
                result = processFreeVariableSegment(e);
                break;
            case "Implicitly-Qualified-Segment":
                result = processImplicitlyQualifiedSegment(e);
                break;
            default:
                Errors.error(e, "UNKNOWN SEGMENT");
        }
        return result;
    }

    private VariableSegments processVariableSegments(Element e) {
        VariableSegments result = new VariableSegments();
        for (Element element : e.elements())
            result.getVariableSegments().add(processVariableSegment(element));
        return result;
    }

    private Item processItem(Element e) {
        Item result = null;
        switch (e.getName()) {
            case "Reservation":
                result = processReservation(e);
                break;
            case "Section-Pragma":
                result = processSection(e);
                break;
            case "Theorem-Item":
                result = processTheoremItem(e);
                break;
            default:
                Errors.error(e, "UNKNOWN Item");
        }
        BlocksItems.lastBlock().addItem(result);
        BlocksItems.addItem(result);
        return result;
    }

    private void preProcess(Element e) {
        switch (e.getName()) {
            case "Text-Proper":
                this.textProper = processTextProper(e);
                BlocksItems.addBlock(this.textProper);
                break;
            case "Item":
                processItem(e.elements().get(0));
                break;
            case "Block":
                break;
//            default:
//                Errors.error(e, "Missing Element in preProcess");
        }
    }

    private void processItemEnd(Element e) {
        switch (e.attributeValue("kind")) {
            case "Section-Pragma":
            case "Definition-Item":
            case "Generalization":
            case "Default-Generalization":
            case "Pragma":
                break;
            default:
        }
    }

    private void postProcess(Element e) {
        switch (e.getName()) {
            case "Text-Proper":
                BlocksItems.removeLastBlock();
                break;
            case "Item":
                break;
            case "Block":
                break;
        }
    }

    private void treeWalk(Document document) {
        preProcess(document.getRootElement());
        treeWalk(document.getRootElement());
        postProcess(document.getRootElement());
    }

    private void treeWalk(Element element) {
        for (Element elem : element.elements()) {
            preProcess(elem);
            treeWalk(elem);
            postProcess(elem);
        }
    }

    public void processArticle() {
        treeWalk(getXmlDocument());
    }
}
