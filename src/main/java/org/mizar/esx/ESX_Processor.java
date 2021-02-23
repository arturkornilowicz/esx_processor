package org.mizar.esx;

import lombok.*;
import org.dom4j.*;
import org.mizar.esx.article.*;
import org.mizar.esx.article.Attribute;
import org.mizar.esx.xml.XMLApplication;
import org.mizar.esx.errors.*;

@Setter
@Getter

public class ESX_Processor extends XMLApplication {

    private TextProper textProper;

    public ESX_Processor(String pathName, String fileName, String fileExtension) {
        super(pathName, fileName, fileExtension);
    }

    private AdjectiveCluster processAdjectiveCluster(Element e) {
        AdjectiveCluster result = new AdjectiveCluster(e);
        for (Element element: e.elements())
           result.getAttributes().add(processAttribute(element));
        return result;
    }

    private Arguments processArguments(Element e) {
        Arguments result = new Arguments();
        for (Element element : e.elements())
            result.getArguments().add(processTerm(element));
        return result;
    }

    private Assumption processAssumption(Element e) {
        Assumption result = new Assumption(e);
        switch (e.getName()) {
            case "Collective-Assumption":
                result.setAssumption(processCollectiveAssumption(e));
                break;
            case "Single-Assumption":
                result.setAssumption(processSingleAssumption(e));
                break;
            default:
                Errors.error(e,"UNKNOWN Assumption");
        }
        return result;
    }

    private Attribute processAttribute(Element e) {
        Attribute result = new Attribute(e);
        result.setArguments(processArguments(e.element("Arguments")));
        return result;
    }

    private BiconditionalFormula processBiconditionalFormula(Element e) {
        BiconditionalFormula result = new BiconditionalFormula(e);
        result.setArg1(processFormula(e.elements().get(0)));
        result.setArg2(processFormula(e.elements().get(1)));
        return result;
    }

    private BinaryFormula processBinaryFormula(Element e) {
        BinaryFormula result = new BinaryFormula(e);
        result.setArg1(processFormula(e.elements().get(0)));
        result.setArg2(processFormula(e.elements().get(1)));
        return result;
    }

    private Canceled processCanceled(Element e) {
        return new Canceled(e);
    }

    private CircumfixTerm processCircumfixTerm(Element e) {
        CircumfixTerm result = new CircumfixTerm(e);
        result.setRightCircumflexSymbol(processRightCircumflexSymbol(e.element("Right-Circumflex-Symbol")));
        result.setArguments(processArguments(e.element("Arguments")));
        return result;
    }

    private ClusteredType processClusteredType(Element e) {
        ClusteredType result = new ClusteredType(e);
        result.setAdjectiveCluster(processAdjectiveCluster(e.element("Adjective-Cluster")));
        result.setType(processType(e.elements().get(1)));
        return result;
    }

    private Coherence processCoherence(Element e) {
        return new Coherence(e);
    }

    private CollectiveAssumption processCollectiveAssumption(Element e) {
        CollectiveAssumption result = new CollectiveAssumption(e);
        result.setConditions(processConditions(e.element("Conditions")));
        return result;
    }

    private Compatibility processCompatibility(Element e) {
        return new Compatibility(e);
    }

    private ConditionalFormula processConditionalFormula(Element e) {
        ConditionalFormula result = new ConditionalFormula(e);
        result.setArg1(processFormula(e.elements().get(0)));
        result.setArg2(processFormula(e.elements().get(1)));
        return result;
    }

    private Conditions processConditions(Element e) {
        Conditions result = new Conditions(e);
        for (Element element: e.elements())
            result.getPropositions().add(processProposition(element));
        return result;
    }

    private ConjunctiveFormula processConjunctiveFormula(Element e) {
        ConjunctiveFormula result = new ConjunctiveFormula(e);
        result.setArg1(processFormula(e.elements().get(0)));
        result.setArg2(processFormula(e.elements().get(1)));
        return result;
    }

    private Correctness processCorrectness(Element e) {
        Correctness result = new Correctness(e);
        result.setCorrectnessConditions(processCorrectnessConditions(e.element("Correctness-Conditions")));
        result.setJustification(processJustification(e.elements().get(1)));
        return result;
    }

    private CorrectnessCondition processCorrectnessCondition(Element e) {
        CorrectnessCondition result = new CorrectnessCondition(e);
        Element eCondition = e.elements().get(0);
        CorrectnessConditionInterface correctnessCondition = null;
        switch (eCondition.getName()) {
            case "coherence":
                correctnessCondition = processCoherence(eCondition);
                break;
            case "compatibility":
                correctnessCondition = processCompatibility(eCondition);
                break;
            case "existence":
                correctnessCondition = processExistence(eCondition);
                break;
            case "reducibility":
                correctnessCondition = processReducibility(eCondition);
                break;
            case "uniqueness":
                correctnessCondition = processUniqueness(eCondition);
                break;
            default:
                Errors.error(eCondition,"UNKNOWN Correctness Condition");
        }
        result.setCorrectnessCondition(correctnessCondition);
        result.setJustification(processJustification(e.elements().get(1)));
        return result;
    }

    private CorrectnessConditions processCorrectnessConditions(Element e) {
        CorrectnessConditions result = new CorrectnessConditions(e);
        for (Element element: e.elements())
            switch (element.getName()) {
                case "coherence":
                    result.getCorrectnessConditions().add(processCoherence(element));
                    break;
                case "compatibility":
                    result.getCorrectnessConditions().add(processCompatibility(element));
                    break;
                case "existence":
                    result.getCorrectnessConditions().add(processExistence(element));
                    break;
                case "reducibility":
                    result.getCorrectnessConditions().add(processReducibility(element));
                    break;
                case "uniqueness":
                    result.getCorrectnessConditions().add(processUniqueness(element));
                    break;
                default:
                    Errors.error(e,"UNKNOWN Correctness");
            }
        return result;
    }

    private Definiens processDefiniens(Element e) {
        if (e == null)
            return null;
        Definiens result = null;
        switch (e.attributeValue("shape")) {
            case "Formula-Expression":
                result = new DefiniensMeans(e);
                ((DefiniensMeans)result).setFormula(processFormula(e.elements().get(1)));
                break;
            case "Term-Expression":
                result = new DefiniensEquals(e);
                ((DefiniensEquals)result).setTerm(processTerm(e.elements().get(1)));
                break;
            default:
                Errors.error(e, "UNKNOWN Definiens");
        }
        return result;
    }

    private DefinitionItem processDefinitionItem(Element e) {
        DefinitionItem result = new DefinitionItem(e);
        return result;
    }

    private DisjunctiveFormula processDisjunctiveFormula(Element e) {
        DisjunctiveFormula result = new DisjunctiveFormula(e);
        result.setArg1(processFormula(e.elements().get(0)));
        result.setArg2(processFormula(e.elements().get(1)));
        return result;
    }

    private Existence processExistence(Element e) {
        return new Existence(e);
    }

    private ExistentialQuantifierFormula processExistentialQuantifierFormula(Element e) {
        ExistentialQuantifierFormula result = new ExistentialQuantifierFormula(e);
        result.setVariableSegments(processVariableSegments(e.element("Variable-Segments")));
        result.setScope(processScope(e.element("Scope")));
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
            case "Biconditional-Formula":
                result = processBiconditionalFormula(e);
                break;
            case "Conditional-Formula":
                result = processConditionalFormula(e);
                break;
            case "Conjunctive-Formula":
                result = processConjunctiveFormula(e);
                break;
            case "Disjunctive-Formula":
                result = processDisjunctiveFormula(e);
                break;
            case "Existential-Quantifier-Formula":
                result = processExistentialQuantifierFormula(e);
                break;
            case "Negated-Formula":
                result = processNegatedFormula(e);
                break;
            case "Qualifying-Formula":
                result = processQualifyingFormula(e);
                break;
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

    private FunctorDefinition processFunctorDefinition(Element e) {
        FunctorDefinition result = new FunctorDefinition(e);
        result.setRedefine(processRedefine(e.element("Redefine")));
        result.setPattern(processPattern(e.elements().get(1)));
        result.setTypeSpecification(processTypeSpecification(e.element("Type-Specification")));
        result.setDefiniens(processDefiniens(e.element("Definiens")));
        return result;
    }

    private ImplicitlyQualifiedSegment processImplicitlyQualifiedSegment(Element e) {
        ImplicitlyQualifiedSegment result = new ImplicitlyQualifiedSegment();
        result.setVariable(processVariable(e.element("Variable")));
        result.setType(processType(e.elements().get(1)));
        return result;
    }

    private InfixTerm processInfixTerm(Element e) {
        InfixTerm result = new InfixTerm(e);
        result.setArguments(processArguments(e.element("Arguments")));
        return result;
    }

    private ItTerm processItTerm(Element e) {
        return new ItTerm(e);
    }

    private JustificationInterface processJustification(Element e) {
        JustificationInterface result = null;
        return result;
    }

    private Label processLabel(Element e) {
        Label result = new Label(e);
        return result;
    }

    private Loci processLoci(Element e) {
        Loci result = new Loci(e);
        for (Element element: e.elements()) {
            result.getLoci().add(processLocus(element));
        }
        return result;
    }

    private LociDeclaration processLociDeclaration(Element e) {
        LociDeclaration result = new LociDeclaration(e);
        result.setQualifiedSegments(processQualifiedSegments(e.element("Qualified-Segments")));
        return result;
    }

    private Locus processLocus(Element e) {
        return new Locus(e);
    }

    private NegatedFormula processNegatedFormula(Element e) {
        NegatedFormula result = new NegatedFormula(e);
        result.setArg(processFormula(e.elements().get(0)));
        return result;
    }

    private NotionName processNotionName(Element e) {
        return new NotionName(e);
    }

    private NumeralTerm processNumeralTerm(Element e) {
        return new NumeralTerm(e);
    }

    private PatternInterface processPattern(Element e) {
        PatternInterface result = null;
        switch (e.getName()) {
            case "CircumfixFunctor-Pattern":
                result = new CircumfixFunctorPattern(e);
                ((CircumfixFunctorPattern)result).setRightCircumflexSymbol(processRightCircumflexSymbol(e.element("Right-Circumflex-Symbol")));
                ((CircumfixFunctorPattern)result).setLoci(processLoci(e.element("Loci")));
                break;
            case "InfixFunctor-Pattern":
                result = new InfixFunctorPattern(e);
                ((InfixFunctorPattern)result).setLeftLoci(processLoci(e.elements().get(0)));
                ((InfixFunctorPattern)result).setRightLoci(processLoci(e.elements().get(1)));
                break;
            default:
                Errors.error(e,"UNKNOWN Pattern");
        }
        return result;
    }

    private Pragma processPragma(Element e) {
        Pragma result = new Pragma(e);
        switch (e.elements().get(0).getName()) {
            case "Canceled":
                result.setPragma(processCanceled(e.elements().get(0)));
                break;
            case "Notion-Name":
                result.setPragma(processNotionName(e.elements().get(0)));
                break;
            case "Unknown":
                result.setPragma(processUnknown(e.elements().get(0)));
                break;
            default:
                Errors.error(e,"UNKNOWN PRAGMA");
        }
        return result;
    }

    private PredicateDefinition processPredicateDefinition(Element e) {
        PredicateDefinition result = new PredicateDefinition(e);
        result.setRedefine(processRedefine(e.element("Redefine")));
        result.setPattern(processPredicatePattern(e.elements().get(1)));
        result.setDefiniens(processDefiniens(e.element("Definiens")));
        return result;
    }

    private PredicatePattern processPredicatePattern(Element e) {
        PredicatePattern result = new PredicatePattern(e);
        result.setLeftLoci(processLoci(e.elements().get(0)));
        result.setRightLoci(processLoci(e.elements().get(1)));
        return result;
    }

    private Properties processProperties(Element e) {
        return new Properties(e);
    }

    private Property processProperty(Element e) {
        Property result = new Property(e);
        result.setProperties(processProperties(e.element("Properties")));
        result.setJustification(processJustification(e.elements().get(1)));
        return result;
    }

    private Proposition processProposition(Element e) {
        Proposition result = new Proposition();
        result.setLabel(processLabel(e.element("Label")));
        result.setFormula(processFormula(e.elements().get(1)));
        return result;
    }

    private QualifiedSegments processQualifiedSegments(Element e) {
        QualifiedSegments result = new QualifiedSegments(e);
        for (Element element : e.elements())
            result.getQualifiedSegments().add(processVariableSegment(element));
        return result;
    }

    private QualifyingFormula processQualifyingFormula(Element e) {
        QualifyingFormula result = new QualifyingFormula(e);
        result.setTerm(processTerm(e.elements().get(0)));
        result.setType(processType(e.elements().get(1)));
        return result;
    }

    private Redefine processRedefine(Element e) {
        return new Redefine(e);
    }

    private Reducibility processReducibility(Element e) {
        return new Reducibility(e);
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

    private Restriction processRestriction(Element e) {
        if (e == null)
            return null;
        Restriction result = new Restriction(e);
        result.setFormula(processFormula(e.elements().get(0)));
        return result;
    }

    private RightCircumflexSymbol processRightCircumflexSymbol(Element e) {
        return new RightCircumflexSymbol(e);
    }

    private Scope processScope(Element e) {
        Scope result = new Scope(e);
        result.setFormula(processFormula(e.elements().get(0)));
        return result;
    }

    private SectionPragma processSection(Element e) {
        SectionPragma result = new SectionPragma(e);
        return result;
    }

    private SimpleTerm processSimpleTerm(Element e) {
        return new SimpleTerm(e);
    }

    private SingleAssumption processSingleAssumption(Element e) {
        SingleAssumption result = new SingleAssumption(e);
        result.setProposition(processProposition(e.element("Proposition")));
        return result;
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
            case "Circumfix-Term":
                result = processCircumfixTerm(e);
                break;
            case "Infix-Term":
                result = processInfixTerm(e);
                break;
            case "it-Term":
                result = processItTerm(e);
                break;
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
            case "Clustered-Type":
                result = processClusteredType(e);
                break;
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

    private TypeSpecification processTypeSpecification(Element e) {
        TypeSpecification result = new TypeSpecification(e);
        if (e != null)
            result.setType(processType(e.elements().get(0)));
        return result;
    }

    private Uniqueness processUniqueness(Element e) {
        return new Uniqueness(e);
    }

    private UniversalQuantifierFormula processUniversalQuantifierFormula(Element e) {
        UniversalQuantifierFormula result = new UniversalQuantifierFormula(e);
        result.setVariableSegments(processVariableSegments(e.element("Variable-Segments")));
        result.setRestriction(processRestriction(e.element("Restriction")));
        result.setScope(processScope(e.element("Scope")));
        return result;
    }

    private Unknown processUnknown(Element e) {
        return new Unknown(e);
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

    /* BLOCKS */

    private DefinitionalBlock processDefinitionalBlock(Element e) {
        DefinitionalBlock result = new DefinitionalBlock(e);
        return result;
    }

    private Block processBlock(Element e) {
        Block result = null;
        switch (e.attributeValue("kind")) {
            case "Definitional-Block":
                result = processDefinitionalBlock(e);
                break;
            default:
                Errors.error(e,"UNKNOWN Block");
        }
        BlocksItems.lastItem().setBlock(result);
        return result;
    }

    private Item processItem(Element e) {
        Item result = null;
        switch (e.getName()) {
            case "Assumption":
                result = processAssumption(e.elements().get(0));
                break;
            case "Correctness":
                result = processCorrectness(e);
                break;
            case "Correctness-Condition":
                result = processCorrectnessCondition(e);
                break;
            case "Definition-Item":
                result = processDefinitionItem(e);
                break;
            case "Functor-Definition":
                result = processFunctorDefinition(e);
                break;
            case "Loci-Declaration":
                result = processLociDeclaration(e);
                break;
            case "Pragma":
                result = processPragma(e);
                break;
            case "Predicate-Definition":
                result = processPredicateDefinition(e);
                break;
            case "Property":
                result = processProperty(e);
                break;
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
                BlocksItems.addBlock(processBlock(e));
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
                BlocksItems.removeLastBlock();
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
