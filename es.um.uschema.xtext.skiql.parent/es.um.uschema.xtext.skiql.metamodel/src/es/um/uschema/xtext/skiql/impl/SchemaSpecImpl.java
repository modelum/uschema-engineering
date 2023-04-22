/**
 */
package es.um.uschema.xtext.skiql.impl;

import es.um.uschema.xtext.skiql.SchemaSpec;
import es.um.uschema.xtext.skiql.SkiQLPackage;
import es.um.uschema.xtext.skiql.VariationFilter;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Schema Spec</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link es.um.uschema.xtext.skiql.impl.SchemaSpecImpl#getName <em>Name</em>}</li>
 *   <li>{@link es.um.uschema.xtext.skiql.impl.SchemaSpecImpl#getVariationFilter <em>Variation Filter</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SchemaSpecImpl extends MinimalEObjectImpl.Container implements SchemaSpec {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getVariationFilter() <em>Variation Filter</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariationFilter()
	 * @generated
	 * @ordered
	 */
	protected VariationFilter variationFilter;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SchemaSpecImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SkiQLPackage.Literals.SCHEMA_SPEC;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SkiQLPackage.SCHEMA_SPEC__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public VariationFilter getVariationFilter() {
		return variationFilter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetVariationFilter(VariationFilter newVariationFilter, NotificationChain msgs) {
		VariationFilter oldVariationFilter = variationFilter;
		variationFilter = newVariationFilter;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SkiQLPackage.SCHEMA_SPEC__VARIATION_FILTER, oldVariationFilter, newVariationFilter);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setVariationFilter(VariationFilter newVariationFilter) {
		if (newVariationFilter != variationFilter) {
			NotificationChain msgs = null;
			if (variationFilter != null)
				msgs = ((InternalEObject)variationFilter).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SkiQLPackage.SCHEMA_SPEC__VARIATION_FILTER, null, msgs);
			if (newVariationFilter != null)
				msgs = ((InternalEObject)newVariationFilter).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SkiQLPackage.SCHEMA_SPEC__VARIATION_FILTER, null, msgs);
			msgs = basicSetVariationFilter(newVariationFilter, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SkiQLPackage.SCHEMA_SPEC__VARIATION_FILTER, newVariationFilter, newVariationFilter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SkiQLPackage.SCHEMA_SPEC__VARIATION_FILTER:
				return basicSetVariationFilter(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SkiQLPackage.SCHEMA_SPEC__NAME:
				return getName();
			case SkiQLPackage.SCHEMA_SPEC__VARIATION_FILTER:
				return getVariationFilter();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SkiQLPackage.SCHEMA_SPEC__NAME:
				setName((String)newValue);
				return;
			case SkiQLPackage.SCHEMA_SPEC__VARIATION_FILTER:
				setVariationFilter((VariationFilter)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case SkiQLPackage.SCHEMA_SPEC__NAME:
				setName(NAME_EDEFAULT);
				return;
			case SkiQLPackage.SCHEMA_SPEC__VARIATION_FILTER:
				setVariationFilter((VariationFilter)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case SkiQLPackage.SCHEMA_SPEC__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case SkiQLPackage.SCHEMA_SPEC__VARIATION_FILTER:
				return variationFilter != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //SchemaSpecImpl
