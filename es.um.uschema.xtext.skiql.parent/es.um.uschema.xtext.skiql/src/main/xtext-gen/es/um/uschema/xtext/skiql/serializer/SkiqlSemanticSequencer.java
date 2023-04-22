/*
 * generated by Xtext 2.29.0
 */
package es.um.uschema.xtext.skiql.serializer;

import com.google.inject.Inject;
import es.um.uschema.xtext.skiql.After;
import es.um.uschema.xtext.skiql.AggregationSpec;
import es.um.uschema.xtext.skiql.Before;
import es.um.uschema.xtext.skiql.Between;
import es.um.uschema.xtext.skiql.DateTime;
import es.um.uschema.xtext.skiql.EntityExpression;
import es.um.uschema.xtext.skiql.EntitySpec;
import es.um.uschema.xtext.skiql.KeysSpec;
import es.um.uschema.xtext.skiql.PrimitiveType;
import es.um.uschema.xtext.skiql.PropertySpec;
import es.um.uschema.xtext.skiql.ReferenceSpec;
import es.um.uschema.xtext.skiql.RelationSpec;
import es.um.uschema.xtext.skiql.RelationshipExpression;
import es.um.uschema.xtext.skiql.RelationshipQuery;
import es.um.uschema.xtext.skiql.RelationshipSpec;
import es.um.uschema.xtext.skiql.RelationshipType;
import es.um.uschema.xtext.skiql.RelationshipTypeSpec;
import es.um.uschema.xtext.skiql.SchemaQuery;
import es.um.uschema.xtext.skiql.SchemaSpec;
import es.um.uschema.xtext.skiql.SkiQLModel;
import es.um.uschema.xtext.skiql.SkiQLPackage;
import es.um.uschema.xtext.skiql.VariationFilter;
import es.um.uschema.xtext.skiql.services.SkiqlGrammarAccess;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;

@SuppressWarnings("all")
public class SkiqlSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private SkiqlGrammarAccess grammarAccess;
	
	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == SkiQLPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case SkiQLPackage.AFTER:
				sequence_AfterHistory(context, (After) semanticObject); 
				return; 
			case SkiQLPackage.AGGREGATION_SPEC:
				if (rule == grammarAccess.getRelationTypeSpecRule()
						|| rule == grammarAccess.getAggregationSpecRule()) {
					sequence_AggregationSpec(context, (AggregationSpec) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getIndirectRelationTypeSpecRule()
						|| rule == grammarAccess.getIndirectAggregationSpecRule()) {
					sequence_IndirectAggregationSpec(context, (AggregationSpec) semanticObject); 
					return; 
				}
				else break;
			case SkiQLPackage.BEFORE:
				sequence_BeforeHistory(context, (Before) semanticObject); 
				return; 
			case SkiQLPackage.BETWEEN:
				sequence_BetweenHistory(context, (Between) semanticObject); 
				return; 
			case SkiQLPackage.DATE_TIME:
				sequence_DateTime(context, (DateTime) semanticObject); 
				return; 
			case SkiQLPackage.ENTITY_EXPRESSION:
				sequence_EntityExpression(context, (EntityExpression) semanticObject); 
				return; 
			case SkiQLPackage.ENTITY_SPEC:
				if (rule == grammarAccess.getEntitySpecRule()) {
					sequence_EntitySpec(context, (EntitySpec) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getReferenceEntitySpecRule()) {
					sequence_ReferenceEntitySpec(context, (EntitySpec) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getToReferenceEntitySpecRule()) {
					sequence_ToReferenceEntitySpec(context, (EntitySpec) semanticObject); 
					return; 
				}
				else break;
			case SkiQLPackage.KEYS_SPEC:
				sequence_KeysSpec(context, (KeysSpec) semanticObject); 
				return; 
			case SkiQLPackage.PRIMITIVE_TYPE:
				sequence_PrimitiveType(context, (PrimitiveType) semanticObject); 
				return; 
			case SkiQLPackage.PROPERTY_SPEC:
				if (rule == grammarAccess.getPropertySpecRule()) {
					sequence_PropertySpec(context, (PropertySpec) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getReferencePropertySpecRule()) {
					sequence_ReferencePropertySpec(context, (PropertySpec) semanticObject); 
					return; 
				}
				else break;
			case SkiQLPackage.REFERENCE_SPEC:
				if (rule == grammarAccess.getIndirectRelationTypeSpecRule()
						|| rule == grammarAccess.getIndirectReferenceSpecRule()) {
					sequence_IndirectReferenceSpec(context, (ReferenceSpec) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getRelationTypeSpecRule()
						|| rule == grammarAccess.getReferenceSpecRule()) {
					sequence_ReferenceSpec(context, (ReferenceSpec) semanticObject); 
					return; 
				}
				else break;
			case SkiQLPackage.RELATION_SPEC:
				sequence_RelationSpec(context, (RelationSpec) semanticObject); 
				return; 
			case SkiQLPackage.RELATIONSHIP_EXPRESSION:
				sequence_RelationshipExpression(context, (RelationshipExpression) semanticObject); 
				return; 
			case SkiQLPackage.RELATIONSHIP_QUERY:
				if (rule == grammarAccess.getNestedRelationshipQueryRule()) {
					sequence_NestedRelationshipQuery(context, (RelationshipQuery) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getQueryRule()
						|| rule == grammarAccess.getRelationshipQueryRule()) {
					sequence_RelationshipQuery(context, (RelationshipQuery) semanticObject); 
					return; 
				}
				else break;
			case SkiQLPackage.RELATIONSHIP_SPEC:
				if (rule == grammarAccess.getIndirectRelationshipSpecRule()) {
					sequence_IndirectRelationshipSpec(context, (RelationshipSpec) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getRelationshipSpecRule()) {
					sequence_RelationshipSpec(context, (RelationshipSpec) semanticObject); 
					return; 
				}
				else break;
			case SkiQLPackage.RELATIONSHIP_TYPE:
				sequence_RelationshipType(context, (RelationshipType) semanticObject); 
				return; 
			case SkiQLPackage.RELATIONSHIP_TYPE_SPEC:
				sequence_RelationshipTypeSpec(context, (RelationshipTypeSpec) semanticObject); 
				return; 
			case SkiQLPackage.SCHEMA_QUERY:
				if (rule == grammarAccess.getQueryRule()) {
					sequence_AnyQuery_EntityTypeQuery_RelationshipTypeQuery(context, (SchemaQuery) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getAnyQueryRule()) {
					sequence_AnyQuery(context, (SchemaQuery) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getEntityTypeQueryRule()) {
					sequence_EntityTypeQuery(context, (SchemaQuery) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getRelationshipTypeQueryRule()) {
					sequence_RelationshipTypeQuery(context, (SchemaQuery) semanticObject); 
					return; 
				}
				else break;
			case SkiQLPackage.SCHEMA_SPEC:
				sequence_SchemaTypeSpec(context, (SchemaSpec) semanticObject); 
				return; 
			case SkiQLPackage.SKI_QL_MODEL:
				sequence_SkiQLModel(context, (SkiQLModel) semanticObject); 
				return; 
			case SkiQLPackage.VARIATION_FILTER:
				if (rule == grammarAccess.getReferenceVariationFilterRule()) {
					sequence_ReferenceVariationFilter(context, (VariationFilter) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getVariationFilterRule()) {
					sequence_VariationFilter(context, (VariationFilter) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * <pre>
	 * Contexts:
	 *     Operation returns After
	 *     VersionHistory returns After
	 *     AfterHistory returns After
	 *
	 * Constraint:
	 *     dateTime=DateTime
	 * </pre>
	 */
	protected void sequence_AfterHistory(ISerializationContext context, After semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, SkiQLPackage.Literals.AFTER__DATE_TIME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SkiQLPackage.Literals.AFTER__DATE_TIME));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getAfterHistoryAccess().getDateTimeDateTimeParserRuleCall_3_0(), semanticObject.getDateTime());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     RelationTypeSpec returns AggregationSpec
	 *     AggregationSpec returns AggregationSpec
	 *
	 * Constraint:
	 *     name=ID?
	 * </pre>
	 */
	protected void sequence_AggregationSpec(ISerializationContext context, AggregationSpec semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Query returns SchemaQuery
	 *
	 * Constraint:
	 *     (
	 *         (schemaSpec=EntitySpec operation=Operation?) | 
	 *         (schemaSpec=RelationshipTypeSpec operation=Operation?) | 
	 *         (schemaSpec=SchemaTypeSpec operation=Operation?)
	 *     )
	 * </pre>
	 */
	protected void sequence_AnyQuery_EntityTypeQuery_RelationshipTypeQuery(ISerializationContext context, SchemaQuery semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     AnyQuery returns SchemaQuery
	 *
	 * Constraint:
	 *     (schemaSpec=SchemaTypeSpec operation=Operation?)
	 * </pre>
	 */
	protected void sequence_AnyQuery(ISerializationContext context, SchemaQuery semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Operation returns Before
	 *     VersionHistory returns Before
	 *     BeforeHistory returns Before
	 *
	 * Constraint:
	 *     dateTime=DateTime
	 * </pre>
	 */
	protected void sequence_BeforeHistory(ISerializationContext context, Before semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, SkiQLPackage.Literals.BEFORE__DATE_TIME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SkiQLPackage.Literals.BEFORE__DATE_TIME));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getBeforeHistoryAccess().getDateTimeDateTimeParserRuleCall_3_0(), semanticObject.getDateTime());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Operation returns Between
	 *     VersionHistory returns Between
	 *     BetweenHistory returns Between
	 *
	 * Constraint:
	 *     (afterDateTime=DateTime beforeDateTime=DateTime)
	 * </pre>
	 */
	protected void sequence_BetweenHistory(ISerializationContext context, Between semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, SkiQLPackage.Literals.BETWEEN__AFTER_DATE_TIME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SkiQLPackage.Literals.BETWEEN__AFTER_DATE_TIME));
			if (transientValues.isValueTransient(semanticObject, SkiQLPackage.Literals.BETWEEN__BEFORE_DATE_TIME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SkiQLPackage.Literals.BETWEEN__BEFORE_DATE_TIME));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getBetweenHistoryAccess().getAfterDateTimeDateTimeParserRuleCall_3_0(), semanticObject.getAfterDateTime());
		feeder.accept(grammarAccess.getBetweenHistoryAccess().getBeforeDateTimeDateTimeParserRuleCall_5_0(), semanticObject.getBeforeDateTime());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     DateTime returns DateTime
	 *
	 * Constraint:
	 *     (year=INT month=INT day=INT (hour=INT minutes=INT seconds=INT)?)
	 * </pre>
	 */
	protected void sequence_DateTime(ISerializationContext context, DateTime semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     TargetExpression returns EntityExpression
	 *     EntityExpression returns EntityExpression
	 *
	 * Constraint:
	 *     entitySpec=ToReferenceEntitySpec
	 * </pre>
	 */
	protected void sequence_EntityExpression(ISerializationContext context, EntityExpression semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, SkiQLPackage.Literals.ENTITY_EXPRESSION__ENTITY_SPEC) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SkiQLPackage.Literals.ENTITY_EXPRESSION__ENTITY_SPEC));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getEntityExpressionAccess().getEntitySpecToReferenceEntitySpecParserRuleCall_1_0(), semanticObject.getEntitySpec());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     EntitySpec returns EntitySpec
	 *
	 * Constraint:
	 *     ((name=ID | name='*') variationFilter=VariationFilter?)
	 * </pre>
	 */
	protected void sequence_EntitySpec(ISerializationContext context, EntitySpec semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     EntityTypeQuery returns SchemaQuery
	 *
	 * Constraint:
	 *     (schemaSpec=EntitySpec operation=Operation?)
	 * </pre>
	 */
	protected void sequence_EntityTypeQuery(ISerializationContext context, SchemaQuery semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     IndirectRelationTypeSpec returns AggregationSpec
	 *     IndirectAggregationSpec returns AggregationSpec
	 *
	 * Constraint:
	 *     {AggregationSpec}
	 * </pre>
	 */
	protected void sequence_IndirectAggregationSpec(ISerializationContext context, AggregationSpec semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     IndirectRelationTypeSpec returns ReferenceSpec
	 *     IndirectReferenceSpec returns ReferenceSpec
	 *
	 * Constraint:
	 *     {ReferenceSpec}
	 * </pre>
	 */
	protected void sequence_IndirectReferenceSpec(ISerializationContext context, ReferenceSpec semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     IndirectRelationshipSpec returns RelationshipSpec
	 *
	 * Constraint:
	 *     (indirect?='&gt;&gt;' targetExpression=TargetExpression relationSpec=IndirectRelationTypeSpec?)
	 * </pre>
	 */
	protected void sequence_IndirectRelationshipSpec(ISerializationContext context, RelationshipSpec semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Operation returns KeysSpec
	 *     KeysSpec returns KeysSpec
	 *
	 * Constraint:
	 *     {KeysSpec}
	 * </pre>
	 */
	protected void sequence_KeysSpec(ISerializationContext context, KeysSpec semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     NestedRelationshipQuery returns RelationshipQuery
	 *
	 * Constraint:
	 *     (
	 *         from=ReferenceEntitySpec 
	 *         (to+=RelationshipSpec | to+=IndirectRelationshipSpec) 
	 *         to+=RelationshipSpec? 
	 *         (to+=IndirectRelationshipSpec? to+=RelationshipSpec?)*
	 *     )
	 * </pre>
	 */
	protected void sequence_NestedRelationshipQuery(ISerializationContext context, RelationshipQuery semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Type returns PrimitiveType
	 *     PrimitiveType returns PrimitiveType
	 *
	 * Constraint:
	 *     (type=TypeEnum array?='[]'?)
	 * </pre>
	 */
	protected void sequence_PrimitiveType(ISerializationContext context, PrimitiveType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     PropertySpec returns PropertySpec
	 *
	 * Constraint:
	 *     ((name=ID | name='*') type=Type?)
	 * </pre>
	 */
	protected void sequence_PropertySpec(ISerializationContext context, PropertySpec semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     ReferenceEntitySpec returns EntitySpec
	 *
	 * Constraint:
	 *     ((name=ID | name='*' | name='_') variationFilter=ReferenceVariationFilter?)
	 * </pre>
	 */
	protected void sequence_ReferenceEntitySpec(ISerializationContext context, EntitySpec semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     ReferencePropertySpec returns PropertySpec
	 *
	 * Constraint:
	 *     ((name=ID | name='*') type=PrimitiveType?)
	 * </pre>
	 */
	protected void sequence_ReferencePropertySpec(ISerializationContext context, PropertySpec semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     RelationTypeSpec returns ReferenceSpec
	 *     ReferenceSpec returns ReferenceSpec
	 *
	 * Constraint:
	 *     (name=ID? variationFilter=VariationFilter?)
	 * </pre>
	 */
	protected void sequence_ReferenceSpec(ISerializationContext context, ReferenceSpec semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     ReferenceVariationFilter returns VariationFilter
	 *
	 * Constraint:
	 *     (propertySpecs+=ReferencePropertySpec propertySpecs+=ReferencePropertySpec*)?
	 * </pre>
	 */
	protected void sequence_ReferenceVariationFilter(ISerializationContext context, VariationFilter semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     RelationTypeSpec returns RelationSpec
	 *     RelationSpec returns RelationSpec
	 *
	 * Constraint:
	 *     name=ID
	 * </pre>
	 */
	protected void sequence_RelationSpec(ISerializationContext context, RelationSpec semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, SkiQLPackage.Literals.RELATION_SPEC__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SkiQLPackage.Literals.RELATION_SPEC__NAME));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getRelationSpecAccess().getNameIDTerminalRuleCall_2_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     TargetExpression returns RelationshipExpression
	 *     RelationshipExpression returns RelationshipExpression
	 *
	 * Constraint:
	 *     relationshipQuery=NestedRelationshipQuery
	 * </pre>
	 */
	protected void sequence_RelationshipExpression(ISerializationContext context, RelationshipExpression semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, SkiQLPackage.Literals.RELATIONSHIP_EXPRESSION__RELATIONSHIP_QUERY) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SkiQLPackage.Literals.RELATIONSHIP_EXPRESSION__RELATIONSHIP_QUERY));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getRelationshipExpressionAccess().getRelationshipQueryNestedRelationshipQueryParserRuleCall_1_0(), semanticObject.getRelationshipQuery());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Query returns RelationshipQuery
	 *     RelationshipQuery returns RelationshipQuery
	 *
	 * Constraint:
	 *     (
	 *         from=ReferenceEntitySpec 
	 *         (to+=RelationshipSpec | to+=IndirectRelationshipSpec) 
	 *         to+=RelationshipSpec? 
	 *         (to+=IndirectRelationshipSpec? to+=RelationshipSpec?)*
	 *     )
	 * </pre>
	 */
	protected void sequence_RelationshipQuery(ISerializationContext context, RelationshipQuery semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     RelationshipSpec returns RelationshipSpec
	 *
	 * Constraint:
	 *     (targetExpression=TargetExpression relationSpec=RelationTypeSpec?)
	 * </pre>
	 */
	protected void sequence_RelationshipSpec(ISerializationContext context, RelationshipSpec semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     RelationshipTypeQuery returns SchemaQuery
	 *
	 * Constraint:
	 *     (schemaSpec=RelationshipTypeSpec operation=Operation?)
	 * </pre>
	 */
	protected void sequence_RelationshipTypeQuery(ISerializationContext context, SchemaQuery semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     RelationshipTypeSpec returns RelationshipTypeSpec
	 *
	 * Constraint:
	 *     ((name=ID | name='*') variationFilter=VariationFilter?)
	 * </pre>
	 */
	protected void sequence_RelationshipTypeSpec(ISerializationContext context, RelationshipTypeSpec semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Type returns RelationshipType
	 *     RelationshipType returns RelationshipType
	 *
	 * Constraint:
	 *     (relationType=RelationshipTypeEnum (targetEntityName=ID | targetEntityName='*')?)
	 * </pre>
	 */
	protected void sequence_RelationshipType(ISerializationContext context, RelationshipType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     SchemaTypeSpec returns SchemaSpec
	 *
	 * Constraint:
	 *     ((name=ID | name='*') variationFilter=VariationFilter?)
	 * </pre>
	 */
	protected void sequence_SchemaTypeSpec(ISerializationContext context, SchemaSpec semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     SkiQLModel returns SkiQLModel
	 *
	 * Constraint:
	 *     query=Query
	 * </pre>
	 */
	protected void sequence_SkiQLModel(ISerializationContext context, SkiQLModel semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, SkiQLPackage.Literals.SKI_QL_MODEL__QUERY) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SkiQLPackage.Literals.SKI_QL_MODEL__QUERY));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getSkiQLModelAccess().getQueryQueryParserRuleCall_1_0(), semanticObject.getQuery());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     ToReferenceEntitySpec returns EntitySpec
	 *
	 * Constraint:
	 *     ((name=ID | name='*' | name='_') variationFilter=ReferenceVariationFilter?)
	 * </pre>
	 */
	protected void sequence_ToReferenceEntitySpec(ISerializationContext context, EntitySpec semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     VariationFilter returns VariationFilter
	 *
	 * Constraint:
	 *     ((propertySpecs+=PropertySpec propertySpecs+=PropertySpec*)? only?='ONLY'?)
	 * </pre>
	 */
	protected void sequence_VariationFilter(ISerializationContext context, VariationFilter semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
}
