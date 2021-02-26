package org.mizar.esx.actions;

import org.mizar.esx.article.*;

public interface Actions {

    default void actionCanceled(Canceled result) {
    }

    default void actionCollectiveAssumptionBeforeConditions(CollectiveAssumption result) {
    }

    default void actionCollectiveAssumptionAfterConditions(CollectiveAssumption result) {
    }

    default void actionSection(SectionPragma result) {
    }

    default void actionSimpleTerm(SimpleTerm result) {
    }

    default void actionTextProper(TextProper result) {
    }

    default void actionCompatibility(Compatibility result) {
    }

    default void actionConsistency(Consistency result) {
    }

    default void actionContradiction(Contradiction result) {
    }

    default void actionDefinitionItem(DefinitionItem result) {
    }

    default void actionExistence(Existence result) {
    }

    default void actionAdjectiveClusterBeforeAttributes(AdjectiveCluster result) {
    }

    default void actionAdjectiveClusterAfterAttributes(AdjectiveCluster result) {
    }

    default void actionArgumentsBeforeArguments(Arguments result) {
    }

    default void actionArgumentsAfterArguments(Arguments result) {
    }

    default void actionAssumptionBeforeAssumption(Assumption result) {
    }

    default void actionAssumptionAfterAssumption(Assumption result) {
    }

    default void actionAssumptionBeforeCollectiveAssumption(Assumption result) {
    }

    default void actionAssumptionAfterCollectiveAssumption(Assumption result) {
    }

    default void actionAssumptionBeforeSingleAssumption(Assumption result) {
    }

    default void actionAssumptionAfterSingleAssumption(Assumption result) {
    }

    default void actionAttrAntonymBeforePattern(AttrAntonym result) {
    }

    default void actionAttrAntonymAfterPattern(AttrAntonym result) {
    }

    default void actionAttrAntonymBeforeOriginal(AttrAntonym result) {
    }

    default void actionAttrAntonymAfterOriginal(AttrAntonym result) {
    }

    default void actionAttrSynonymBeforeSynonym(AttrSynonym result) {
    }

    default void actionAttrSynonymAfterSynonym(AttrSynonym result) {
    }

    default void actionAttrSynonymBeforeOriginal(AttrSynonym result) {
    }

    default void actionAttrSynonymAfterOriginal(AttrSynonym result) {
    }

    default void actionAttributeBeforeArguments(Attribute result) {
    }

    default void actionAttributeAfterArguments(Attribute result) {
    }

    default void actionAttributeDefinitionBeforeRedefine(AttributeDefinition result) {
    }

    default void actionAttributeDefinitionAfterRedefine(AttributeDefinition result) {
    }

    default void actionAttributeDefinitionBeforePattern(AttributeDefinition result) {
    }

    default void actionAttributeDefinitionAfterPattern(AttributeDefinition result) {
    }

    default void actionAttributeDefinitionBeforeDefiniens(AttributeDefinition result) {
    }

    default void actionAttributeDefinitionAfterDefiniens(AttributeDefinition result) {
    }

    default void actionBiconditionalFormulaBeforeArg1(BiconditionalFormula result) {
    }

    default void actionBiconditionalFormulaAfterArg1(BiconditionalFormula result) {
    }

    default void actionBiconditionalFormulaBeforeArg2(BiconditionalFormula result) {
    }

    default void actionBiconditionalFormulaAfterArg2(BiconditionalFormula result) {
    }

    default void actionBinaryFormulaBeforeArg1(BinaryFormula result) {
    }

    default void actionBinaryFormulaAfterArg1(BinaryFormula result) {
    }

    default void actionBinaryFormulaBeforeArg2(BinaryFormula result) {
    }

    default void actionBinaryFormulaAfterArg2(BinaryFormula result) {
    }

    default void actionCircumfixTermBeforeRightCircumflexSymbol(CircumfixTerm result) {
    }

    default void actionCircumfixTermAfterRightCircumflexSymbol(CircumfixTerm result) {
    }

    default void actionCircumfixTermBeforeArguments(CircumfixTerm result) {
    }

    default void actionCircumfixTermAfterArguments(CircumfixTerm result) {
    }

    default void actionClusterBeforeCluster(Cluster result) {
    }

    default void actionClusterAfterCluster(Cluster result) {
    }

    default void actionClusterBeforeConditionalRegistration(Cluster result) {
    }

    default void actionClusterAfterConditionalRegistration(Cluster result) {
    }

    default void actionClusterBeforeExistentialRegistration(Cluster result) {
    }

    default void actionClusterAfterExistentialRegistration(Cluster result) {
    }

    default void actionClusterBeforeFunctorialRegistration(Cluster result) {
    }

    default void actionClusterAfterFunctorialRegistration(Cluster result) {
    }

    default void actionClusteredTypeBeforeAdjectiveCluster(ClusteredType result) {
    }

    default void actionClusteredTypeAfterAdjectiveCluster(ClusteredType result) {
    }

    default void actionClusteredTypeBeforeType(ClusteredType result) {
    }

    default void actionClusteredTypeAfterType(ClusteredType result) {
    }

    default void actionCoherence(Coherence result) {
    }

    default void actionConditionalFormulaBeforeArg1(ConditionalFormula result) {
    }

    default void actionConditionalFormulaAfterArg1(ConditionalFormula result) {
    }

    default void actionConditionalFormulaBeforeArg2(ConditionalFormula result) {
    }

    default void actionConditionalFormulaAfterArg2(ConditionalFormula result) {
    }

    default void actionConditionalRegistrationBeforePredecessor(ConditionalRegistration result) {
    }

    default void actionConditionalRegistrationAfterPredecessor(ConditionalRegistration result) {
    }

    default void actionConditionalRegistrationBeforeSuccessor(ConditionalRegistration result) {
    }

    default void actionConditionalRegistrationAfterSuccessor(ConditionalRegistration result) {
    }

    default void actionConditionalRegistrationBeforeType(ConditionalRegistration result) {
    }

    default void actionConditionalRegistrationAfterType(ConditionalRegistration result) {
    }

    default void actionConditionsBeforePropositions(Conditions result) {
    }

    default void actionConditionsAfterPropositions(Conditions result) {
    }

    default void actionConjunctiveFormulaBeforeArg1(ConjunctiveFormula result) {
    }

    default void actionConjunctiveFormulaAfterArg1(ConjunctiveFormula result) {
    }

    default void actionConjunctiveFormulaBeforeArg2(ConjunctiveFormula result) {
    }

    default void actionConjunctiveFormulaAfterArg2(ConjunctiveFormula result) {
    }

    default void actionCorrectnessBeforeCorrectnessConditions(Correctness result) {
    }

    default void actionCorrectnessAfterCorrectnessConditions(Correctness result) {
    }

    default void actionCorrectnessBeforeJustification(Correctness result) {
    }

    default void actionCorrectnessAfterJustification(Correctness result) {
    }

    default void actionCorrectnessConditionBeforeCorrectnessCondition(CorrectnessCondition result) {
    }

    default void actionCorrectnessConditionAfterCorrectnessCondition(CorrectnessCondition result) {
    }

    default void actionCorrectnessConditionBeforeJustification(CorrectnessCondition result) {
    }

    default void actionCorrectnessConditionAfterJustification(CorrectnessCondition result) {
    }

    default void actionCorrectnessConditionsBeforeCorrectnessConditions(CorrectnessConditions result) {
    }

    default void actionCorrectnessConditionsAfterCorrectnessConditions(CorrectnessConditions result) {
    }

    default void actionDefiniensMeansBeforeFormula(DefiniensMeans result) {
    }

    default void actionDefiniensMeansAfterFormula(DefiniensMeans result) {
    }

    default void actionDefiniensMeansBeforePartialDefiniensList(DefiniensComplex result) {
    }

    default void actionDefiniensMeansAfterPartialDefiniensList(DefiniensComplex result) {
    }

    default void actionDefiniensMeansBeforeOtherwise(DefiniensComplex result) {
    }

    default void actionDefiniensMeansAfterOtherwise(DefiniensComplex result) {
    }

    default void actionDefiniensEqualsBeforeTerm(DefiniensEquals result) {
    }

    default void actionDefiniensEqualsAfterTerm(DefiniensEquals result) {
    }

    default void actionDefiniensEqualsBeforePartialDefiniensList(DefiniensComplex result) {
    }

    default void actionDefiniensEqualsAfterPartialDefiniensList(DefiniensComplex result) {
    }

    default void actionDefiniensEqualsBeforeOtherwise(DefiniensComplex result) {
    }

    default void actionDefiniensEqualsAfterOtherwise(DefiniensComplex result) {
    }

    default void actionDisjunctiveFormulaBeforeArg1(DisjunctiveFormula result) {
    }

    default void actionDisjunctiveFormulaAfterArg1(DisjunctiveFormula result) {
    }

    default void actionDisjunctiveFormulaBeforeArg2(DisjunctiveFormula result) {
    }

    default void actionDisjunctiveFormulaAfterArg2(DisjunctiveFormula result) {
    }

    default void actionExistentialAssumptionBeforeQualifiedSegments(ExistentialAssumption result) {
    }

    default void actionExistentialAssumptionAfterQualifiedSegments(ExistentialAssumption result) {
    }

    default void actionExistentialAssumptionBeforeConditions(ExistentialAssumption result) {
    }

    default void actionExistentialAssumptionAfterConditions(ExistentialAssumption result) {
    }

    default void actionExistentialQuantifierFormulaBeforeVariableSegments(ExistentialQuantifierFormula result) {
    }

    default void actionExistentialQuantifierFormulaAfterVariableSegments(ExistentialQuantifierFormula result) {
    }

    default void actionExistentialQuantifierFormulaBeforeScope(ExistentialQuantifierFormula result) {
    }

    default void actionExistentialQuantifierFormulaAfterScope(ExistentialQuantifierFormula result) {
    }

    default void actionExplicitlyQualifiedSegmentBeforeVariables(ExplicitlyQualifiedSegment result) {
    }

    default void actionExplicitlyQualifiedSegmentAfterVariables(ExplicitlyQualifiedSegment result) {
    }

    default void actionExplicitlyQualifiedSegmentBeforeType(ExplicitlyQualifiedSegment result) {
    }

    default void actionExplicitlyQualifiedSegmentAfterType(ExplicitlyQualifiedSegment result) {
    }

    default void actionExistentialRegistrationBeforeAdjectiveCluster(ExistentialRegistration result) {
    }

    default void actionExistentialRegistrationAfterAdjectiveCluster(ExistentialRegistration result) {
    }

    default void actionExistentialRegistrationBeforeType(ExistentialRegistration result) {
    }

    default void actionExistentialRegistrationAfterType(ExistentialRegistration result) {
    }

    default void actionExpandableModeBeforeType(ExpandableMode result) {
    }

    default void actionExpandableModeAfterType(ExpandableMode result) {
    }

    default void actionFlexaryConjunctiveFormulaBeforeArg1(FlexaryConjunctiveFormula result) {
    }

    default void actionFlexaryConjunctiveFormulaAfterArg1(FlexaryConjunctiveFormula result) {
    }

    default void actionFlexaryConjunctiveFormulaBeforeArg2(FlexaryConjunctiveFormula result) {
    }

    default void actionFlexaryConjunctiveFormulaAfterArg2(FlexaryConjunctiveFormula result) {
    }

    default void actioFlexaryDisjunctiveFormulaBeforeArg1(FlexaryDisjunctiveFormula result) {
    }

    default void actioFlexaryDisjunctiveFormulaAfterArg1(FlexaryDisjunctiveFormula result) {
    }

    default void actioFlexaryDisjunctiveFormulaBeforeArg2(FlexaryDisjunctiveFormula result) {
    }

    default void actioFlexaryDisjunctiveFormulaAfterArg2(FlexaryDisjunctiveFormula result) {
    }

    default void actionForgetfulFunctorTermBeforeTerm(ForgetfulFunctorTerm result) {
    }

    default void actionForgetfulFunctorTermAfterTerm(ForgetfulFunctorTerm result) {
    }

    default void actionFormulaInterfaceBefore(FormulaInterface result) {
    }

    default void actionFormulaInterfaceAfter(FormulaInterface result) {
    }

    default void actionFraenkelTermBeforeVariableSegments(FraenkelTerm result) {
    }

    default void actionFraenkelTermAfterVariableSegments(FraenkelTerm result) {
    }

    default void actionFraenkelTermBeforeTerm(FraenkelTerm result) {
    }

    default void actionFraenkelTermAfterTerm(FraenkelTerm result) {
    }

    default void actionFraenkelTermBeforeFormula(FraenkelTerm result) {
    }

    default void actionFraenkelTermAfterFormula(FraenkelTerm result) {
    }

    default void actionFreeVariableSegmentBeforeVariable(FreeVariableSegment result) {
    }

    default void actionFreeVariableSegmentAfterVariable(FreeVariableSegment result) {
    }

    default void actionFreeVariableSegmentBeforeType(FreeVariableSegment result) {
    }

    default void actionFreeVariableSegmentAfterType(FreeVariableSegment result) {
    }

    default void actionFuncSynonymBeforeSynonym(FuncSynonym result) {
    }

    default void actionFuncSynonymAfterSynonym(FuncSynonym result) {
    }

    default void actionFuncSynonymBeforeOriginal(FuncSynonym result) {
    }

    default void actionFuncSynonymAfterOriginal(FuncSynonym result) {
    }

    default void actionFunctorDefinitionBeforeRedefine(FunctorDefinition result) {
    }

    default void actionFunctorDefinitionAfterRedefine(FunctorDefinition result) {
    }

    default void actionFunctorDefinitionBeforePattern(FunctorDefinition result) {
    }

    default void actionFunctorDefinitionAfterPattern(FunctorDefinition result) {
    }

    default void actionFunctorDefinitionBeforeTypeSpecification(FunctorDefinition result) {
    }

    default void actionFunctorDefinitionAfterTypeSpecification(FunctorDefinition result) {
    }

    default void actionFunctorDefinitionBeforeDefiniens(FunctorDefinition result) {
    }

    default void actionFunctorDefinitionAfterDefiniens(FunctorDefinition result) {
    }

    default void actionFunctorialRegistrationBeforeTerm(FunctorialRegistration result) {
    }

    default void actionFunctorialRegistrationAfterTerm(FunctorialRegistration result) {
    }

    default void actionFunctorialRegistrationBeforeAdjectiveCluster(FunctorialRegistration result) {
    }

    default void actionFunctorialRegistrationAfterAdjectiveCluster(FunctorialRegistration result) {
    }

    default void actionFunctorialRegistrationBeforeType(FunctorialRegistration result) {
    }

    default void actionFunctorialRegistrationAfterType(FunctorialRegistration result) {
    }

    default void actionGlobalChoiceTermBeforeType(GlobalChoiceTerm result) {
    }

    default void actionGlobalChoiceTermAfterType(GlobalChoiceTerm result) {
    }

    default void actionIdentifyBeforeLeftPatternShapedExpression(Identify result) {
    }

    default void actionIdentifyAfterLeftPatternShapedExpression(Identify result) {
    }

    default void actionIdentifyBeforeRightPatternShapedExpression(Identify result) {
    }

    default void actionIdentifyAfterRightPatternShapedExpression(Identify result) {
    }

    default void actionIdentifyBeforeLociEqualities(Identify result) {
    }

    default void actionIdentifyAfterLociEqualities(Identify result) {
    }

    default void actionImplicitlyQualifiedSegmentBeforeVariable(ImplicitlyQualifiedSegment result) {
    }

    default void actionImplicitlyQualifiedSegmentAfterVariable(ImplicitlyQualifiedSegment result) {
    }

    default void actionImplicitlyQualifiedSegmentBeforeType(ImplicitlyQualifiedSegment result) {
    }

    default void actionImplicitlyQualifiedSegmentAfterType(ImplicitlyQualifiedSegment result) {
    }

    default void actionInfixTermBeforeArguments(InfixTerm result) {
    }

    default void actionInfixTermAfterArguments(InfixTerm result) {
    }

    default void actionInternalSelectorTerm(InternalSelectorTerm result) {
    }

    default void actionItTerm(ItTerm result) {
    }

    default void actionJustification(JustificationInterface result) {
    }

    default void actionLabel(Label result) {
    }

    default void actionLociBefore(Loci result) {
    }

    default void actionLociAfter(Loci result) {
    }

    default void actionLociDeclarationBeforeQualifiedSegments(LociDeclaration result) {
    }

    default void actionLociDeclarationAfterQualifiedSegments(LociDeclaration result) {
    }

    default void actionLociEqualitiesBefore(LociEqualities result) {
    }

    default void actionLociEqualitiesAfter(LociEqualities result) {
    }

    default void actionLociEqualityBeforeLocus_1(LociEquality result) {
    }

    default void actionLociEqualityAfterLocus_1(LociEquality result) {
    }

    default void actionLociEqualityBeforeLocus_2(LociEquality result) {
    }

    default void actionLociEqualityAfterLocus_2(LociEquality result) {
    }

    default void actionLocus(Locus result) {
    }

    default void actionModeDefinitionBeforeRedefine(ModeDefinition result) {
    }

    default void actionModeDefinitionAfterRedefine(ModeDefinition result) {
    }

    default void actionModeDefinitionBeforePattern(ModeDefinition result) {
    }

    default void actionModeDefinitionAfterPattern(ModeDefinition result) {
    }

    default void actionModeDefinitionBeforeModeDescription(ModeDefinition result) {
    }

    default void actionModeDefinitionAfterModeDescription(ModeDefinition result) {
    }

    default void actionModeDescriptionInterfaceBeforeStandardMode(ModeDescriptionInterface result) {
    }

    default void actionModeDescriptionInterfaceAfterStandardMode(ModeDescriptionInterface result) {
    }

    default void actionModeDescriptionInterfaceBeforeExpandableMode(ModeDescriptionInterface result) {
    }

    default void actionModeDescriptionInterfaceAfterExpandableMode(ModeDescriptionInterface result) {
    }

    default void actionModeSynonymBeforeSynonym(ModeSynonym result) {
    }

    default void actionModeSynonymAfterSynonym(ModeSynonym result) {
    }

    default void actionModeSynonymBeforeOriginal(ModeSynonym result) {
    }

    default void actionModeSynonymAfterOriginal(ModeSynonym result) {
    }

    default void actionMultiAttributiveFormulaBeforeTerm(MultiAttributiveFormula result) {
    }

    default void actionMultiAttributiveFormulaAfterTerm(MultiAttributiveFormula result) {
    }

    default void actionMultiAttributiveFormulaBeforeAdjectiveCluster(MultiAttributiveFormula result) {
    }

    default void actionMultiAttributiveFormulaAfterAdjectiveCluster(MultiAttributiveFormula result) {
    }

    default void actionMultiRelationFormulaBeforeFormula(MultiRelationFormula result) {
    }

    default void actionMultiRelationFormulaAfterFormula(MultiRelationFormula result) {
    }

    default void actionMultiRelationFormulaBeforeRightSideOfRelationFormula(MultiRelationFormula result) {
    }

    default void actionMultiRelationFormulaAfterRightSideOfRelationFormula(MultiRelationFormula result) {
    }

    default void actionNegatedFormulaBeforeArg(NegatedFormula result) {
    }

    default void actionNegatedFormulaAfterArg(NegatedFormula result) {
    }

    default void actionNotionName(NotionName result) {
    }

    default void actionNumeralTerm(NumeralTerm result) {
    }

    default void actionOtherwiseMeansBeforeFormula(OtherwiseMeans result) {
    }

    default void actionOtherwiseMeansAfterFormula(OtherwiseMeans result) {
    }

    default void actionOtherwiseEqualsBeforeTerm(OtherwiseEquals result) {
    }

    default void actionOtherwiseEqualsAfterTerm(OtherwiseEquals result) {
    }

    default void actionPartialDefiniensEqualsBeforeTerm(PartialDefiniensEquals result) {
    }

    default void actionPartialDefiniensEqualsAfterTerm(PartialDefiniensEquals result) {
    }

    default void actionPartialDefiniensEqualsBeforeGuard(PartialDefiniensEquals result) {
    }

    default void actionPartialDefiniensEqualsAfterGuard(PartialDefiniensEquals result) {
    }

    default void actionPartialDefiniensMeansBeforeFormula(PartialDefiniensMeans result) {
    }

    default void actionPartialDefiniensMeansAfterFormula(PartialDefiniensMeans result) {
    }

    default void actionPartialDefiniensMeansBeforeGuard(PartialDefiniensMeans result) {
    }

    default void actionPartialDefiniensMeansAfterGuard(PartialDefiniensMeans result) {
    }

    default void actionPartialDefiniensListBefore(PartialDefiniensList result) {
    }

    default void actionPartialDefiniensListAfter(PartialDefiniensList result) {
    }

    default void actionPartialDefiniensListBeforeDefiniensMeans(PartialDefiniensList result) {
    }

    default void actionPartialDefiniensListAfterDefiniensMeans(PartialDefiniensList result) {
    }

    default void actionPartialDefiniensListBeforeDefiniensEquals(PartialDefiniensList result) {
    }

    default void actionPartialDefiniensListAfterDefiniensEquals(PartialDefiniensList result) {
    }

    default void actionPatternShapedExpressionBeforePatter(PatternShapedExpression result) {
    }

    default void actionPatternShapedExpressionAfterPatter(PatternShapedExpression result) {
    }

    default void actionPragmaBefore(Pragma result) {
    }

    default void actionPragmaAfter(Pragma result) {
    }

    default void actionPredAntonymBeforeAntonym(PredAntonym result) {
    }

    default void actionPredAntonymAfterAntonym(PredAntonym result) {
    }

    default void actionPredAntonymBeforeOrginal(PredAntonym result) {
    }

    default void actionPredAntonymAfterOrginal(PredAntonym result) {
    }

    default void actionPredSynonymBeforePattern(PredSynonym result) {
    }

    default void actionPredSynonymAfterPattern(PredSynonym result) {
    }

    default void actionPredSynonymBeforeOriginal(PredSynonym result) {
    }

    default void actionPredSynonymAfterOriginal(PredSynonym result) {
    }

    default void actionPredicateDefinitionBeforeRedefine(PredicateDefinition result) {
    }

    default void actionPredicateDefinitionAfterRedefine(PredicateDefinition result) {
    }

    default void actionPredicateDefinitionBeforePattern(PredicateDefinition result) {
    }

    default void actionPredicateDefinitionAfterPattern(PredicateDefinition result) {
    }

    default void actionPredicateDefinitionBeforeDefiniens(PredicateDefinition result) {
    }

    default void actionPredicateDefinitionAfterDefiniens(PredicateDefinition result) {
    }

    default void actionPrivateFunctorTermBeforeArguments(PrivateFunctorTerm result) {
    }

    default void actionPrivateFunctorTermAfterArguments(PrivateFunctorTerm result) {
    }

    default void actionPrivatePredicateFormulaBeforeArguments(PrivatePredicateFormula result) {
    }

    default void actionPrivatePredicateFormulaAfterArguments(PrivatePredicateFormula result) {
    }

    default void actionPropertiesBeforeType(Properties result) {
    }

    default void actionPropertiesAfterType(Properties result) {
    }

    default void actionPropertyBeforeProperties(Property result) {
    }

    default void actionPropertyAfterProperties(Property result) {
    }

    default void actionPropertyBeforeJustification(Property result) {
    }

    default void actionPropertyAfterJustification(Property result) {
    }

    default void actionPropertyRegistrationBeforeProperties(PropertyRegistration result) {
    }

    default void actionPropertyRegistrationAfterProperties(PropertyRegistration result) {
    }

    default void actionPropertyRegistrationBeforeJustification(PropertyRegistration result) {
    }

    default void actionPropertyRegistrationAfterJustification(PropertyRegistration result) {
    }

    default void actionPropositionBeforeLabel(Proposition result) {
    }

    default void actionPropositionAfterLabel(Proposition result) {
    }

    default void actionPropositionBeforeFormula(Proposition result) {
    }

    default void actionPropositionAfterFormula(Proposition result) {
    }

    default void actionQualificationTermBeforeTerm(QualificationTerm result) {
    }

    default void actionQualificationTermAfterTerm(QualificationTerm result) {
    }

    default void actionQualificationTermBeforeType(QualificationTerm result) {
    }

    default void actionQualificationTermAfterType(QualificationTerm result) {
    }

    default void actionQualifiedSegmentsBefore(QualifiedSegments result) {
    }

    default void actionQualifiedSegmentsAfter(QualifiedSegments result) {
    }

    default void actionQualifyingFormulaBeforeTerm(QualifyingFormula result) {
    }

    default void actionQualifyingFormulaAfterTerm(QualifyingFormula result) {
    }

    default void actionQualifyingFormulaBeforeType(QualifyingFormula result) {
    }

    default void actionQualifyingFormulaAfterType(QualifyingFormula result) {
    }

    default void actionRedefine(Redefine result) {
    }

    default void actionReducibility(Reducibility result) {
    }

    default void actionReductionBeforeLeftTerm(Reduction result) {
    }

    default void actionReductionAfterLeftTerm(Reduction result) {
    }

    default void actionReductionBeforeRightTerm(Reduction result) {
    }

    default void actionReductionAfterRightTerm(Reduction result) {
    }

    default void actionRelationFormulaBeforeArguments(RelationFormula result) {
    }

    default void actionRelationFormulaAfterArguments(RelationFormula result) {
    }

    default void actionReservationBeforeReservationSegments(Reservation result) {
    }

    default void actionReservationAfterReservationSegments(Reservation result) {
    }

    default void actionReservationSegmentBeforeVariables(ReservationSegment result) {
    }

    default void actionReservationSegmentAfterVariables(ReservationSegment result) {
    }

    default void actionReservationSegmentBeforeVariableSegments(ReservationSegment result) {
    }

    default void actionReservationSegmentAfterVariableSegments(ReservationSegment result) {
    }

    default void actionReservationSegmentBeforeType(ReservationSegment result) {
    }

    default void actionReservationSegmentAfterType(ReservationSegment result) {
    }

    default void actionReservedDscrTypeBeforeSubstitutions(ReservedDscrType result) {
    }

    default void actionReservedDscrTypeAfterSubstitutions(ReservedDscrType result) {
    }

    default void actionReservedDscrTypeBeforeType(ReservedDscrType result) {
    }

    default void actionReservedDscrTypeAfterType(ReservedDscrType result) {
    }

    default void actionRestrictionBeforeFormula(Restriction result) {
    }

    default void actionRestrictionAfterFormula(Restriction result) {
    }

    default void actionRightCircumflexSymbol(RightCircumflexSymbol result) {
    }

    default void actionScopeBeforeFormula(Scope result) {
    }

    default void actionScopeAfterFormula(Scope result) {
    }

    default void actionRightSideOfRelationFormulaBeforeArguments(RightSideOfRelationFormula result) {
    }

    default void actionRightSideOfRelationFormulaAfterArguments(RightSideOfRelationFormula result) {
    }

    default void actionSimpleFraenkelTermBeforeVariableSegments(SimpleFraenkelTerm result) {
    }

    default void actionSimpleFraenkelTermAfterVariableSegments(SimpleFraenkelTerm result) {
    }

    default void actionSimpleFraenkelTermBeforeTerm(SimpleFraenkelTerm result) {
    }

    default void actionSimpleFraenkelTermAfterTerm(SimpleFraenkelTerm result) {
    }

    default void actionSingleAssumptionBeforeProposition(SingleAssumption result) {
    }

    default void actionSingleAssumptionAfterProposition(SingleAssumption result) {
    }

    default void actionStandardModeBeforeTypeSpecification(StandardMode result) {
    }

    default void actionStandardModeAfterTypeSpecification(StandardMode result) {
    }

    default void actionStandardModeBeforeDefiniens(StandardMode result) {
    }

    default void actionStandardModeAfterDefiniens(StandardMode result) {
    }

    default void actionStandardTypeBeforeArguments(StandardType result) {
    }

    default void actionStandardTypeAfterArguments(StandardType result) {
    }

    default void actionStructTypeBeforeArguments(StructType result) {
    }

    default void actionStructTypeAfterArguments(StructType result) {
    }

    default void actionTermInterfaceBefore(TermInterface result) {
    }

    default void actionTermInterfaceAfter(TermInterface result) {
    }

    default void actionTheoremItemBeforeProposition(TheoremItem result) {
    }

    default void actionTheoremItemAfterProposition(TheoremItem result) {
    }

    default void actionTheoremItemBeforeJustification(TheoremItem result) {
    }

    default void actionTheoremItemAfterJustification(TheoremItem result) {
    }

    default void actionTypeInterfaceBefore(TypeInterface result) {
    }

    default void actionTypeInterfaceAfter(TypeInterface result) {
    }

    default void actionTypeSpecificationBeforeType(TypeSpecification result) {
    }

    default void actionTypeSpecificationAfterType(TypeSpecification result) {
    }

    default void actionUniqueness(Uniqueness result) {
    }

    default void actionUniversalQuantifierFormulaBeforeVariableSegments(UniversalQuantifierFormula result) {
    }

    default void actionUniversalQuantifierFormulaAfterVariableSegments(UniversalQuantifierFormula result) {
    }

    default void actionUniversalQuantifierFormulaBeforeRestriction(UniversalQuantifierFormula result) {
    }

    default void actionUniversalQuantifierFormulaAfterRestriction(UniversalQuantifierFormula result) {
    }

    default void actionUniversalQuantifierFormulaBeforeScope(UniversalQuantifierFormula result) {
    }

    default void actionUniversalQuantifierFormulaAfterScope(UniversalQuantifierFormula result) {
    }

    default void actionUnknown(Unknown result) {
    }

    default void actionVariable(Variable result) {
    }

    default void actionVariablesBefore(Variables result) {
    }

    default void actionVariablesAfter(Variables result) {
    }

    default void actionVariableSegmentInterfaceBefore(VariableSegmentInterface result) {
    }

    default void actionVariableSegmentInterfaceAfter(VariableSegmentInterface result) {
    }

    default void actionVariableSegmentsBefore(VariableSegments result) {
    }

    default void actionVariableSegmentsAfter(VariableSegments result) {
    }

    default void actionSchemeBlockItem(SchemeBlockItem result) {
    }

    default void actionScheme(Scheme result) {
    }

    default void actionSchematicVariablesBefore(SchematicVariables result) {
    }

    default void actionSchematicVariablesAfter(SchematicVariables result) {
    }

    default void actionSchemeHeadBeforeScheme(SchemeHead result) {
    }

    default void actionSchemeHeadAfterScheme(SchemeHead result) {
    }

    default void actionSchemeHeadBeforeSchematicVariables(SchemeHead result) {
    }

    default void actionSchemeHeadAfterSchematicVariables(SchemeHead result) {
    }

    default void actionSchemeHeadBeforeFormula(SchemeHead result) {
    }

    default void actionSchemeHeadAfterFormula(SchemeHead result) {
    }

    default void actionSchemeHeadBeforeProvisionalFormulas(SchemeHead result) {
    }

    default void actionSchemeHeadAfterProvisionalFormulas(SchemeHead result) {
    }

    default void actionSchemaInputSegmentBeforeFunctorSegment(SchemaInputSegment result) {
    }

    default void actionSchemaInputSegmentAfterFunctorSegment(SchemaInputSegment result) {
    }

    default void actionSchemaInputSegmentBeforePredicateSegment(SchemaInputSegment result) {
    }

    default void actionSchemaInputSegmentAfterPredicateSegment(SchemaInputSegment result) {
    }

    default void actionFunctorSegmentBeforeVariables(FunctorSegment result) {
    }

    default void actionFunctorSegmentAfterVariables(FunctorSegment result) {
    }

    default void actionFunctorSegmentBeforeArgumentTypes(FunctorSegment result) {
    }

    default void actionFunctorSegmentAfterArgumentTypes(FunctorSegment result) {
    }

    default void actionFunctorSegmentBeforeResultType(FunctorSegment result) {
    }

    default void actionFunctorSegmentAfterResultType(FunctorSegment result) {
    }

    default void actionPredicateSegmentBeforeVariables(PredicateSegment result) {
    }

    default void actionPredicateSegmentAfterVariables(PredicateSegment result) {
    }

    default void actionPredicateSegmentBeforeArgumentTypes(PredicateSegment result) {
    }

    default void actionPredicateSegmentAfterArgumentTypes(PredicateSegment result) {
    }

    default void actionTypeListBefore(TypeList result) {
    }

    default void actionTypeListAfter(TypeList result) {
    }

    default void actionProvisionalFormulasBefore(ProvisionalFormulas result) {
    }

    default void actionProvisionalFormulasAfter(ProvisionalFormulas result) {
    }

    default void actionStructureDefinitionBeforeAncestors(StructureDefinition result) {
    }

    default void actionStructureDefinitionAfterAncestors(StructureDefinition result) {
    }

    default void actionStructureDefinitionBeforePattern(StructureDefinition result) {
    }

    default void actionStructureDefinitionAfterPattern(StructureDefinition result) {
    }

    default void actionStructureDefinitionBeforeFieldSegments(StructureDefinition result) {
    }

    default void actionStructureDefinitionAfterFieldSegments(StructureDefinition result) {
    }

    default void actionStructureDefinitionBeforeStructurePatternsRendering(StructureDefinition result) {
    }

    default void actionStructureDefinitionAfterStructurePatternsRendering(StructureDefinition result) {
    }

    default void actionAncestorsBefore(Ancestors result) {
    }

    default void actionAncestorsAfter(Ancestors result) {
    }

    default void actionAggregateTermBeforeArguments(AggregateTerm result) {
    }

    default void actionAggregateTermAfterArguments(AggregateTerm result) {
    }

    default void actionFieldSegmentBeforeSelectors(FieldSegment result) {
    }

    default void actionFieldSegmentAfterSelectors(FieldSegment result) {
    }

    default void actionFieldSegmentBeforeType(FieldSegment result) {
    }

    default void actionFieldSegmentAfterType(FieldSegment result) {
    }

    default void actionFieldSegmentsBefore(FieldSegments result) {
    }

    default void actionFieldSegmentsAfter(FieldSegments result) {
    }

    default void actionSelectorTermBeforeArgumen(SelectorTerm result) {
    }

    default void actionSelectorTermAfterArgumen(SelectorTerm result) {
    }

    default void actionSelectorBeforeLocus(Selector result) {
    }

    default void actionSelectorAfterLocus(Selector result) {
    }

    default void actionSelectorsBefore(Selectors result) {
    }

    default void actionSelectorsAfter(Selectors result) {
    }

    default void actionStructurePatternsRenderingBeforeAggregateFunctorPattern(StructurePatternsRendering result) {
    }

    default void actionStructurePatternsRenderingAfterAggregateFunctorPattern(StructurePatternsRendering result) {
    }

    default void actionStructurePatternsRenderingBeforeForgetfulFunctorPattern(StructurePatternsRendering result) {
    }

    default void actionStructurePatternsRenderingAfterForgetfulFunctorPattern(StructurePatternsRendering result) {
    }

    default void actionStructurePatternsRenderingBeforeStrictPattern(StructurePatternsRendering result) {
    }

    default void actionStructurePatternsRenderingAfterStrictPattern(StructurePatternsRendering result) {
    }

    default void actionStructurePatternsRenderingBeforeSelectorsList(StructurePatternsRendering result) {
    }

    default void actionStructurePatternsRenderingAfterSelectorsList(StructurePatternsRendering result) {
    }

    default void actionAggregateFunctorPatternBeforeLoci(AggregateFunctorPattern result) {
    }

    default void actionAggregateFunctorPatternAfterLoci(AggregateFunctorPattern result) {
    }

    default void actionForgetfulFunctorPatternBeforeLoci(ForgetfulFunctorPattern result) {
    }

    default void actionForgetfulFunctorPatternAfterLoci(ForgetfulFunctorPattern result) {
    }

    default void actionStrictPatternBeforeLocus(StrictPattern result) {
    }

    default void actionStrictPatternAfterLocus(StrictPattern result) {
    }

    default void actionStrictPatternBeforeLoci(StrictPattern result) {
    }

    default void actionStrictPatternAfterLoci(StrictPattern result) {
    }

    default void actionSelectorFunctorPatternBeforeLoci(SelectorFunctorPattern result) {
    }

    default void actionSelectorFunctorPatternAfterLoci(SelectorFunctorPattern result) {
    }

    default void actionSelectorsListBefore(SelectorsList result) {
    }

    default void actionSelectorsListAfter(SelectorsList result) {
    }

    default void actionDefinitionalBlock(DefinitionalBlock result) {
    }

    default void actionNotationBlock(NotationBlock result) {
    }

    default void actionRegistrationBlock(RegistrationBlock result) {
    }

    default void actionSchemeBlock(SchemeBlock result) {
    }

    default void actionBlockBefore(Block result) {
    }

    default void actionBlockAfter(Block result) {
    }

    default void actionItemBefore(Item result) {
    }

    default void actionItemAfter(Item result) {
    }

    default void actionPatternInterfaceBefore(PatternInterface result) {
    }

    default void actionPatternInterfaceAfter(PatternInterface result) {
    }

    default void actionAttributePatternBeforeSubject(AttributePattern result) {
    }

    default void actionAttributePatternAfterSubject(AttributePattern result) {
    }

    default void actionAttributePatternBeforeArguments(AttributePattern result) {
    }

    default void actionAttributePatternAfterArguments(AttributePattern result) {
    }

    default void actionCircumfixFunctorPatternBeforeRightCircumflexSymbol(CircumfixFunctorPattern result) {
    }

    default void actionCircumfixFunctorPatternAfterRightCircumflexSymbol(CircumfixFunctorPattern result) {
    }

    default void actionCircumfixFunctorPatternBeforeLoci(CircumfixFunctorPattern result) {
    }

    default void actionCircumfixFunctorPatternAfterLoci(CircumfixFunctorPattern result) {
    }

    default void actionInfixFunctorPatternBeforeLeftLoci(InfixFunctorPattern result) {
    }

    default void actionInfixFunctorPatternAfterLeftLoci(InfixFunctorPattern result) {
    }

    default void actionInfixFunctorPatternBeforeRightLoci(InfixFunctorPattern result) {
    }

    default void actionInfixFunctorPatternAfterRightLoci(InfixFunctorPattern result) {
    }

    default void actionModePatternBeforeLoci(ModePattern result) {
    }

    default void actionModePatternAfterLoci(ModePattern result) {
    }

    default void actionPredicatePatternBeforeLeftLoci(PredicatePattern result) {
    }

    default void actionPredicatePatternAfterLeftLoci(PredicatePattern result) {
    }

    default void actionPredicatePatternBeforeRightLoci(PredicatePattern result) {
    }

    default void actionPredicatePatternAfterRightLoci(PredicatePattern result) {
    }

    default void actionStructurePatternBeforeLoci(PatternInterface result) {
    }

    default void actionStructurePatternAfterLoci(PatternInterface result) {
    }

    default void actionSubstitution(Substitution result) {
    }

    default void actionSubstitutionsBefore(Substitutions result) {
    }

    default void actionSubstitutionsAfter(Substitutions result) {
    }
}
