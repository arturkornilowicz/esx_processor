package org.mizar.esx.design;

import org.mizar.esx.Misc;
import org.mizar.esx.article.*;
import org.dom4j.Element;
import org.mizar.esx.errors.Errors;

public class EsxElementFactory {

    public static EsxElement create(Element e) {

        if (e == null)
            return null;

        EsxElement result = null;

        switch (Misc.normalizeName(e.getName())) {
            case "AdjectiveCluster":
                result = new AdjectiveCluster(e);
                break;
            case "AggregateTerm":
                result = new AggregateTerm(e);
                break;
            case "AggregateFunctorPattern":
                result = new AggregateFunctorPattern(e);
                break;
            case "Ancestors":
                result = new Ancestors(e);
                break;
            case "Arguments":
                result = new Arguments(e);
                break;
            case "Assumption":
                result = new Assumption(e);
                break;
            case "AttrAntonym":
                result = new AttrAntonym(e);
                break;
            case "AttrSynonym":
                result = new AttrSynonym(e);
                break;
            case "Attribute":
                result = new Attribute(e);
                break;
            case "AttributeDefinition":
                result = new AttributeDefinition(e);
                break;
            case "AttributePattern":
                result = new AttributePattern(e);
                break;
            case "BiconditionalFormula":
                result = new BiconditionalFormula(e);
                break;
            case "Block":
                result = new Block(e);
                break;
            case "Canceled":
                result = new Canceled(e);
                break;
            case "CaseBlock":
                result = new CaseBlock(e);
                break;
            case "CaseHead":
                result = new CaseHead(e);
                break;
            case "ChoiceStatement":
                result = new ChoiceStatement(e);
                break;
            case "CircumfixTerm":
                result = new CircumfixTerm(e);
                break;
            case "CircumfixFunctorPattern":
                result = new CircumfixFunctorPattern(e);
                break;
            case "Cluster":
                result = new Cluster(e);
                break;
            case "ClusteredType":
                result = new ClusteredType(e);
                break;
            case "CollectiveAssumption":
                result = new CollectiveAssumption(e);
                break;
            case "Conclusion":
                result = new Conclusion(e);
                break;
            case "ConditionalFormula":
                result = new ConditionalFormula(e);
                break;
            case "ConditionalRegistration":
                result = new ConditionalRegistration(e);
                break;
            case "Conditions":
                result = new Conditions(e);
                break;
            case "ConjunctiveFormula":
                result = new ConjunctiveFormula(e);
                break;
            case "ConstantDefinition":
                result = new ConstantDefinition(e);
                break;
            case "Contradiction":
                result = new Contradiction(e);
                break;
            case "Correctness":
                result = new Correctness(e);
                break;
            case "CorrectnessCondition":
                result = new CorrectnessCondition(e);
                break;
            case "CorrectnessConditions":
                result = new CorrectnessConditions(e);
                break;
            case "DefaultGeneralization":
                result = new DefaultGeneralization(e);
                break;
            case "Definiens":
                result = new Definiens(e);
                break;
            case "DefinitionItem":
                result = new DefinitionItem(e);
                break;
            case "DefinitionReference":
                result = new DefinitionReference(e);
                break;
            case "DiffuseStatement":
                result = new DiffuseStatement(e);
                break;
            case "DisjunctiveFormula":
                result = new DisjunctiveFormula(e);
                break;
            case "EqualitiesList":
                result = new EqualitiesList(e);
                break;
            case "Equality":
                result = new Equality(e);
                break;
            case "EqualityToItself":
                result = new EqualityToItself(e);
                break;
            case "Equating":
                result = new Equating(e);
                break;
            case "Example":
                result = new Example(e);
                break;
            case "Exemplification":
                result = new Exemplification(e);
                break;
            case "ExemplifyingVariable":
                result = new ExemplifyingVariable(e);
                break;
            case "ExistentialAssumption":
                result = new ExistentialAssumption(e);
                break;
            case "ExistentialQuantifierFormula":
                result = new ExistentialQuantifierFormula(e);
                break;
            case "ExistentialRegistration":
                result = new ExistentialRegistration(e);
                break;
            case "ExpandableMode":
                result = new ExpandableMode(e);
                break;
            case "ExplicitlyQualifiedSegment":
                result = new ExplicitlyQualifiedSegment(e);
                break;
            case "FieldSegment":
                result = new FieldSegment(e);
                break;
            case "FieldSegments":
                result = new FieldSegments(e);
                break;
            case "FlexaryConjunctiveFormula":
                result = new FlexaryConjunctiveFormula(e);
                break;
            case "FlexaryDisjunctiveFormula":
                result = new FlexaryDisjunctiveFormula(e);
                break;
            case "ForgetfulFunctorTerm":
                result = new ForgetfulFunctorTerm(e);
                break;
            case "ForgetfulFunctorPattern":
                result = new ForgetfulFunctorPattern(e);
                break;
            case "FraenkelTerm":
                result = new FraenkelTerm(e);
                break;
            case "FreeVariableSegment":
                result = new FreeVariableSegment(e);
                break;
            case "FuncSynonym":
                result = new FuncSynonym(e);
                break;
            case "FunctorDefinition":
                result = new FunctorDefinition(e);
                break;
            case "FunctorSegment":
                result = new FunctorSegment(e);
                break;
            case "FunctorialRegistration":
                result = new FunctorialRegistration(e);
                break;
            case "Generalization":
                result = new Generalization(e);
                break;
            case "GlobalChoiceTerm":
                result = new GlobalChoiceTerm(e);
                break;
            case "Identify":
                result = new Identify(e);
                break;
            case "ImplicitExemplification":
                result = new ImplicitExemplification(e);
                break;
            case "ImplicitlyQualifiedSegment":
                result = new ImplicitlyQualifiedSegment(e);
                break;
            case "InfixTerm":
                result = new InfixTerm(e);
                break;
            case "InfixFunctorPattern":
                result = new InfixFunctorPattern(e);
                break;
            case "InternalSelectorTerm":
                result = new InternalSelectorTerm(e);
                break;
            case "Item":
                result = new Item(e);
                break;
            case "IterativeEquality":
                result = new IterativeEquality(e);
                break;
            case "IterativeStep":
                result = new IterativeStep(e);
                break;
            case "Label":
                result = new Label(e);
                break;
            case "Link":
                result = new Link(e);
                break;
            case "LocalReference":
                result = new LocalReference(e);
                break;
            case "Loci":
                result = new Loci(e);
                break;
            case "LociDeclaration":
                result = new LociDeclaration(e);
                break;
            case "LociEqualities":
                result = new LociEqualities(e);
                break;
            case "LociEquality":
                result = new LociEquality(e);
                break;
            case "Locus":
                result = new Locus(e);
                break;
            case "ModeDefinition":
                result = new ModeDefinition(e);
                break;
            case "ModePattern":
                result = new ModePattern(e);
                break;
            case "ModeSynonym":
                result = new ModeSynonym(e);
                break;
            case "MultiAttributiveFormula":
                result = new MultiAttributiveFormula(e);
                break;
            case "MultiRelationFormula":
                result = new MultiRelationFormula(e);
                break;
            case "NegatedFormula":
                result = new NegatedFormula(e);
                break;
            case "NotionName":
                result = new NotionName(e);
                break;
            case "NumeralTerm":
                result = new NumeralTerm(e);
                break;
            case "Otherwise":
                result = new Otherwise(e);
                break;
            case "PartialDefiniens":
                result = new PartialDefiniens(e);
                break;
            case "PatternShapedExpression":
                result = new PatternShapedExpression(e);
                break;
            case "PerCases":
                result = new PerCases(e);
                break;
            case "PlaceholderTerm":
                result = new PlaceholderTerm(e);
                break;
            case "Pragma":
                result = new Pragma(e);
                break;
            case "PredAntonym":
                result = new PredAntonym(e);
                break;
            case "PredSynonym":
                result = new PredSynonym(e);
                break;
            case "PredicateDefinition":
                result = new PredicateDefinition(e);
                break;
            case "PredicatePattern":
                result = new PredicatePattern(e);
                break;
            case "PredicateSegment":
                result = new PredicateSegment(e);
                break;
            case "PrivateFunctorDefinition":
                result = new PrivateFunctorDefinition(e);
                break;
            case "PrivateFunctorTerm":
                result = new PrivateFunctorTerm(e);
                break;
            case "PrivatePredicateDefinition":
                result = new PrivatePredicateDefinition(e);
                break;
            case "PrivatePredicateFormula":
                result = new PrivatePredicateFormula(e);
                break;
            case "Properties":
                result = new Properties(e);
                break;
            case "Property":
                result = new Property(e);
                break;
            case "PropertyRegistration":
                result = new PropertyRegistration(e);
                break;
            case "Proposition":
                result = new Proposition(e);
                break;
            case "ProvisionalFormulas":
                result = new ProvisionalFormulas(e);
                break;
            case "QualificationTerm":
                result = new QualificationTerm(e);
                break;
            case "QualifiedSegments":
                result = new QualifiedSegments(e);
                break;
            case "QualifyingFormula":
                result = new QualifyingFormula(e);
                break;
            case "Redefine":
                result = new Redefine(e);
                break;
            case "Reduction":
                result = new Reduction(e);
                break;
            case "RegularStatement":
                result = new RegularStatement(e);
                break;
            case "RelationFormula":
                result = new RelationFormula(e);
                break;
            case "Reservation":
                result = new Reservation(e);
                break;
            case "ReservationSegment":
                result = new ReservationSegment(e);
                break;
            case "ReservedDscrType":
                result = new ReservedDscrType(e);
                break;
            case "Restriction":
                result = new Restriction(e);
                break;
            case "RightCircumflexSymbol":
                result = new RightCircumflexSymbol(e);
                break;
            case "RightSideOfRelationFormula":
                result = new RightSideOfRelationFormula(e);
                break;
            case "SchematicVariables":
                result = new SchematicVariables(e);
                break;
            case "Scheme":
                result = new Scheme(e);
                break;
            case "SchemeBlockItem":
                result = new SchemeBlockItem(e);
                break;
            case "SchemeHead":
                result = new SchemeHead(e);
                break;
            case "SchemeJustification":
                result = new SchemeJustification(e);
                break;
            case "Scope":
                result = new Scope(e);
                break;
            case "SectionPragma":
                result = new SectionPragma(e);
                break;
            case "Selector":
                result = new Selector(e);
                break;
            case "SelectorTerm":
                result = new SelectorTerm(e);
                break;
            case "SelectorFunctorPattern":
                result = new SelectorFunctorPattern(e);
                break;
            case "Selectors":
                result = new Selectors(e);
                break;
            case "SelectorsList":
                result = new SelectorsList(e);
                break;
            case "SimpleFraenkelTerm":
                result = new SimpleFraenkelTerm(e);
                break;
            case "SimpleTerm":
                result = new SimpleTerm(e);
                break;
            case "SingleAssumption":
                result = new SingleAssumption(e);
                break;
            case "StandardMode":
                result = new StandardMode(e);
                break;
            case "StandardType":
                result = new StandardType(e);
                break;
            case "StraightforwardJustification":
                result = new StraightforwardJustification(e);
                break;
            case "StrictPattern":
                result = new StrictPattern(e);
                break;
            case "StructType":
                result = new StructType(e);
                break;
            case "StructureDefinition":
                result = new StructureDefinition(e);
                break;
            case "StructurePattern":
                result = new StructurePattern(e);
                break;
            case "StructurePatternsRendering":
                result = new StructurePatternsRendering(e);
                break;
            case "Substitution":
                result = new Substitution(e);
                break;
            case "Substitutions":
                result = new Substitutions(e);
                break;
            case "SupposeHead":
                result = new SupposeHead(e);
                break;
            case "TextProper":
                result = new TextProper(e);
                break;
            case "TheoremItem":
                result = new TheoremItem(e);
                break;
            case "TheoremReference":
                result = new TheoremReference(e);
                break;
            case "Thesis":
                result = new Thesis(e);
                break;
            case "TypeChangingStatement":
                result = new TypeChangingStatement(e);
                break;
            case "TypeList":
                result = new TypeList(e);
                break;
            case "TypeSpecification":
                result = new TypeSpecification(e);
                break;
            case "UniversalQuantifierFormula":
                result = new UniversalQuantifierFormula(e);
                break;
            case "Unknown":
                result = new Unknown(e);
                break;
            case "Variable":
                result = new Variable(e);
                break;
            case "VariableSegments":
                result = new VariableSegments(e);
                break;
            case "Variables":
                result = new Variables(e);
                break;
            case "Coherence":
                result = new Coherence(e);
                break;
            case "Compatibility":
                result = new Compatibility(e);
                break;
            case "Consistency":
                result = new Consistency(e);
                break;
            case "Existence":
                result = new Existence(e);
                break;
            case "ItTerm":
                result = new ItTerm(e);
                break;
            case "Reducibility":
                result = new Reducibility(e);
                break;
            case "Uniqueness":
                result = new Uniqueness(e);
                break;
            default:
                Errors.error(e, "Unknown Argument of Factory");
                throw new IllegalArgumentException("Unknown Argument of Factory");
        }
        result.before();
        result.process();
//        System.out.println("FACTORY RESULT of " + e.getName() + " is " + result );
        return result;
    }

    public static EsxElement create(Element e, String... attrs) {

        if (e == null)
            return null;

        EsxElement result = null;
        Element elem0 = e.elements().size() > 0 ? e.elements().get(0) : null;

        switch (Misc.normalizeName(e.getName())) {
            case "Definiens":
                if (e.attributeValue(attrs[0]).equals("Formula-Expression") && e.attributeValue(attrs[1]).equals("Simple-Definiens"))
                    result = new StandardDefiniens(elem0);
                else if (e.attributeValue(attrs[0]).equals("Formula-Expression") && e.attributeValue(attrs[1]).equals("Conditional-Definiens"))
                    result = new DefiniensMeansComplex(elem0);
                else if (e.attributeValue(attrs[0]).equals("Term-Expression") && e.attributeValue(attrs[1]).equals("Simple-Definiens"))
                    result = new DefiniensViaEquals(elem0);
                else if (e.attributeValue(attrs[0]).equals("Term-Expression") && e.attributeValue(attrs[1]).equals("Conditional-Definiens"))
                    result = new DefiniensEqualsComplex(elem0);
                break;
            case "Otherwise":
                if (e.getParent().getParent().attributeValue(attrs[0]).equals("Formula-Expression"))
                    result = new OtherwiseMeans(e);
                else if (e.getParent().getParent().attributeValue(attrs[0]).equals("Term-Expression"))
                    result = new OtherwiseEquals(e);
                break;
            case "PartialDefiniens":
                if (e.getParent().getParent().getParent().attributeValue(attrs[0]).equals("Formula-Expression"))
                    result = new PartialDefiniensMeans(e);
                else if (e.getParent().getParent().getParent().attributeValue(attrs[0]).equals("Term-Expression"))
                    result = new PartialDefiniensEquals(e);
                break;
            case "PartialDefiniensList":
                if (e.getParent().getParent().attributeValue(attrs[0]).equals("Formula-Expression"))
                    result = new PartialDefiniensListMeans(e);
                else if (e.getParent().getParent().attributeValue(attrs[0]).equals("Term-Expression"))
                    result = new PartialDefiniensListEquals(e);
                break;
            default:
                Errors.error(e, "Unknown Argument of Factory 2");
                throw new IllegalArgumentException("Unknown Argument of Factory 2");
        }

        if (result != null)
            result.process();
        return result;
    }
}