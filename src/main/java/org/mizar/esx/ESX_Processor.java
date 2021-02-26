package org.mizar.esx;

import lombok.*;
import org.dom4j.*;
import org.mizar.esx.actions.Actions;
import org.mizar.esx.article.*;
import org.mizar.esx.article.Attribute;
import org.mizar.esx.xml.XMLApplication;
import org.mizar.esx.errors.*;

@Setter
@Getter

public class ESX_Processor extends XMLApplication {

    private TextProper textProper;

    public Actions actions;

    public ESX_Processor(String pathName, String fileName, String fileExtension) {
        super(pathName, fileName, fileExtension);
        this.actions = new Actions() {};
    }

    public ESX_Processor(String pathName, String fileName, String fileExtension, Actions actions) {
        super(pathName, fileName, fileExtension);
        this.actions = actions;
    }

    private AdjectiveCluster processAdjectiveCluster(Element e) {
        AdjectiveCluster result = new AdjectiveCluster(e);

        actions.actionAdjectiveClusterBeforeAttributes(result);
        for (Element element: e.elements())
           result.getAttributes().add(processAttribute(element));
        actions.actionAdjectiveClusterAfterAttributes(result);

        return result;
    }

    private Arguments processArguments(Element e) {
        Arguments result = new Arguments();

        actions.actionArgumentsBeforeArguments(result);
        for (Element element : e.elements())
            result.getArguments().add(processTerm(element));
        actions.actionArgumentsAfterArguments(result);

        return result;
    }

    private Assumption processAssumption(Element e) {
        Assumption result = new Assumption(e);
        actions.actionAssumptionBeforeAssumption(result);
        switch (e.getName()) {
            case "Collective-Assumption":
                actions.actionAssumptionBeforeCollectiveAssumption(result);
                result.setAssumption(processCollectiveAssumption(e));
                actions.actionAssumptionAfterCollectiveAssumption(result);
                break;
            case "Single-Assumption":
                actions.actionAssumptionBeforeSingleAssumption(result);
                result.setAssumption(processSingleAssumption(e));
                actions.actionAssumptionAfterSingleAssumption(result);
                break;
            default:
                Errors.error(e,"UNKNOWN Assumption");
        }
        actions.actionAssumptionAfterAssumption(result);
        return result;
    }

    private AttrAntonym processAttrAntonym(Element e) {
        AttrAntonym result = new AttrAntonym(e);

        actions.actionAttrAntonymBeforePattern(result);
        result.setAntonym(processPattern(e.element("Attribute-Pattern")));
        actions.actionAttrAntonymAfterPattern(result);

        actions.actionAttrAntonymBeforeOriginal(result);
        result.setOriginal(processPatternShapedExpression(e.element("Pattern-Shaped-Expression")));
        actions.actionAttrAntonymAfterOriginal(result);

        return result;
    }

    private AttrSynonym processAttrSynonym(Element e) {
        AttrSynonym result = new AttrSynonym(e);

        actions.actionAttrSynonymBeforeSynonym(result);
        result.setSynonym(processPattern(e.element("Attribute-Pattern")));
        actions.actionAttrSynonymAfterSynonym(result);

        actions.actionAttrSynonymBeforeOriginal(result);
        result.setOriginal(processPatternShapedExpression(e.element("Pattern-Shaped-Expression")));
        actions.actionAttrSynonymAfterOriginal(result);

        return result;
    }

    private Attribute processAttribute(Element e) {
        Attribute result = new Attribute(e);

        actions.actionAttributeBeforeArguments(result);
        result.setArguments(processArguments(e.element("Arguments")));
        actions.actionAttributeAfterArguments(result);

        return result;
    }

    private AttributeDefinition processAttributeDefinition(Element e) {
        AttributeDefinition result = new AttributeDefinition(e);

        actions.actionAttributeDefinitionBeforeRedefine(result);
        result.setRedefine(processRedefine(e.element("Redefine")));
        actions.actionAttributeDefinitionAfterRedefine(result);

        actions.actionAttributeDefinitionBeforePattern(result);
        result.setPattern(processPattern(e.elements().get(1)));
        actions.actionAttributeDefinitionAfterPattern(result);

        actions.actionAttributeDefinitionBeforeDefiniens(result);
        result.setDefiniens(processDefiniens(e.element("Definiens")));
        actions.actionAttributeDefinitionAfterDefiniens(result);

        return result;
    }

    private BiconditionalFormula processBiconditionalFormula(Element e) {
        BiconditionalFormula result = new BiconditionalFormula(e);

        actions.actionBiconditionalFormulaBeforeArg1(result);
        result.setArg1(processFormula(e.elements().get(0)));
        actions.actionBiconditionalFormulaAfterArg1(result);

        actions.actionBiconditionalFormulaBeforeArg2(result);
        result.setArg2(processFormula(e.elements().get(1)));
        actions.actionBiconditionalFormulaAfterArg2(result);

        return result;
    }

    private BinaryFormula processBinaryFormula(Element e) {
        BinaryFormula result = new BinaryFormula(e);

        actions.actionBinaryFormulaBeforeArg1(result);
        result.setArg1(processFormula(e.elements().get(0)));
        actions.actionBinaryFormulaAfterArg1(result);

        actions.actionBinaryFormulaBeforeArg2(result);
        result.setArg2(processFormula(e.elements().get(1)));
        actions.actionBinaryFormulaAfterArg2(result);

        return result;
    }

    private Canceled processCanceled(Element e) {
        Canceled result = new Canceled(e);
        actions.actionCanceled(result);
        return result;
    }

    private CircumfixTerm processCircumfixTerm(Element e) {
        CircumfixTerm result = new CircumfixTerm(e);

        actions.actionCircumfixTermBeforeRightCircumflexSymbol(result);
        result.setRightCircumflexSymbol(processRightCircumflexSymbol(e.element("Right-Circumflex-Symbol")));
        actions.actionCircumfixTermAfterRightCircumflexSymbol(result);

        actions.actionCircumfixTermBeforeArguments(result);
        result.setArguments(processArguments(e.element("Arguments")));
        actions.actionCircumfixTermAfterArguments(result);

        return result;
    }

    private Cluster processCluster(Element e) {
        Cluster result = new Cluster(e);
        Element element = e.elements().get(0);
        actions.actionClusterBeforeCluster(result);
        switch (element.getName()) {
            case "Conditional-Registration":
                actions.actionClusterBeforeConditionalRegistration(result);
                result.setCluster(processConditionalRegistration(element));
                actions.actionClusterAfterConditionalRegistration(result);
                break;
            case "Existential-Registration":
                actions.actionClusterBeforeExistentialRegistration(result);
                result.setCluster(processExistentialRegistration(element));
                actions.actionClusterAfterExistentialRegistration(result);
                break;
            case "Functorial-Registration":
                actions.actionClusterBeforeFunctorialRegistration(result);
                result.setCluster(processFunctorialRegistration(element));
                actions.actionClusterAfterFunctorialRegistration(result);
                break;
            default:
                Errors.error(element,"UNKNOWN Cluster Registration");
        }
        actions.actionClusterAfterCluster(result);
        return result;
    }

    private ClusteredType processClusteredType(Element e) {
        ClusteredType result = new ClusteredType(e);

        actions.actionClusteredTypeBeforeAdjectiveCluster(result);
        result.setAdjectiveCluster(processAdjectiveCluster(e.element("Adjective-Cluster")));
        actions.actionClusteredTypeAfterAdjectiveCluster(result);

        actions.actionClusteredTypeBeforeType(result);
        result.setType(processType(e.elements().get(1)));
        actions.actionClusteredTypeAfterType(result);

        return result;
    }

    private Coherence processCoherence(Element e) {
        Coherence result = new Coherence(e);
        actions.actionCoherence(result);
        return result;
    }

    private CollectiveAssumption processCollectiveAssumption(Element e) {
        CollectiveAssumption result = new CollectiveAssumption(e);

        actions.actionCollectiveAssumptionBeforeConditions(result);
        result.setConditions(processConditions(e.element("Conditions")));
        actions.actionCollectiveAssumptionAfterConditions(result);

        return result;
    }

    private Compatibility processCompatibility(Element e) {
        Compatibility result = new Compatibility(e);
        actions.actionCompatibility(result);
        return result;
    }

    private ConditionalFormula processConditionalFormula(Element e) {
        ConditionalFormula result = new ConditionalFormula(e);

        actions.actionConditionalFormulaBeforeArg1(result);
        result.setArg1(processFormula(e.elements().get(0)));
        actions.actionConditionalFormulaAfterArg1(result);

        actions.actionConditionalFormulaBeforeArg2(result);
        result.setArg2(processFormula(e.elements().get(1)));
        actions.actionConditionalFormulaAfterArg2(result);

        return result;
    }

    private ConditionalRegistration processConditionalRegistration(Element e) {
        ConditionalRegistration result = new ConditionalRegistration(e);

        actions.actionConditionalRegistrationBeforePredecessor(result);
        result.setPredecessor(processAdjectiveCluster(e.elements().get(0)));
        actions.actionConditionalRegistrationAfterPredecessor(result);

        actions.actionConditionalRegistrationBeforeSuccessor(result);
        result.setSuccessor(processAdjectiveCluster(e.elements().get(1)));
        actions.actionConditionalRegistrationAfterSuccessor(result);

        actions.actionConditionalRegistrationBeforeType(result);
        result.setType(processType(e.elements().get(2)));
        actions.actionConditionalRegistrationAfterType(result);

        return result;
    }

    private Conditions processConditions(Element e) {
        Conditions result = new Conditions(e);

        actions.actionConditionsBeforePropositions(result);
        for (Element element: e.elements())
            result.getPropositions().add(processProposition(element));
        actions.actionConditionsAfterPropositions(result);

        return result;
    }

    private ConjunctiveFormula processConjunctiveFormula(Element e) {
        ConjunctiveFormula result = new ConjunctiveFormula(e);

        actions.actionConjunctiveFormulaBeforeArg1(result);
        result.setArg1(processFormula(e.elements().get(0)));
        actions.actionConjunctiveFormulaAfterArg1(result);

        actions.actionConjunctiveFormulaBeforeArg2(result);
        result.setArg2(processFormula(e.elements().get(1)));
        actions.actionConjunctiveFormulaAfterArg2(result);

        return result;
    }

    private Consistency processConsistency(Element e) {
        Consistency result = new Consistency(e);
        actions.actionConsistency(result);
        return result;
    }

    private Contradiction processContradiction(Element e) {
        Contradiction result = new Contradiction(e);
        actions.actionContradiction(result);
        return result;
    }

    private Correctness processCorrectness(Element e) {
        Correctness result = new Correctness(e);

        actions.actionCorrectnessBeforeCorrectnessConditions(result);
        result.setCorrectnessConditions(processCorrectnessConditions(e.element("Correctness-Conditions")));
        actions.actionCorrectnessAfterCorrectnessConditions(result);

        actions.actionCorrectnessBeforeJustification(result);
        result.setJustification(processJustification(e.elements().get(1)));
        actions.actionCorrectnessAfterJustification(result);

        return result;
    }

    private CorrectnessCondition processCorrectnessCondition(Element e) {
        CorrectnessCondition result = new CorrectnessCondition(e);
        Element eCondition = e.elements().get(0);
        CorrectnessConditionInterface correctnessCondition = null;
        actions.actionCorrectnessConditionBeforeCorrectnessCondition(result);
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
        actions.actionCorrectnessConditionAfterCorrectnessCondition(result);

        actions.actionCorrectnessConditionBeforeJustification(result);
        result.setJustification(processJustification(e.elements().get(1)));
        actions.actionCorrectnessConditionAfterJustification(result);

        return result;
    }

    private CorrectnessConditions processCorrectnessConditions(Element e) {
        CorrectnessConditions result = new CorrectnessConditions(e);
        actions.actionCorrectnessConditionsBeforeCorrectnessConditions(result);
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
        actions.actionCorrectnessConditionsAfterCorrectnessConditions(result);
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
                        actions.actionDefiniensMeansBeforeFormula((DefiniensMeans)result);
                        ((DefiniensMeans) result).setFormula(processFormula(e.elements().get(1)));
                        actions.actionDefiniensMeansAfterFormula((DefiniensMeans)result);
                        break;
                    case "Conditional-Definiens":
                        result = new DefiniensComplex(e);
                        actions.actionDefiniensMeansBeforePartialDefiniensList((DefiniensComplex)result);
                        ((DefiniensComplex) result).setPartialDefiniensList(processPartialDefiniensList(e.element("Partial-Definiens-List"),"formula"));
                        actions.actionDefiniensMeansAfterPartialDefiniensList((DefiniensComplex)result);
                        actions.actionDefiniensMeansBeforeOtherwise((DefiniensComplex)result);
                        ((DefiniensComplex) result).setOtherwise(processOtherwise(e.element("Otherwise"),"formula"));
                        actions.actionDefiniensMeansAfterOtherwise((DefiniensComplex)result);
                        break;
                    default:
                        Errors.error(e,"UNKNOWN Definiens Kind");
                }
                break;
            case "Term-Expression":
                switch (e.attributeValue("kind")) {
                    case "Simple-Definiens":
                        result = new DefiniensEquals(e);
                        actions.actionDefiniensEqualsBeforeTerm((DefiniensEquals)result);
                        ((DefiniensEquals) result).setTerm(processTerm(e.elements().get(1)));
                        actions.actionDefiniensEqualsAfterTerm((DefiniensEquals)result);
                        break;
                    case "Conditional-Definiens":
                        result = new DefiniensComplex(e);
                        actions.actionDefiniensEqualsBeforePartialDefiniensList((DefiniensComplex)result);
                        ((DefiniensComplex) result).setPartialDefiniensList(processPartialDefiniensList(e.element("Partial-Definiens-List"),"term"));
                        actions.actionDefiniensEqualsAfterPartialDefiniensList((DefiniensComplex)result);
                        actions.actionDefiniensEqualsBeforeOtherwise((DefiniensComplex)result);
                        ((DefiniensComplex) result).setOtherwise(processOtherwise(e.element("Otherwise"),"term"));
                        actions.actionDefiniensEqualsAfterOtherwise((DefiniensComplex)result);
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
        actions.actionDefinitionItem(result);
        return result;
    }

    private DisjunctiveFormula processDisjunctiveFormula(Element e) {
        DisjunctiveFormula result = new DisjunctiveFormula(e);

        actions.actionDisjunctiveFormulaBeforeArg1(result);
        result.setArg1(processFormula(e.elements().get(0)));
        actions.actionDisjunctiveFormulaAfterArg1(result);

        actions.actionDisjunctiveFormulaBeforeArg2(result);
        result.setArg2(processFormula(e.elements().get(1)));
        actions.actionDisjunctiveFormulaAfterArg2(result);

        return result;
    }

    private Existence processExistence(Element e) {
        Existence result = new Existence(e);
        actions.actionExistence(result);
        return result;
    }

    private ExistentialAssumption processExistentialAssumption(Element e) {
        ExistentialAssumption result = new ExistentialAssumption(e);

        actions.actionExistentialAssumptionBeforeQualifiedSegments(result);
        result.setQualifiedSegments(processQualifiedSegments(e.element("Qualified-Segments")));
        actions.actionExistentialAssumptionAfterQualifiedSegments(result);

        actions.actionExistentialAssumptionBeforeConditions(result);
        result.setConditions(processConditions(e.element("Conditions")));
        actions.actionExistentialAssumptionAfterConditions(result);

        return result;
    }

    private ExistentialQuantifierFormula processExistentialQuantifierFormula(Element e) {
        ExistentialQuantifierFormula result = new ExistentialQuantifierFormula(e);

        actions.actionExistentialQuantifierFormulaBeforeVariableSegments(result);
        result.setVariableSegments(processVariableSegments(e.element("Variable-Segments")));
        actions.actionExistentialQuantifierFormulaAfterVariableSegments(result);

        actions.actionExistentialQuantifierFormulaBeforeScope(result);
        result.setScope(processScope(e.element("Scope")));
        actions.actionExistentialQuantifierFormulaAfterScope(result);

        return result;
    }

    private ExplicitlyQualifiedSegment processExplicitlyQualifiedSegment(Element e) {
        ExplicitlyQualifiedSegment result = new ExplicitlyQualifiedSegment();

        actions.actionExplicitlyQualifiedSegmentBeforeVariables(result);
        result.setVariables(processVariables(e.element("Variables")));
        actions.actionExplicitlyQualifiedSegmentAfterVariables(result);

        actions.actionExplicitlyQualifiedSegmentBeforeType(result);
        result.setType(processType(e.elements().get(1)));
        actions.actionExplicitlyQualifiedSegmentAfterType(result);

        return result;
    }

    private ExistentialRegistration processExistentialRegistration(Element e) {
        ExistentialRegistration result = new ExistentialRegistration(e);

        actions.actionExistentialRegistrationBeforeAdjectiveCluster(result);
        result.setAdjectiveCluster(processAdjectiveCluster(e.elements().get(0)));
        actions.actionExistentialRegistrationAfterAdjectiveCluster(result);

        actions.actionExistentialRegistrationBeforeType(result);
        result.setType(processType(e.elements().get(1)));
        actions.actionExistentialRegistrationAfterType(result);

        return result;
    }

    private ExpandableMode processExpandableMode(Element e) {
        ExpandableMode result = new ExpandableMode(e);

        actions.actionExpandableModeBeforeType(result);
        result.setType(processType(e.elements().get(0)));
        actions.actionExpandableModeAfterType(result);

        return result;
    }

    private FlexaryConjunctiveFormula processFlexaryConjunctiveFormula(Element e) {
        FlexaryConjunctiveFormula result = new FlexaryConjunctiveFormula(e);

        actions.actionFlexaryConjunctiveFormulaBeforeArg1(result);
        result.setArg1(processFormula(e.elements().get(0)));
        actions.actionFlexaryConjunctiveFormulaAfterArg1(result);

        actions.actionFlexaryConjunctiveFormulaBeforeArg2(result);
        result.setArg2(processFormula(e.elements().get(1)));
        actions.actionFlexaryConjunctiveFormulaAfterArg2(result);

        return result;
    }

    private FlexaryDisjunctiveFormula processFlexaryDisjunctiveFormula(Element e) {
        FlexaryDisjunctiveFormula result = new FlexaryDisjunctiveFormula(e);

        actions.actioFlexaryDisjunctiveFormulaBeforeArg1(result);
        result.setArg1(processFormula(e.elements().get(0)));
        actions.actioFlexaryDisjunctiveFormulaAfterArg1(result);

        actions.actioFlexaryDisjunctiveFormulaBeforeArg2(result);
        result.setArg2(processFormula(e.elements().get(1)));
        actions.actioFlexaryDisjunctiveFormulaAfterArg2(result);

        return result;
    }

    private ForgetfulFunctorTerm processForgetfulFunctorTerm(Element e) {
        ForgetfulFunctorTerm result = new ForgetfulFunctorTerm(e);

        actions.actionForgetfulFunctorTermBeforeTerm(result);
        result.setTerm(processTerm(e.elements().get(0)));
        actions.actionForgetfulFunctorTermAfterTerm(result);

        return result;
    }

    private FormulaInterface processFormula(Element e) {
        FormulaInterface result = null;
        actions.actionFormulaInterfaceBefore(result);
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
        actions.actionFormulaInterfaceAfter(result);
        return result;
    }

    private FraenkelTerm processFraenkelTerm(Element e) {
        FraenkelTerm result = new FraenkelTerm(e);

        actions.actionFraenkelTermBeforeVariableSegments(result);
        result.setVariableSegments(processVariableSegments(e.elements().get(0)));
        actions.actionFraenkelTermAfterVariableSegments(result);

        actions.actionFraenkelTermBeforeTerm(result);
        result.setTerm(processTerm(e.elements().get(1)));
        actions.actionFraenkelTermAfterTerm(result);

        actions.actionFraenkelTermBeforeFormula(result);
        result.setFormula(processFormula(e.elements().get(2)));
        actions.actionFraenkelTermAfterFormula(result);

        return result;
    }

    private FreeVariableSegment processFreeVariableSegment(Element e) {
        FreeVariableSegment result = new FreeVariableSegment();

        actions.actionFreeVariableSegmentBeforeVariable(result);
        result.setVariable(processVariable(e.element("Variable")));
        actions.actionFreeVariableSegmentAfterVariable(result);

        actions.actionFreeVariableSegmentBeforeType(result);
        result.setType(processType(e.elements().get(1)));
        actions.actionFreeVariableSegmentAfterType(result);

        return result;
    }

    private FuncSynonym processFuncSynonym(Element e) {
        FuncSynonym result = new FuncSynonym(e);

        actions.actionFuncSynonymBeforeSynonym(result);
        result.setSynonym(processPattern(e.elements().get(0)));
        actions.actionFuncSynonymAfterSynonym(result);

        actions.actionFuncSynonymBeforeOriginal(result);
        result.setOriginal(processPatternShapedExpression(e.element("Pattern-Shaped-Expression")));
        actions.actionFuncSynonymAfterOriginal(result);

        return result;
    }

    private FunctorDefinition processFunctorDefinition(Element e) {
        FunctorDefinition result = new FunctorDefinition(e);

        actions.actionFunctorDefinitionBeforeRedefine(result);
        result.setRedefine(processRedefine(e.element("Redefine")));
        actions.actionFunctorDefinitionAfterRedefine(result);

        actions.actionFunctorDefinitionBeforePattern(result);
        result.setPattern(processPattern(e.elements().get(1)));
        actions.actionFunctorDefinitionAfterPattern(result);

        actions.actionFunctorDefinitionBeforeTypeSpecification(result);
        result.setTypeSpecification(processTypeSpecification(e.element("Type-Specification")));
        actions.actionFunctorDefinitionAfterTypeSpecification(result);

        actions.actionFunctorDefinitionBeforeDefiniens(result);
        result.setDefiniens(processDefiniens(e.element("Definiens")));
        actions.actionFunctorDefinitionAfterDefiniens(result);

        return result;
    }

    private FunctorialRegistration processFunctorialRegistration(Element e) {
        FunctorialRegistration result = new FunctorialRegistration(e);

        actions.actionFunctorialRegistrationBeforeTerm(result);
        result.setTerm(processTerm(e.elements().get(0)));
        actions.actionFunctorialRegistrationAfterTerm(result);

        actions.actionFunctorialRegistrationBeforeAdjectiveCluster(result);
        result.setAdjectiveCluster(processAdjectiveCluster(e.elements().get(1)));
        actions.actionFunctorialRegistrationAfterAdjectiveCluster(result);

        if (e.elements().size() > 2) {
            actions.actionFunctorialRegistrationBeforeType(result);
            result.setType(processType(e.elements().get(2)));
            actions.actionFunctorialRegistrationAfterType(result);
        }
        return result;
    }

    private GlobalChoiceTerm processGlobalChoiceTerm(Element e) {
        GlobalChoiceTerm result = new GlobalChoiceTerm(e);

        actions.actionGlobalChoiceTermBeforeType(result);
        result.setType(processType(e.elements().get(0)));
        actions.actionGlobalChoiceTermAfterType(result);

        return result;
    }

    private Identify processIdentify(Element e) {
        Identify result = new Identify(e);

        actions.actionIdentifyBeforeLeftPatternShapedExpression(result);
        result.setLeftPatternShapedExpression(processPatternShapedExpression(e.elements().get(1)));
        actions.actionIdentifyAfterLeftPatternShapedExpression(result);

        actions.actionIdentifyBeforeRightPatternShapedExpression(result);
        result.setRightPatternShapedExpression(processPatternShapedExpression(e.elements().get(0)));
        actions.actionIdentifyAfterRightPatternShapedExpression(result);

        actions.actionIdentifyBeforeLociEqualities(result);
        result.setLociEqualities(processLociEqualities(e.element("Loci-Equalities")));
        actions.actionIdentifyAfterLociEqualities(result);

        return result;
    }

    private ImplicitlyQualifiedSegment processImplicitlyQualifiedSegment(Element e) {
        ImplicitlyQualifiedSegment result = new ImplicitlyQualifiedSegment();

        actions.actionImplicitlyQualifiedSegmentBeforeVariable(result);
        result.setVariable(processVariable(e.element("Variable")));
        actions.actionImplicitlyQualifiedSegmentAfterVariable(result);

        actions.actionImplicitlyQualifiedSegmentBeforeType(result);
        result.setType(processType(e.elements().get(1)));
        actions.actionImplicitlyQualifiedSegmentAfterType(result);

        return result;
    }

    private InfixTerm processInfixTerm(Element e) {
        InfixTerm result = new InfixTerm(e);

        actions.actionInfixTermBeforeArguments(result);
        result.setArguments(processArguments(e.element("Arguments")));
        actions.actionInfixTermAfterArguments(result);

        return result;
    }

    private InternalSelectorTerm processInternalSelectorTerm(Element e) {
        InternalSelectorTerm result = new InternalSelectorTerm(e);
        actions.actionInternalSelectorTerm(result);
        return result;
    }

    private ItTerm processItTerm(Element e) {
        ItTerm result = new ItTerm(e);
        actions.actionItTerm(result);
        return result;
    }

    private JustificationInterface processJustification(Element e) {
        JustificationInterface result = null;
        actions.actionJustification(result);
        return result;
    }

    private Label processLabel(Element e) {
        Label result = new Label(e);
        actions.actionLabel(result);
        return result;
    }

    private Loci processLoci(Element e) {
        Loci result = new Loci(e);

        actions.actionLociBefore(result);
        for (Element element: e.elements()) {
            result.getLoci().add(processLocus(element));
        }
        actions.actionLociAfter(result);

        return result;
    }

    private LociDeclaration processLociDeclaration(Element e) {
        LociDeclaration result = new LociDeclaration(e);

        actions.actionLociDeclarationBeforeQualifiedSegments(result);
        result.setQualifiedSegments(processQualifiedSegments(e.element("Qualified-Segments")));
        actions.actionLociDeclarationAfterQualifiedSegments(result);

        return result;
    }

    private LociEqualities processLociEqualities(Element e) {
        LociEqualities result = new LociEqualities(e);

        actions.actionLociEqualitiesBefore(result);
        for (Element element: e.elements())
            result.getLociEqualities().add(processLociEquality(element));
        actions.actionLociEqualitiesAfter(result);

        return result;
    }

    private LociEquality processLociEquality(Element e) {
        LociEquality result = new LociEquality(e);

        actions.actionLociEqualityBeforeLocus_1(result);
        result.setLocus_1(processLocus(e.elements().get(0)));
        actions.actionLociEqualityAfterLocus_1(result);

        actions.actionLociEqualityBeforeLocus_2(result);
        result.setLocus_2(processLocus(e.elements().get(1)));
        actions.actionLociEqualityAfterLocus_2(result);

        return result;
    }

    private Locus processLocus(Element e) {
        Locus result = new Locus(e);
        actions.actionLocus(result);
        return result;
    }

    private ModeDefinition processModeDefinition(Element e) {
        ModeDefinition result = new ModeDefinition(e);

        actions.actionModeDefinitionBeforeRedefine(result);
        result.setRedefine(processRedefine(e.element("Redefine")));
        actions.actionModeDefinitionAfterRedefine(result);

        actions.actionModeDefinitionBeforePattern(result);
        result.setPattern(processPattern(e.elements().get(1)));
        actions.actionModeDefinitionAfterPattern(result);

        actions.actionModeDefinitionBeforeModeDescription(result);
        result.setModeDescription(processModeDescription(e.elements().get(2)));
        actions.actionModeDefinitionAfterModeDescription(result);

        return result;
    }

    private ModeDescriptionInterface processModeDescription(Element e) {
        ModeDescriptionInterface result = null;
        switch (e.getName()) {
            case "Standard-Mode":
                actions.actionModeDescriptionInterfaceBeforeStandardMode(result);
                result = processStandardMode(e);
                actions.actionModeDescriptionInterfaceAfterStandardMode(result);
                break;
            case "Expandable-Mode":
                actions.actionModeDescriptionInterfaceBeforeExpandableMode(result);
                result = processExpandableMode(e);
                actions.actionModeDescriptionInterfaceAfterExpandableMode(result);
                break;
            default:
                Errors.error(e,"UNKNOWN Mode Kind");
        }
        return result;
    }

    private ModeSynonym processModeSynonym(Element e) {
        ModeSynonym result = new ModeSynonym(e);

        actions.actionModeSynonymBeforeSynonym(result);
        result.setSynonym(processPattern(e.element("Mode-Pattern")));
        actions.actionModeSynonymAfterSynonym(result);

        actions.actionModeSynonymBeforeOriginal(result);
        result.setOriginal(processPatternShapedExpression(e.element("Pattern-Shaped-Expression")));
        actions.actionModeSynonymAfterOriginal(result);

        return result;
    }

    private MultiAttributiveFormula processMultiAttributiveFormula(Element e) {
        MultiAttributiveFormula result = new MultiAttributiveFormula(e);

        actions.actionMultiAttributiveFormulaBeforeTerm(result);
        result.setSubject(processTerm(e.elements().get(0)));
        actions.actionMultiAttributiveFormulaAfterTerm(result);

        actions.actionMultiAttributiveFormulaBeforeAdjectiveCluster(result);
        result.setAdjectiveCluster(processAdjectiveCluster(e.element("Adjective-Cluster")));
        actions.actionMultiAttributiveFormulaAfterAdjectiveCluster(result);

        return result;
    }

    private MultiRelationFormula processMultiRelationFormula(Element e) {
        MultiRelationFormula result = new MultiRelationFormula(e);

        actions.actionMultiRelationFormulaBeforeFormula(result);
        result.setFormula(processFormula(e.elements().get(0)));
        actions.actionMultiRelationFormulaAfterFormula(result);

        actions.actionMultiRelationFormulaBeforeRightSideOfRelationFormula(result);
        for (int i = 1; i < e.elements().size(); i++)
            result.getRightFormulas().add(processRightSideOfRelationFormula(e.elements().get(i)));
        actions.actionMultiRelationFormulaAfterRightSideOfRelationFormula(result);

        return result;
    }

    private NegatedFormula processNegatedFormula(Element e) {
        NegatedFormula result = new NegatedFormula(e);

        actions.actionNegatedFormulaBeforeArg(result);
        result.setArg(processFormula(e.elements().get(0)));
        actions.actionNegatedFormulaAfterArg(result);

        return result;
    }

    private NotionName processNotionName(Element e) {
        NotionName result = new NotionName(e);
        actions.actionNotionName(result);
        return result;
    }

    private NumeralTerm processNumeralTerm(Element e) {
        NumeralTerm result = new NumeralTerm(e);
        actions.actionNumeralTerm(result);
        return result;
    }

    private Otherwise processOtherwise(Element e, String shape) {
        Otherwise result = null;
        switch (shape) {
            case "formula":
                result = new OtherwiseMeans(e);
                if (e.elements().size() > 0) {
                    actions.actionOtherwiseMeansBeforeFormula((OtherwiseMeans)result);
                    ((OtherwiseMeans) result).setFormula(processFormula(e.elements().get(0)));
                    actions.actionOtherwiseMeansAfterFormula((OtherwiseMeans)result);
                }
                break;
            case "term":
                result = new OtherwiseEquals(e);
                if (e.elements().size() > 0) {
                    actions.actionOtherwiseEqualsBeforeTerm((OtherwiseEquals)result);
                    ((OtherwiseEquals) result).setTerm(processTerm(e.elements().get(0)));
                    actions.actionOtherwiseEqualsAfterTerm((OtherwiseEquals)result);
                }
                break;
        }
        return result;
    }

    private PartialDefiniensEquals processPartialDefiniensEquals(Element e) {
        PartialDefiniensEquals result = new PartialDefiniensEquals(e);

        actions.actionPartialDefiniensEqualsBeforeTerm(result);
        result.setTerm(processTerm(e.elements().get(0)));
        actions.actionPartialDefiniensEqualsAfterTerm(result);

        actions.actionPartialDefiniensEqualsBeforeGuard(result);
        result.setGuard(processFormula(e.elements().get(1)));
        actions.actionPartialDefiniensEqualsAfterGuard(result);

        return result;
    }

    private PartialDefiniensMeans processPartialDefiniensMeans(Element e) {
        PartialDefiniensMeans result = new PartialDefiniensMeans(e);

        actions.actionPartialDefiniensMeansBeforeFormula(result);
        result.setFormula(processFormula(e.elements().get(0)));
        actions.actionPartialDefiniensMeansAfterFormula(result);

        actions.actionPartialDefiniensMeansBeforeGuard(result);
        result.setGuard(processFormula(e.elements().get(1)));
        actions.actionPartialDefiniensMeansAfterGuard(result);

        return result;
    }

    private PartialDefiniensList processPartialDefiniensList(Element e, String shape) {
        PartialDefiniensList result = new PartialDefiniensList(e);
        actions.actionPartialDefiniensListBefore(result);
        for (Element element: e.elements()) {
            switch (shape) {
                case "formula":
                    actions.actionPartialDefiniensListBeforeDefiniensMeans(result);
                    result.getPartialDefiniens().add(processPartialDefiniensMeans(element));
                    actions.actionPartialDefiniensListAfterDefiniensMeans(result);
                    break;
                case "term":
                    actions.actionPartialDefiniensListBeforeDefiniensEquals(result);
                    result.getPartialDefiniens().add(processPartialDefiniensEquals(element));
                    actions.actionPartialDefiniensListAfterDefiniensEquals(result);
                    break;
            }
        }
        actions.actionPartialDefiniensListAfter(result);
        return result;
    }

    private PatternInterface processPattern(Element e) {
        PatternInterface result = null;
        actions.actionPatternInterfaceBefore(result);
        switch (e.getName()) {
            case "Attribute-Pattern":
                result = new AttributePattern(e);
                actions.actionAttributePatternBeforeSubject((AttributePattern)result);
                ((AttributePattern)result).setSubject(processLocus(e.elements().get(0)));
                actions.actionAttributePatternAfterSubject((AttributePattern)result);
                actions.actionAttributePatternBeforeArguments((AttributePattern)result);
                ((AttributePattern)result).setArguments(processLoci(e.elements().get(1)));
                actions.actionAttributePatternAfterArguments((AttributePattern)result);
                break;
            case "CircumfixFunctor-Pattern":
                result = new CircumfixFunctorPattern(e);
                actions.actionCircumfixFunctorPatternBeforeRightCircumflexSymbol((CircumfixFunctorPattern)result);
                ((CircumfixFunctorPattern)result).setRightCircumflexSymbol(processRightCircumflexSymbol(e.element("Right-Circumflex-Symbol")));
                actions.actionCircumfixFunctorPatternAfterRightCircumflexSymbol((CircumfixFunctorPattern)result);
                actions.actionCircumfixFunctorPatternBeforeLoci((CircumfixFunctorPattern)result);
                ((CircumfixFunctorPattern)result).setLoci(processLoci(e.element("Loci")));
                actions.actionCircumfixFunctorPatternAfterLoci((CircumfixFunctorPattern)result);
                break;
            case "InfixFunctor-Pattern":
                result = new InfixFunctorPattern(e);
                actions.actionInfixFunctorPatternBeforeLeftLoci((InfixFunctorPattern)result);
                ((InfixFunctorPattern)result).setLeftLoci(processLoci(e.elements().get(0)));
                actions.actionInfixFunctorPatternAfterLeftLoci((InfixFunctorPattern)result);
                actions.actionInfixFunctorPatternBeforeRightLoci((InfixFunctorPattern)result);
                ((InfixFunctorPattern)result).setRightLoci(processLoci(e.elements().get(1)));
                actions.actionInfixFunctorPatternAfterRightLoci((InfixFunctorPattern)result);
                break;
            case "Mode-Pattern":
                result = new ModePattern(e);
                actions.actionModePatternBeforeLoci(((ModePattern)result));
                ((ModePattern)result).setLoci(processLoci(e.element("Loci")));
                actions.actionModePatternAfterLoci(((ModePattern)result));
                break;
            case "Predicate-Pattern":
                result = new PredicatePattern(e);
                actions.actionPredicatePatternBeforeLeftLoci((PredicatePattern)result);
                ((PredicatePattern)result).setLeftLoci(processLoci(e.elements().get(0)));
                actions.actionPredicatePatternAfterLeftLoci((PredicatePattern)result);
                actions.actionPredicatePatternBeforeRightLoci((PredicatePattern)result);
                ((PredicatePattern)result).setRightLoci(processLoci(e.elements().get(1)));
                actions.actionPredicatePatternAfterRightLoci((PredicatePattern)result);
                break;
            case "Structure-Pattern":
                result = new StructurePattern(e);
                actions.actionStructurePatternBeforeLoci(result);
                ((StructurePattern)result).setLoci(processLoci(e.element("Loci")));
                actions.actionStructurePatternAfterLoci(result);
                break;
            default:
                Errors.error(e,"UNKNOWN Pattern");
        }
        actions.actionPatternInterfaceAfter(result);
        return result;
    }

    private PatternShapedExpression processPatternShapedExpression(Element e) {
        PatternShapedExpression result = new PatternShapedExpression(e);

        actions.actionPatternShapedExpressionBeforePatter(result);
        result.setPattern(processPattern(e.elements().get(0)));
        actions.actionPatternShapedExpressionAfterPatter(result);
        return result;
    }

    private Pragma processPragma(Element e) {
        Pragma result = new Pragma(e);
        actions.actionPragmaBefore(result);
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
        actions.actionPragmaAfter(result);
        return result;
    }

    private PredAntonym processPredAntonym(Element e) {
        PredAntonym result = new PredAntonym(e);

        actions.actionPredAntonymBeforeAntonym(result);
        result.setAntonym(processPattern(e.element("Predicate-Pattern")));
        actions.actionPredAntonymAfterAntonym(result);

        actions.actionPredAntonymBeforeOrginal(result);
        result.setOriginal(processPatternShapedExpression(e.element("Pattern-Shaped-Expression")));
        actions.actionPredAntonymAfterOrginal(result);

        return result;
    }

    private PredSynonym processPredSynonym(Element e) {
        PredSynonym result = new PredSynonym(e);

        actions.actionPredSynonymBeforePattern(result);
        result.setSynonym(processPattern(e.element("Predicate-Pattern")));
        actions.actionPredSynonymAfterPattern(result);

        actions.actionPredSynonymBeforeOriginal(result);
        result.setOriginal(processPatternShapedExpression(e.element("Pattern-Shaped-Expression")));
        actions.actionPredSynonymAfterOriginal(result);

        return result;
    }

    private PredicateDefinition processPredicateDefinition(Element e) {
        PredicateDefinition result = new PredicateDefinition(e);

        actions.actionPredicateDefinitionBeforeRedefine(result);
        result.setRedefine(processRedefine(e.element("Redefine")));
        actions.actionPredicateDefinitionAfterRedefine(result);

        actions.actionPredicateDefinitionBeforePattern(result);
        result.setPattern(processPattern(e.elements().get(1)));
        actions.actionPredicateDefinitionAfterPattern(result);

        actions.actionPredicateDefinitionBeforeDefiniens(result);
        result.setDefiniens(processDefiniens(e.element("Definiens")));
        actions.actionPredicateDefinitionAfterDefiniens(result);

        return result;
    }

    private PrivateFunctorTerm processPrivateFunctorTerm(Element e) {
        PrivateFunctorTerm result = new PrivateFunctorTerm(e);

        actions.actionPrivateFunctorTermBeforeArguments(result);
        result.setArguments(processArguments(e.element("Arguments")));
        actions.actionPrivateFunctorTermAfterArguments(result);

        return result;
    }

    private PrivatePredicateFormula processPrivatePredicateFormula(Element e) {
        PrivatePredicateFormula result = new PrivatePredicateFormula(e);

        actions.actionPrivatePredicateFormulaBeforeArguments(result);
        result.setArguments(processArguments(e.element("Arguments")));
        actions.actionPrivatePredicateFormulaAfterArguments(result);

        return result;
    }

    private Properties processProperties(Element e) {
        Properties result = new Properties(e);
        if (e.elements().size() > 0) {
            actions.actionPropertiesBeforeType(result);
            result.setType(processType(e.elements().get(0)));
            actions.actionPropertiesAfterType(result);
        }
        return result;
    }

    private Property processProperty(Element e) {
        Property result = new Property(e);

        actions.actionPropertyBeforeProperties(result);
        result.setProperties(processProperties(e.element("Properties")));
        actions.actionPropertyAfterProperties(result);

        actions.actionPropertyBeforeJustification(result);
        result.setJustification(processJustification(e.elements().get(1)));
        actions.actionPropertyAfterJustification(result);

        return result;
    }

    private PropertyRegistration processPropertyRegistration(Element e) {
        PropertyRegistration result = new PropertyRegistration(e);

        actions.actionPropertyRegistrationBeforeProperties(result);
        result.setProperties(processProperties(e.element("Properties")));
        actions.actionPropertyRegistrationAfterProperties(result);

        actions.actionPropertyRegistrationBeforeJustification(result);
        result.setJustification(processJustification(e.elements().get(1)));
        actions.actionPropertyRegistrationAfterJustification(result);

        return result;
    }

    private Proposition processProposition(Element e) {
        Proposition result = new Proposition();

        actions.actionPropositionBeforeLabel(result);
        result.setLabel(processLabel(e.element("Label")));
        actions.actionPropositionAfterLabel(result);

        actions.actionPropositionBeforeFormula(result);
        result.setFormula(processFormula(e.elements().get(1)));
        actions.actionPropositionAfterFormula(result);

        return result;
    }

    private QualificationTerm processQualificationTerm(Element e) {
        QualificationTerm result = new QualificationTerm(e);

        actions.actionQualificationTermBeforeTerm(result);
        result.setTerm(processTerm(e.elements().get(0)));
        actions.actionQualificationTermAfterTerm(result);

        actions.actionQualificationTermBeforeType(result);
        result.setType(processType(e.elements().get(1)));
        actions.actionQualificationTermAfterType(result);

        return result;
    }

    private QualifiedSegments processQualifiedSegments(Element e) {
        QualifiedSegments result = new QualifiedSegments(e);

        actions.actionQualifiedSegmentsBefore(result);
        for (Element element : e.elements()) {
            result.getQualifiedSegments().add(processVariableSegment(element));
        }
        actions.actionQualifiedSegmentsAfter(result);

        return result;
    }

    private QualifyingFormula processQualifyingFormula(Element e) {
        QualifyingFormula result = new QualifyingFormula(e);

        actions.actionQualifyingFormulaBeforeTerm(result);
        result.setTerm(processTerm(e.elements().get(0)));
        actions.actionQualifyingFormulaAfterTerm(result);

        actions.actionQualifyingFormulaBeforeType(result);
        result.setType(processType(e.elements().get(1)));
        actions.actionQualifyingFormulaAfterType(result);

        return result;
    }

    private Redefine processRedefine(Element e) {
        Redefine result = new Redefine(e);
        actions.actionRedefine(result);
        return result;
    }

    private Reducibility processReducibility(Element e) {
        Reducibility result = new Reducibility(e);
        actions.actionReducibility(result);
        return result;
    }

    private Reduction processReduction(Element e) {
        Reduction result = new Reduction(e);

        actions.actionReductionBeforeLeftTerm(result);
        result.setLeftTerm(processTerm(e.elements().get(0)));
        actions.actionReductionAfterLeftTerm(result);

        actions.actionReductionBeforeRightTerm(result);
        result.setRightTerm(processTerm(e.elements().get(1)));
        actions.actionReductionAfterRightTerm(result);

        return result;
    }

    private RelationFormula processRelationFormula(Element e) {
        RelationFormula result = new RelationFormula(e);

        actions.actionRelationFormulaBeforeArguments(result);
        result.setArguments(processArguments(e.element("Arguments")));
        actions.actionRelationFormulaAfterArguments(result);

        return result;
    }

    private Reservation processReservation(Element e) {
        Reservation result = new Reservation(e);

        actions.actionReservationBeforeReservationSegments(result);
        for (Element element: e.elements())
            result.getReservationSegments().add(processReservationSegment(element));
        actions.actionReservationAfterReservationSegments(result);

        return result;
    }

    private ReservationSegment processReservationSegment(Element e) {
        ReservationSegment result = new ReservationSegment(e);

        actions.actionReservationSegmentBeforeVariables(result);
        result.setVariables(processVariables(e.element("Variables")));
        actions.actionReservationSegmentAfterVariables(result);

        actions.actionReservationSegmentBeforeVariableSegments(result);
        result.setVariableSegments(processVariableSegments(e.element("Variable-Segments")));
        actions.actionReservationSegmentAfterVariableSegments(result);

        actions.actionReservationSegmentBeforeType(result);
        result.setType(processType(e.elements().get(2)));
        actions.actionReservationSegmentAfterType(result);

        return result;
    }

    private ReservedDscrType processReservedDscrType(Element e) {
        ReservedDscrType result = new ReservedDscrType(e);

        actions.actionReservedDscrTypeBeforeSubstitutions(result);
        result.setSubstitutions(processSubstitutions(e.element("Substitutions")));
        actions.actionReservedDscrTypeAfterSubstitutions(result);

        actions.actionReservedDscrTypeBeforeType(result);
        result.setType(processType(e.elements().get(1)));
        actions.actionReservedDscrTypeAfterType(result);

        return result;
    }

    private Restriction processRestriction(Element e) {
        if (e == null)
            return null;
        Restriction result = new Restriction(e);

        actions.actionRestrictionBeforeFormula(result);
        result.setFormula(processFormula(e.elements().get(0)));
        actions.actionRestrictionAfterFormula(result);

        return result;
    }

    private RightCircumflexSymbol processRightCircumflexSymbol(Element e) {
        RightCircumflexSymbol result = new RightCircumflexSymbol(e);
        actions.actionRightCircumflexSymbol(result);
        return result;
    }

    private Scope processScope(Element e) {
        Scope result = new Scope(e);

        actions.actionScopeBeforeFormula(result);
        result.setFormula(processFormula(e.elements().get(0)));
        actions.actionScopeAfterFormula(result);

        return result;
    }

    private RightSideOfRelationFormula processRightSideOfRelationFormula(Element e) {
        RightSideOfRelationFormula result = new RightSideOfRelationFormula(e);

        actions.actionRightSideOfRelationFormulaBeforeArguments(result);
        result.setArguments(processArguments(e.element("Arguments")));
        actions.actionRightSideOfRelationFormulaAfterArguments(result);

        return result;
    }

    private SectionPragma processSection(Element e) {
        SectionPragma result = new SectionPragma(e);
        actions.actionSection(result);
        return result;
    }

    private SimpleFraenkelTerm processSimpleFraenkelTerm(Element e) {
        SimpleFraenkelTerm result = new SimpleFraenkelTerm(e);

        actions.actionSimpleFraenkelTermBeforeVariableSegments(result);
        result.setVariableSegments(processVariableSegments(e.elements().get(0)));
        actions.actionSimpleFraenkelTermAfterVariableSegments(result);

        actions.actionSimpleFraenkelTermBeforeTerm(result);
        result.setTerm(processTerm(e.elements().get(1)));
        actions.actionSimpleFraenkelTermAfterTerm(result);

        return result;
    }

    private SimpleTerm processSimpleTerm(Element e) {
        SimpleTerm result = new SimpleTerm(e);
        actions.actionSimpleTerm(result);
        return result;
    }

    private SingleAssumption processSingleAssumption(Element e) {
        SingleAssumption result = new SingleAssumption(e);

        actions.actionSingleAssumptionBeforeProposition(result);
        result.setProposition(processProposition(e.element("Proposition")));
        actions.actionSingleAssumptionAfterProposition(result);

        return result;
    }

    private StandardMode processStandardMode(Element e) {
        StandardMode result = new StandardMode(e);

        actions.actionStandardModeBeforeTypeSpecification(result);
        result.setTypeSpecification(processTypeSpecification(e.element("Type-Specification")));
        actions.actionStandardModeAfterTypeSpecification(result);

        actions.actionStandardModeBeforeDefiniens(result);
        result.setDefiniens(processDefiniens(e.element("Definiens")));
        actions.actionStandardModeAfterDefiniens(result);

        return result;
    }

    private StandardType processStandardType(Element e) {
        StandardType result = new StandardType(e);

        actions.actionStandardTypeBeforeArguments(result);
        result.setArguments(processArguments(e.element("Arguments")));
        actions.actionStandardTypeAfterArguments(result);

        return result;
    }

    private StructType processStructType(Element e) {
        StructType result = new StructType(e);

        actions.actionStructTypeBeforeArguments(result);
        result.setArguments(processArguments(e.element("Arguments")));
        actions.actionStructTypeAfterArguments(result);

        return result;
    }

    private Substitution processSubstitution(Element e) {
        Substitution result = new Substitution(e);
        actions.actionSubstitution(result);
        return result;
    }

    private Substitutions processSubstitutions(Element e) {
        Substitutions result = new Substitutions();

        actions.actionSubstitutionsBefore(result);
        for (Element element: e.elements())
            result.getSubstitutions().add(processSubstitution(element));
        actions.actionSubstitutionsAfter(result);

        return result;
    }

    private TermInterface processTerm(Element e) {
        TermInterface result = null;
        actions.actionTermInterfaceBefore(result);
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
        actions.actionTermInterfaceAfter(result);
        return result;
    }

    private TextProper processTextProper(Element e) {
        TextProper result = new TextProper(e);
        actions.actionTextProper(result);
        return result;
    }

    private TheoremItem processTheoremItem(Element e) {
        TheoremItem result = new TheoremItem(e);

        actions.actionTheoremItemBeforeProposition(result);
        result.setProposition(processProposition(e.element("Proposition")));
        actions.actionTheoremItemAfterProposition(result);

        actions.actionTheoremItemBeforeJustification(result);
        result.setJustification(processJustification(e.elements().get(1)));
        actions.actionTheoremItemAfterJustification(result);

        return result;
    }

    private TypeInterface processType(Element e) {
        TypeInterface result = null;
        actions.actionTypeInterfaceBefore(result);
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
        actions.actionTypeInterfaceAfter(result);
        return result;
    }

    private TypeSpecification processTypeSpecification(Element e) {
        TypeSpecification result = new TypeSpecification(e);
        if (e != null) {
            actions.actionTypeSpecificationBeforeType(result);
            result.setType(processType(e.elements().get(0)));
            actions.actionTypeSpecificationAfterType(result);
        }
        return result;
    }

    private Uniqueness processUniqueness(Element e) {
        Uniqueness result = new Uniqueness(e);
        actions.actionUniqueness(result);
        return result;
    }

    private UniversalQuantifierFormula processUniversalQuantifierFormula(Element e) {
        UniversalQuantifierFormula result = new UniversalQuantifierFormula(e);

        actions.actionUniversalQuantifierFormulaBeforeVariableSegments(result);
        result.setVariableSegments(processVariableSegments(e.element("Variable-Segments")));
        actions.actionUniversalQuantifierFormulaAfterVariableSegments(result);

        actions.actionUniversalQuantifierFormulaBeforeRestriction(result);
        result.setRestriction(processRestriction(e.element("Restriction")));
        actions.actionUniversalQuantifierFormulaAfterRestriction(result);

        actions.actionUniversalQuantifierFormulaBeforeScope(result);
        result.setScope(processScope(e.element("Scope")));
        actions.actionUniversalQuantifierFormulaAfterScope(result);

        return result;
    }

    private Unknown processUnknown(Element e) {
        Unknown result = new Unknown(e);
        actions.actionUnknown(result);
        return result;
    }

    private Variable processVariable(Element e) {
        Variable result = new Variable(e);
        actions.actionVariable(result);
        return result;
    }

    private Variables processVariables(Element e) {
        Variables result = new Variables();

        actions.actionVariablesBefore(result);
        for (Element element : e.elements())
            result.getVariables().add(processVariable(element));
        actions.actionVariablesAfter(result);

        return result;
    }

    private VariableSegmentInterface processVariableSegment(Element e) {
        VariableSegmentInterface result = null;
        actions.actionVariableSegmentInterfaceBefore(result);
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
        actions.actionVariableSegmentInterfaceAfter(result);
        return result;
    }

    private VariableSegments processVariableSegments(Element e) {
        VariableSegments result = new VariableSegments();

        actions.actionVariableSegmentsBefore(result);
        for (Element element : e.elements())
            result.getVariableSegments().add(processVariableSegment(element));
        actions.actionVariableSegmentsAfter(result);

        return result;
    }

    /* SCHEMES */

    private SchemeBlockItem processSchemeBlockItem(Element e) {
        SchemeBlockItem result = new SchemeBlockItem(e);
        actions.actionSchemeBlockItem(result);
        return result;
    }

    private Scheme processScheme(Element e) {
        Scheme result = new Scheme(e);
        actions.actionScheme(result);
        return result;
    }

    private SchematicVariables processSchematicVariables(Element e) {
        SchematicVariables result = new SchematicVariables(e);

        actions.actionSchematicVariablesBefore(result);
        for (Element element: e.elements())
            result.getSegments().add(processSchemeInputSegment(element));
        actions.actionSchematicVariablesAfter(result);

        return result;
    }

    private SchemeHead processSchemeHead(Element e) {
        SchemeHead result = new SchemeHead(e);

        actions.actionSchemeHeadBeforeScheme(result);
        result.setScheme(processScheme(e.element("Scheme")));
        actions.actionSchemeHeadAfterScheme(result);

        actions.actionSchemeHeadBeforeSchematicVariables(result);
        result.setSchematicVariables(processSchematicVariables(e.element("Schematic-Variables")));
        actions.actionSchemeHeadAfterSchematicVariables(result);

        actions.actionSchemeHeadBeforeFormula(result);
        result.setFormula(processFormula(e.elements().get(2)));
        actions.actionSchemeHeadAfterFormula(result);

        actions.actionSchemeHeadBeforeProvisionalFormulas(result);
        result.setProvisionalFormulas(processProvisionalFormulas(e.element("Provisional-Formulas")));
        actions.actionSchemeHeadAfterProvisionalFormulas(result);

        return result;
    }

    private SchemaInputSegment processSchemeInputSegment(Element e) {
        SchemaInputSegment result = null;
        switch (e.getName()) {
            case "Functor-Segment":
                actions.actionSchemaInputSegmentBeforeFunctorSegment(result);
                result = processFunctorSegment(e);
                actions.actionSchemaInputSegmentAfterFunctorSegment(result);
                break;
            case "Predicate-Segment":
                actions.actionSchemaInputSegmentBeforePredicateSegment(result);
                result = processPredicateSegment(e);
                actions.actionSchemaInputSegmentAfterPredicateSegment(result);
                break;
            default:
                Errors.error(e,"UNKNOWN Segment");
        }
        return result;
    }

    private FunctorSegment processFunctorSegment(Element e) {
        FunctorSegment result = new FunctorSegment(e);

        actions.actionFunctorSegmentBeforeVariables(result);
        result.setVariables(processVariables(e.element("Variables")));
        actions.actionFunctorSegmentAfterVariables(result);

        actions.actionFunctorSegmentBeforeArgumentTypes(result);
        result.setArgumentTypes(processTypeList(e.element("Type-List")));
        actions.actionFunctorSegmentAfterArgumentTypes(result);

        actions.actionFunctorSegmentBeforeResultType(result);
        result.setResultType(processTypeSpecification(e.element("Type-Specification")));
        actions.actionFunctorSegmentAfterResultType(result);

        return result;
    }

    private PredicateSegment processPredicateSegment(Element e) {
        PredicateSegment result = new PredicateSegment(e);

        actions.actionPredicateSegmentBeforeVariables(result);
        result.setVariables(processVariables(e.element("Variables")));
        actions.actionPredicateSegmentAfterVariables(result);

        actions.actionPredicateSegmentBeforeArgumentTypes(result);
        result.setArgumentTypes(processTypeList(e.element("Type-List")));
        actions.actionPredicateSegmentAfterArgumentTypes(result);

        return result;
    }

    private TypeList processTypeList(Element e) {
        TypeList result = new TypeList(e);

        actions.actionTypeListBefore(result);
        for (Element element: e.elements())
            result.getTypes().add(processType(element));
        actions.actionTypeListAfter(result);

        return result;
    }

    private ProvisionalFormulas processProvisionalFormulas(Element e) {
        if (e == null)
            return null;
        ProvisionalFormulas result = new ProvisionalFormulas(e);

        actions.actionProvisionalFormulasBefore(result);
        for (Element element: e.elements())
            result.getProvisionals().add(processProposition(element));
        actions.actionProvisionalFormulasAfter(result);

        return result;
    }

    /* STRUCTURES */

    private StructureDefinition processStructureDefinition(Element e) {
        StructureDefinition result = new StructureDefinition(e);

        actions.actionStructureDefinitionBeforeAncestors(result);
        result.setAncestors(processAncestors(e.element("Ancestors")));
        actions.actionStructureDefinitionAfterAncestors(result);

        actions.actionStructureDefinitionBeforePattern(result);
        result.setPattern(processPattern(e.element("Structure-Pattern")));
        actions.actionStructureDefinitionAfterPattern(result);

        actions.actionStructureDefinitionBeforeFieldSegments(result);
        result.setFieldSegments(processFieldSegments(e.element("Field-Segments")));
        actions.actionStructureDefinitionAfterFieldSegments(result);

        actions.actionStructureDefinitionBeforeStructurePatternsRendering(result);
        result.setStructurePatternsRendering(processStructurePatternsRendering(e.element("Structure-Patterns-Rendering")));
        actions.actionStructureDefinitionAfterStructurePatternsRendering(result);

        return result;
    }

    private Ancestors processAncestors(Element e) {
        Ancestors result = new Ancestors(e);

        actions.actionAncestorsBefore(result);
        for (Element element: e.elements())
            result.getAncestors().add(processType(element));
        actions.actionAncestorsAfter(result);

        return result;
    }

    private AggregateTerm processAggregateTerm(Element e) {
        AggregateTerm result = new AggregateTerm(e);

        actions.actionAggregateTermBeforeArguments(result);
        result.setArguments(processArguments(e.element("Arguments")));
        actions.actionAggregateTermAfterArguments(result);

        return result;
    }

    private FieldSegment processFieldSegment(Element e) {
        FieldSegment result = new FieldSegment(e);

        actions.actionFieldSegmentBeforeSelectors(result);
        result.setSelectors(processSelectors(e.element("Selectors")));
        actions.actionFieldSegmentAfterSelectors(result);

        actions.actionFieldSegmentBeforeType(result);
        result.setType(processType(e.elements().get(1)));
        actions.actionFieldSegmentAfterType(result);

        return result;
    }

    private FieldSegments processFieldSegments(Element e) {
        FieldSegments result = new FieldSegments(e);

        actions.actionFieldSegmentsBefore(result);
        for (Element element: e.elements())
            result.getFieldSegments().add(processFieldSegment(element));
        actions.actionFieldSegmentsAfter(result);

        return result;
    }

    private SelectorTerm processSelectorTerm(Element e) {
        SelectorTerm result = new SelectorTerm(e);

        actions.actionSelectorTermBeforeArgumen(result);
        result.setArgument(processTerm(e.elements().get(0)));
        actions.actionSelectorTermAfterArgumen(result);

        return result;
    }

    private Selector processSelector(Element e) {
        Selector result = new Selector(e);

        actions.actionSelectorBeforeLocus(result);
        result.setLocus(processLocus(e.element("Locus")));
        actions.actionSelectorAfterLocus(result);

        return result;
    }

    private Selectors processSelectors(Element e) {
        Selectors result = new Selectors(e);

        actions.actionSelectorsBefore(result);
        for (Element element: e.elements())
            result.getSelectors().add(processSelector(element));
        actions.actionSelectorsAfter(result);

        return result;
    }

    private StructurePatternsRendering processStructurePatternsRendering(Element e) {
        StructurePatternsRendering result = new StructurePatternsRendering(e);

        actions.actionStructurePatternsRenderingBeforeAggregateFunctorPattern(result);
        result.setAggregateFunctorPattern(processAggregateFunctorPattern(e.element("AggregateFunctor-Pattern")));
        actions.actionStructurePatternsRenderingAfterAggregateFunctorPattern(result);

        actions.actionStructurePatternsRenderingBeforeForgetfulFunctorPattern(result);
        result.setForgetfulFunctorPattern(processForgetfulFunctorPattern(e.element("ForgetfulFunctor-Pattern")));
        actions.actionStructurePatternsRenderingAfterForgetfulFunctorPattern(result);

        actions.actionStructurePatternsRenderingBeforeStrictPattern(result);
        result.setStrictPattern(processStrictPattern(e.element("Strict-Pattern")));
        actions.actionStructurePatternsRenderingAfterStrictPattern(result);

        actions.actionStructurePatternsRenderingBeforeSelectorsList(result);
        result.setSelectorsList(processSelectorsList(e.element("Selectors-List")));
        actions.actionStructurePatternsRenderingAfterSelectorsList(result);

        return result;
    }

    private AggregateFunctorPattern processAggregateFunctorPattern(Element e) {
        AggregateFunctorPattern result = new AggregateFunctorPattern(e);

        actions.actionAggregateFunctorPatternBeforeLoci(result);
        result.setLoci(processLoci(e.element("Loci")));
        actions.actionAggregateFunctorPatternAfterLoci(result);

        return result;
    }

    private ForgetfulFunctorPattern processForgetfulFunctorPattern(Element e) {
        ForgetfulFunctorPattern result = new ForgetfulFunctorPattern(e);

        actions.actionForgetfulFunctorPatternBeforeLoci(result);
        result.setLoci(processLoci(e.element("Loci")));
        actions.actionForgetfulFunctorPatternAfterLoci(result);

        return result;
    }

    private StrictPattern processStrictPattern(Element e) {
        StrictPattern result = new StrictPattern(e);

        actions.actionStrictPatternBeforeLocus(result);
        result.setLocus(processLocus(e.element("Locus")));
        actions.actionStrictPatternAfterLocus(result);

        actions.actionStrictPatternBeforeLoci(result);
        result.setLoci(processLoci(e.element("Loci")));
        actions.actionStrictPatternAfterLoci(result);

        return result;
    }

    private SelectorFunctorPattern processSelectorFunctorPattern(Element e) {
        SelectorFunctorPattern result = new SelectorFunctorPattern(e);

        actions.actionSelectorFunctorPatternBeforeLoci(result);
        result.setLoci(processLoci(e.element("Loci")));
        actions.actionSelectorFunctorPatternAfterLoci(result);

        return result;
    }

    private SelectorsList processSelectorsList(Element e) {
        SelectorsList result = new SelectorsList(e);

        actions.actionSelectorsListBefore(result);
        for (Element element: e.elements())
            result.getSelectorFunctorPatterns().add(processSelectorFunctorPattern(element));
        actions.actionSelectorsListAfter(result);

        return result;
    }

    /* BLOCKS */

    private DefinitionalBlock processDefinitionalBlock(Element e) {
        DefinitionalBlock result = new DefinitionalBlock(e);
        actions.actionDefinitionalBlock(result);
        return result;
    }

    private NotationBlock processNotationBlock(Element e) {
        NotationBlock result = new NotationBlock(e);
        actions.actionNotationBlock(result);
        return result;
    }

    private RegistrationBlock processRegistrationBlock(Element e) {
        RegistrationBlock result = new RegistrationBlock(e);
        actions.actionRegistrationBlock(result);
        return result;
    }

    private SchemeBlock processSchemeBlock(Element e) {
        SchemeBlock result = new SchemeBlock(e);
        actions.actionSchemeBlock(result);
        return result;
    }

    private Block processBlock(Element e) {
        Block result = null;
        actions.actionBlockBefore(result);
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
        actions.actionBlockAfter(result);
        BlocksItems.lastItem().setBlock(result);
        return result;
    }

    private Item processItem(Element e) {
        Item result = null;
        actions.actionItemBefore(result);
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
            case "Loci-Declaration":
                result = processLociDeclaration(e);
                break;
            case "Mode-Definition":
                result = processModeDefinition(e);
                break;
            case "Mode-Synonym":
                result = processModeSynonym(e);
                break;
            case "Pragma":
                result = processPragma(e);
                break;
            case "Pred-Antonym":
                result = processPredAntonym(e);
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
            case "Scheme-Head":
                result = processSchemeHead(e);
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
        actions.actionItemAfter(result);
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
