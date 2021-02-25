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

    private AttrAntonym processAttrAntonym(Element e) {
        AttrAntonym result = new AttrAntonym(e);
        result.setAntonym(processPattern(e.element("Attribute-Pattern")));
        result.setOriginal(processPatternShapedExpression(e.element("Pattern-Shaped-Expression")));
        return result;
    }

    private AttrSynonym processAttrSynonym(Element e) {
        AttrSynonym result = new AttrSynonym(e);
        result.setSynonym(processPattern(e.element("Attribute-Pattern")));
        result.setOriginal(processPatternShapedExpression(e.element("Pattern-Shaped-Expression")));
        return result;
    }

    private Attribute processAttribute(Element e) {
        Attribute result = new Attribute(e);
        result.setArguments(processArguments(e.element("Arguments")));
        return result;
    }

    private AttributeDefinition processAttributeDefinition(Element e) {
        AttributeDefinition result = new AttributeDefinition(e);
        result.setRedefine(processRedefine(e.element("Redefine")));
        result.setPattern(processPattern(e.elements().get(1)));
        result.setDefiniens(processDefiniens(e.element("Definiens")));
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

    private Cluster processCluster(Element e) {
        Cluster result = new Cluster(e);
        Element element = e.elements().get(0);
        switch (element.getName()) {
            case "Conditional-Registration":
                result.setCluster(processConditionalRegistration(element));
                break;
            case "Existential-Registration":
                result.setCluster(processExistentialRegistration(element));
                break;
            case "Functorial-Registration":
                result.setCluster(processFunctorialRegistration(element));
                break;
            default:
                Errors.error(element,"UNKNOWN Cluster Registration");
        }
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

    private ConditionalRegistration processConditionalRegistration(Element e) {
        ConditionalRegistration result = new ConditionalRegistration(e);
        result.setPredecessor(processAdjectiveCluster(e.elements().get(0)));
        result.setSuccessor(processAdjectiveCluster(e.elements().get(1)));
        result.setType(processType(e.elements().get(2)));
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

    private Consistency processConsistency(Element e) {
        return new Consistency(e);
    }

    private Contradiction processContradiction(Element e) {
        return new Contradiction(e);
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
            case "consistency":
                correctnessCondition = processConsistency(eCondition);
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
                case "consistency":
                    result.getCorrectnessConditions().add(processConsistency(element));
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
                switch (e.attributeValue("kind")) {
                    case "Simple-Definiens":
                        result = new DefiniensMeans(e);
                        ((DefiniensMeans) result).setFormula(processFormula(e.elements().get(1)));
                        break;
                    case "Conditional-Definiens":
                        result = new DefiniensComplex(e);
                        ((DefiniensComplex) result).setPartialDefiniensList(processPartialDefiniensList(e.element("Partial-Definiens-List"),"formula"));
                        ((DefiniensComplex) result).setOtherwise(processOtherwise(e.element("Otherwise"),"formula"));
                        break;
                    default:
                        Errors.error(e,"UNKNOWN Definiens Kind");
                }
                break;
            case "Term-Expression":
                switch (e.attributeValue("kind")) {
                    case "Simple-Definiens":
                        result = new DefiniensEquals(e);
                        ((DefiniensEquals) result).setTerm(processTerm(e.elements().get(1)));
                        break;
                    case "Conditional-Definiens":
                        result = new DefiniensComplex(e);
                        ((DefiniensComplex) result).setPartialDefiniensList(processPartialDefiniensList(e.element("Partial-Definiens-List"),"term"));
                        ((DefiniensComplex) result).setOtherwise(processOtherwise(e.element("Otherwise"),"term"));
                        break;
                    default:
                        Errors.error(e,"UNKNOWN Definiens Kind");
                }
                break;
            default:
                Errors.error(e, "UNKNOWN Definiens Shape");
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

    private ExistentialAssumption processExistentialAssumption(Element e) {
        ExistentialAssumption result = new ExistentialAssumption(e);
        result.setQualifiedSegments(processQualifiedSegments(e.element("Qualified-Segments")));
        result.setConditions(processConditions(e.element("Conditions")));
        return result;
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

    private ExistentialRegistration processExistentialRegistration(Element e) {
        ExistentialRegistration result = new ExistentialRegistration(e);
        result.setAdjectiveCluster(processAdjectiveCluster(e.elements().get(0)));
        result.setType(processType(e.elements().get(1)));
        return result;
    }

    private ExpandableMode processExpandableMode(Element e) {
        ExpandableMode result = new ExpandableMode(e);
        result.setType(processType(e.elements().get(0)));
        return result;
    }

    private FlexaryConjunctiveFormula processFlexaryConjunctiveFormula(Element e) {
        FlexaryConjunctiveFormula result = new FlexaryConjunctiveFormula(e);
        result.setArg1(processFormula(e.elements().get(0)));
        result.setArg2(processFormula(e.elements().get(1)));
        return result;
    }

    private FlexaryDisjunctiveFormula processFlexaryDisjunctiveFormula(Element e) {
        FlexaryDisjunctiveFormula result = new FlexaryDisjunctiveFormula(e);
        result.setArg1(processFormula(e.elements().get(0)));
        result.setArg2(processFormula(e.elements().get(1)));
        return result;
    }

    private ForgetfulFunctorTerm processForgetfulFunctorTerm(Element e) {
        ForgetfulFunctorTerm result = new ForgetfulFunctorTerm(e);
        result.setTerm(processTerm(e.elements().get(0)));
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
            case "Contradiction":
                result = processContradiction(e);
                break;
            case "Disjunctive-Formula":
                result = processDisjunctiveFormula(e);
                break;
            case "Existential-Quantifier-Formula":
                result = processExistentialQuantifierFormula(e);
                break;
            case "FlexaryConjunctive-Formula":
                result = processFlexaryConjunctiveFormula(e);
                break;
            case "FlexaryDisjunctive-Formula":
                result = processFlexaryDisjunctiveFormula(e);
                break;
            case "Multi-Attributive-Formula":
                result = processMultiAttributiveFormula(e);
                break;
            case "Multi-Relation-Formula":
                result = processMultiRelationFormula(e);
                break;
            case "Negated-Formula":
                result = processNegatedFormula(e);
                break;
            case "Private-Predicate-Formula":
                result = processPrivatePredicateFormula(e);
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
                Errors.error(e, "UNKNOWN FORMULA");
        }
        return result;
    }

    private FraenkelTerm processFraenkelTerm(Element e) {
        FraenkelTerm result = new FraenkelTerm(e);
        result.setVariableSegments(processVariableSegments(e.elements().get(0)));
        result.setTerm(processTerm(e.elements().get(1)));
        result.setFormula(processFormula(e.elements().get(2)));
        return result;
    }

    private FreeVariableSegment processFreeVariableSegment(Element e) {
        FreeVariableSegment result = new FreeVariableSegment();
        result.setVariable(processVariable(e.element("Variable")));
        result.setType(processType(e.elements().get(1)));
        return result;
    }

    private FuncSynonym processFuncSynonym(Element e) {
        FuncSynonym result = new FuncSynonym(e);
        result.setSynonym(processPattern(e.elements().get(0)));
        result.setOriginal(processPatternShapedExpression(e.element("Pattern-Shaped-Expression")));
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

    private FunctorialRegistration processFunctorialRegistration(Element e) {
        FunctorialRegistration result = new FunctorialRegistration(e);
        result.setTerm(processTerm(e.elements().get(0)));
        result.setAdjectiveCluster(processAdjectiveCluster(e.elements().get(1)));
        if (e.elements().size() > 2)
           result.setType(processType(e.elements().get(2)));
        return result;
    }

    private GlobalChoiceTerm processGlobalChoiceTerm(Element e) {
        GlobalChoiceTerm result = new GlobalChoiceTerm(e);
        result.setType(processType(e.elements().get(0)));
        return result;
    }

    private Identify processIdentify(Element e) {
        Identify result = new Identify(e);
        result.setLeftPatternShapedExpression(processPatternShapedExpression(e.elements().get(1)));
        result.setRightPatternShapedExpression(processPatternShapedExpression(e.elements().get(0)));
        result.setLociEqualities(processLociEqualities(e.element("Loci-Equalities")));
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

    private InternalSelectorTerm processInternalSelectorTerm(Element e) {
        return new InternalSelectorTerm(e);
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

    private LociEqualities processLociEqualities(Element e) {
        LociEqualities result = new LociEqualities(e);
        for (Element element: e.elements())
            result.getLociEqualities().add(processLociEquality(element));
        return result;
    }

    private LociEquality processLociEquality(Element e) {
        LociEquality result = new LociEquality(e);
        result.setLocus_1(processLocus(e.elements().get(0)));
        result.setLocus_2(processLocus(e.elements().get(1)));
        return result;
    }

    private Locus processLocus(Element e) {
        return new Locus(e);
    }

    private ModeDefinition processModeDefinition(Element e) {
        ModeDefinition result = new ModeDefinition(e);
        result.setRedefine(processRedefine(e.element("Redefine")));
        result.setPattern(processPattern(e.elements().get(1)));
        result.setModeDescription(processModeDescription(e.elements().get(2)));
        return result;
    }

    private ModeDescriptionInterface processModeDescription(Element e) {
        ModeDescriptionInterface result = null;
        switch (e.getName()) {
            case "Standard-Mode":
                result = processStandardMode(e);
                break;
            case "Expandable-Mode":
                result = processExpandableMode(e);
                break;
            default:
                Errors.error(e,"UNKNOWN Mode Kind");
        }
        return result;
    }

    private ModeSynonym processModeSynonym(Element e) {
        ModeSynonym result = new ModeSynonym(e);
        result.setSynonym(processPattern(e.element("Mode-Pattern")));
        result.setOriginal(processPatternShapedExpression(e.element("Pattern-Shaped-Expression")));
        return result;
    }

    private MultiAttributiveFormula processMultiAttributiveFormula(Element e) {
        MultiAttributiveFormula result = new MultiAttributiveFormula(e);
        result.setSubject(processTerm(e.elements().get(0)));
        result.setAdjectiveCluster(processAdjectiveCluster(e.element("Adjective-Cluster")));
        return result;
    }

    private MultiRelationFormula processMultiRelationFormula(Element e) {
        MultiRelationFormula result = new MultiRelationFormula(e);
        result.setFormula(processFormula(e.elements().get(0)));
        for (int i = 1; i < e.elements().size(); i++)
            result.getRightFormulas().add(processRightSideOfRelationFormula(e.elements().get(i)));
        return result;
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

    private Otherwise processOtherwise(Element e, String shape) {
        Otherwise result = null;
        switch (shape) {
            case "formula":
                result = new OtherwiseMeans(e);
                if (e.elements().size() > 0)
                    ((OtherwiseMeans)result).setFormula(processFormula(e.elements().get(0)));
                break;
            case "term":
                result = new OtherwiseEquals(e);
                if (e.elements().size() > 0)
                    ((OtherwiseEquals)result).setTerm(processTerm(e.elements().get(0)));
                break;
        }
        return result;
    }

    private PartialDefiniensEquals processPartialDefiniensEquals(Element e) {
        PartialDefiniensEquals result = new PartialDefiniensEquals(e);
        result.setTerm(processTerm(e.elements().get(0)));
        result.setGuard(processFormula(e.elements().get(1)));
        return result;
    }

    private PartialDefiniensMeans processPartialDefiniensMeans(Element e) {
        PartialDefiniensMeans result = new PartialDefiniensMeans(e);
        result.setFormula(processFormula(e.elements().get(0)));
        result.setGuard(processFormula(e.elements().get(1)));
        return result;
    }

    private PartialDefiniensList processPartialDefiniensList(Element e, String shape) {
        PartialDefiniensList result = new PartialDefiniensList(e);
        for (Element element: e.elements()) {
            switch (shape) {
                case "formula":
                    result.getPartialDefiniens().add(processPartialDefiniensMeans(element));
                    break;
                case "term":
                    result.getPartialDefiniens().add(processPartialDefiniensEquals(element));
                    break;
            }
        }
        return result;
    }

    private PatternInterface processPattern(Element e) {
        PatternInterface result = null;
        switch (e.getName()) {
            case "Attribute-Pattern":
                result = new AttributePattern(e);
                ((AttributePattern)result).setSubject(processLocus(e.elements().get(0)));
                ((AttributePattern)result).setArguments(processLoci(e.elements().get(1)));
                break;
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
            case "Mode-Pattern":
                result = new ModePattern(e);
                ((ModePattern)result).setLoci(processLoci(e.element("Loci")));
                break;
            case "Predicate-Pattern":
                result = new PredicatePattern(e);
                ((PredicatePattern)result).setLeftLoci(processLoci(e.elements().get(0)));
                ((PredicatePattern)result).setRightLoci(processLoci(e.elements().get(1)));
                break;
            case "Structure-Pattern":
                result = new StructurePattern(e);
                ((StructurePattern)result).setLoci(processLoci(e.element("Loci")));
                break;
            default:
                Errors.error(e,"UNKNOWN Pattern");
        }
        return result;
    }

    private PatternShapedExpression processPatternShapedExpression(Element e) {
        PatternShapedExpression result = new PatternShapedExpression(e);
        result.setPattern(processPattern(e.elements().get(0)));
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

    private PredAntonym processPredAntonym(Element e) {
        PredAntonym result = new PredAntonym(e);
        result.setAntonym(processPattern(e.element("Predicate-Pattern")));
        result.setOriginal(processPatternShapedExpression(e.element("Pattern-Shaped-Expression")));
        return result;
    }

    private PredSynonym processPredSynonym(Element e) {
        PredSynonym result = new PredSynonym(e);
        result.setSynonym(processPattern(e.element("Predicate-Pattern")));
        result.setOriginal(processPatternShapedExpression(e.element("Pattern-Shaped-Expression")));
        return result;
    }

    private PredicateDefinition processPredicateDefinition(Element e) {
        PredicateDefinition result = new PredicateDefinition(e);
        result.setRedefine(processRedefine(e.element("Redefine")));
        result.setPattern(processPattern(e.elements().get(1)));
        result.setDefiniens(processDefiniens(e.element("Definiens")));
        return result;
    }

    private PrivateFunctorTerm processPrivateFunctorTerm(Element e) {
        PrivateFunctorTerm result = new PrivateFunctorTerm(e);
        result.setArguments(processArguments(e.element("Arguments")));
        return result;
    }

    private PrivatePredicateFormula processPrivatePredicateFormula(Element e) {
        PrivatePredicateFormula result = new PrivatePredicateFormula(e);
        result.setArguments(processArguments(e.element("Arguments")));
        return result;
    }

    private Properties processProperties(Element e) {
        Properties result = new Properties(e);
        if (e.elements().size() > 0)
            result.setType(processType(e.elements().get(0)));
        return result;
    }

    private Property processProperty(Element e) {
        Property result = new Property(e);
        result.setProperties(processProperties(e.element("Properties")));
        result.setJustification(processJustification(e.elements().get(1)));
        return result;
    }

    private PropertyRegistration processPropertyRegistration(Element e) {
        PropertyRegistration result = new PropertyRegistration(e);
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

    private QualificationTerm processQualificationTerm(Element e) {
        QualificationTerm result = new QualificationTerm(e);
        result.setTerm(processTerm(e.elements().get(0)));
        result.setType(processType(e.elements().get(1)));
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

    private Reduction processReduction(Element e) {
        Reduction result = new Reduction(e);
        result.setLeftTerm(processTerm(e.elements().get(0)));
        result.setRightTerm(processTerm(e.elements().get(1)));
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

    private RightSideOfRelationFormula processRightSideOfRelationFormula(Element e) {
        RightSideOfRelationFormula result = new RightSideOfRelationFormula(e);
        result.setArguments(processArguments(e.element("Arguments")));
        return result;
    }

    private SectionPragma processSection(Element e) {
        SectionPragma result = new SectionPragma(e);
        return result;
    }

    private SimpleFraenkelTerm processSimpleFraenkelTerm(Element e) {
        SimpleFraenkelTerm result = new SimpleFraenkelTerm(e);
        result.setVariableSegments(processVariableSegments(e.elements().get(0)));
        result.setTerm(processTerm(e.elements().get(1)));
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

    private StandardMode processStandardMode(Element e) {
        StandardMode result = new StandardMode(e);
        result.setTypeSpecification(processTypeSpecification(e.element("Type-Specification")));
        result.setDefiniens(processDefiniens(e.element("Definiens")));
        return result;
    }

    private StandardType processStandardType(Element e) {
        StandardType result = new StandardType(e);
        result.setArguments(processArguments(e.element("Arguments")));
        return result;
    }

    private StructType processStructType(Element e) {
        StructType result = new StructType(e);
        result.setArguments(processArguments(e.element("Arguments")));
        return result;
    }

    private Substitutions processSubstitutions(Element e) {
        Substitutions result = new Substitutions();
        // TODO
        return result;
    }

    private TermInterface processTerm(Element e) {
        TermInterface result = null;
        switch (e.getName()) {
            case "Aggregate-Term":
                result = processAggregateTerm(e);
                break;
            case "Circumfix-Term":
                result = processCircumfixTerm(e);
                break;
            case "Forgetful-Functor-Term":
                result = processForgetfulFunctorTerm(e);
                break;
            case "Fraenkel-Term":
                result = processFraenkelTerm(e);
                break;
            case "Global-Choice-Term":
                result = processGlobalChoiceTerm(e);
                break;
            case "Infix-Term":
                result = processInfixTerm(e);
                break;
            case "Internal-Selector-Term":
                result = processInternalSelectorTerm(e);
                break;
            case "it-Term":
                result = processItTerm(e);
                break;
            case "Numeral-Term":
                result = processNumeralTerm(e);
                break;
            case "Private-Functor-Term":
                result = processPrivateFunctorTerm(e);
                break;
            case "Qualification-Term":
                result = processQualificationTerm(e);
                break;
            case "Selector-Term":
                result = processSelectorTerm(e);
                break;
            case "Simple-Fraenkel-Term":
                result = processSimpleFraenkelTerm(e);
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
            case "Struct-Type":
                result = processStructType(e);
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

    /* SCHEMES */

    private SchemeBlockItem processSchemeBlockItem(Element e) {
        SchemeBlockItem result = new SchemeBlockItem(e);
        return result;
    }

    private Scheme processScheme(Element e) {
        return new Scheme(e);
    }

    private SchematicVariables processSchematicVariables(Element e) {
        SchematicVariables result = new SchematicVariables(e);
        for (Element element: e.elements())
            result.getSegments().add(processSchemeInputSegment(element));
        return result;
    }

    private SchemeHead processSchemeHead(Element e) {
        SchemeHead result = new SchemeHead(e);
        result.setScheme(processScheme(e.element("Scheme")));
        result.setSchematicVariables(processSchematicVariables(e.element("Schematic-Variables")));
        result.setFormula(processFormula(e.elements().get(2)));
        result.setProvisionalFormulas(processProvisionalFormulas(e.element("Provisional-Formulas")));
        return result;
    }

    private SchemaInputSegment processSchemeInputSegment(Element e) {
        SchemaInputSegment result = null;
        switch (e.getName()) {
            case "Functor-Segment":
                result = processFunctorSegment(e);
                break;
            case "Predicate-Segment":
                result = processPredicateSegment(e);
                break;
            default:
                Errors.error(e,"UNKNOWN Segment");
        }
        return result;
    }

    private FunctorSegment processFunctorSegment(Element e) {
        FunctorSegment result = new FunctorSegment(e);
        result.setVariables(processVariables(e.element("Variables")));
        result.setArgumentTypes(processTypeList(e.element("Type-List")));
        result.setResultType(processTypeSpecification(e.element("Type-Specification")));
        return result;
    }

    private PredicateSegment processPredicateSegment(Element e) {
        PredicateSegment result = new PredicateSegment(e);
        result.setVariables(processVariables(e.element("Variables")));
        result.setArgumentTypes(processTypeList(e.element("Type-List")));
        return result;
    }

    private TypeList processTypeList(Element e) {
        TypeList result = new TypeList(e);
        for (Element element: e.elements())
            result.getTypes().add(processType(element));
        return result;
    }

    private ProvisionalFormulas processProvisionalFormulas(Element e) {
        if (e == null)
            return null;
        ProvisionalFormulas result = new ProvisionalFormulas(e);
        for (Element element: e.elements())
            result.getProvisionals().add(processProposition(element));
        return result;
    }

    /* STRUCTURES */

    private StructureDefinition processStructureDefinition(Element e) {
        StructureDefinition result = new StructureDefinition(e);
        result.setAncestors(processAncestors(e.element("Ancestors")));
        result.setPattern(processPattern(e.element("Structure-Pattern")));
        result.setFieldSegments(processFieldSegments(e.element("Field-Segments")));
        result.setStructurePatternsRendering(processStructurePatternsRendering(e.element("Structure-Patterns-Rendering")));
        return result;
    }

    private Ancestors processAncestors(Element e) {
        Ancestors result = new Ancestors(e);
        for (Element element: e.elements())
            result.getAncestors().add(processType(element));
        return result;
    }

    private AggregateTerm processAggregateTerm(Element e) {
        AggregateTerm result = new AggregateTerm(e);
        result.setArguments(processArguments(e.element("Arguments")));
        return result;
    }

    private FieldSegment processFieldSegment(Element e) {
        FieldSegment result = new FieldSegment(e);
        result.setSelectors(processSelectors(e.element("Selectors")));
        result.setType(processType(e.elements().get(1)));
        return result;
    }

    private FieldSegments processFieldSegments(Element e) {
        FieldSegments result = new FieldSegments(e);
        for (Element element: e.elements())
            result.getFieldSegments().add(processFieldSegment(element));
        return result;
    }

    private SelectorTerm processSelectorTerm(Element e) {
        SelectorTerm result = new SelectorTerm(e);
        result.setArgument(processTerm(e.elements().get(0)));
        return result;
    }

    private Selector processSelector(Element e) {
        Selector result = new Selector(e);
        result.setLocus(processLocus(e.element("Locus")));
        return result;
    }

    private Selectors processSelectors(Element e) {
        Selectors result = new Selectors(e);
        for (Element element: e.elements())
            result.getSelectors().add(processSelector(element));
        return result;
    }

    private StructurePatternsRendering processStructurePatternsRendering(Element e) {
        StructurePatternsRendering result = new StructurePatternsRendering(e);
        result.setAggregateFunctorPattern(processAggregateFunctorPattern(e.element("AggregateFunctor-Pattern")));
        result.setForgetfulFunctorPattern(processForgetfulFunctorPattern(e.element("ForgetfulFunctor-Pattern")));
        result.setStrictPattern(processStrictPattern(e.element("Strict-Pattern")));
        result.setSelectorsList(processSelectorsList(e.element("Selectors-List")));
        return result;
    }

    private AggregateFunctorPattern processAggregateFunctorPattern(Element e) {
        AggregateFunctorPattern result = new AggregateFunctorPattern(e);
        result.setLoci(processLoci(e.element("Loci")));
        return result;
    }

    private ForgetfulFunctorPattern processForgetfulFunctorPattern(Element e) {
        ForgetfulFunctorPattern result = new ForgetfulFunctorPattern(e);
        result.setLoci(processLoci(e.element("Loci")));
        return result;
    }

    private StrictPattern processStrictPattern(Element e) {
        StrictPattern result = new StrictPattern(e);
        result.setLocus(processLocus(e.element("Locus")));
        result.setLoci(processLoci(e.element("Loci")));
        return result;
    }

    private SelectorFunctorPattern processSelectorFunctorPattern(Element e) {
        SelectorFunctorPattern result = new SelectorFunctorPattern(e);
        result.setLoci(processLoci(e.element("Loci")));
        return result;
    }

    private SelectorsList processSelectorsList(Element e) {
        SelectorsList result = new SelectorsList(e);
        for (Element element: e.elements())
            result.getSelectorFunctorPatterns().add(processSelectorFunctorPattern(element));
        return result;
    }

    /* BLOCKS */

    private DefinitionalBlock processDefinitionalBlock(Element e) {
        DefinitionalBlock result = new DefinitionalBlock(e);
        return result;
    }

    private NotationBlock processNotationBlock(Element e) {
        NotationBlock result = new NotationBlock(e);
        return result;
    }

    private RegistrationBlock processRegistrationBlock(Element e) {
        RegistrationBlock result = new RegistrationBlock(e);
        return result;
    }

    private SchemeBlock processSchemeBlock(Element e) {
        SchemeBlock result = new SchemeBlock(e);
        return result;
    }

    private Block processBlock(Element e) {
        Block result = null;
        switch (e.attributeValue("kind")) {
            case "Definitional-Block":
                result = processDefinitionalBlock(e);
                break;
            case "Notation-Block":
                result = processNotationBlock(e);
                break;
            case "Registration-Block":
                result = processRegistrationBlock(e);
                break;
            case "Scheme-Block":
                result = processSchemeBlock(e);
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
            case "Attr-Antonym":
                result = processAttrAntonym(e);
                break;
            case "Attr-Synonym":
                result = processAttrSynonym(e);
                break;
            case "Attribute-Definition":
                result = processAttributeDefinition(e);
                break;
            case "Cluster":
                result = processCluster(e);
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
            case "Existential-Assumption":
                result = processExistentialAssumption(e);
                break;
            case "Func-Synonym":
                result = processFuncSynonym(e);
                break;
            case "Functor-Definition":
                result = processFunctorDefinition(e);
                break;
            case "Identify":
                result = processIdentify(e);
                break;
            case "Mode-Definition":
                result = processModeDefinition(e);
                break;
            case "Mode-Synonym":
                result = processModeSynonym(e);
                break;
            case "Loci-Declaration":
                result = processLociDeclaration(e);
                break;
            case "Pragma":
                result = processPragma(e);
                break;
            case "Pred-Antonym":
                result = processPredAntonym(e);
                break;
            case "Scheme-Head":
                result = processSchemeHead(e);
                break;
            case "Pred-Synonym":
                result = processPredSynonym(e);
                break;
            case "Predicate-Definition":
                result = processPredicateDefinition(e);
                break;
            case "Property":
                result = processProperty(e);
                break;
            case "Property-Registration":
                result = processPropertyRegistration(e);
                break;
            case "Reduction":
                result = processReduction(e);
                break;
            case "Reservation":
                result = processReservation(e);
                break;
            case "Scheme-Block-Item":
                result = processSchemeBlockItem(e);
                break;
            case "Section-Pragma":
                result = processSection(e);
                break;
            case "Structure-Definition":
                result = processStructureDefinition(e);
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
