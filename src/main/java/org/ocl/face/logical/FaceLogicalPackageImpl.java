package org.ocl.face.logical;

import org.eclipse.emf.ecore.*;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.ocl.face.logical.validator.ConversionValidator;

public class FaceLogicalPackageImpl extends EPackageImpl implements FaceLogicalPackage{
    private EClass itemEClass = null;
    private EClass associationEClass = null;
    private EClass characteristicProjectionEClass = null;
    private EClass compositionEClass = null;
    private EClass constraintEClass = null;
    private EClass conversionEClass = null;
    private EClass elementEClass = null;
    private EClass entityEClass = null;
    private EClass informationElementEClass = null;
    private EClass characteristicEClass = null;
    private EClass unitEClass = null;
    private EClass frameOfReferenceEClass = null;

    private static boolean isInited = false;
    private FaceLogicalPackageImpl() {
        super(eNS_URI, FaceLogicalFactoryImpl.eINSTANCE);
    }

    public static FaceLogicalPackage init() {
        if (isInited)
            return (FaceLogicalPackage) Registry.INSTANCE.getEPackage(FaceLogicalPackage.eNS_URI);
        Object registeredFacePackage = EPackage.Registry.INSTANCE.get(eNS_URI);
        FaceLogicalPackageImpl theFacePackage = registeredFacePackage instanceof FaceLogicalPackage ? (FaceLogicalPackageImpl) registeredFacePackage : new FaceLogicalPackageImpl();
        isInited = true;

        theFacePackage.createPackageContents();

        theFacePackage.initializePackageContents();
        EValidator.Registry.INSTANCE.put(theFacePackage,
                (EValidator.Descriptor) () -> ConversionValidator.INSTANCE);
        theFacePackage.freeze();

        Registry.INSTANCE.put(FaceLogicalPackage.eNS_URI, theFacePackage);
        return theFacePackage;
    }

    public void createPackageContents() {
        if (isCreated) return;
        isCreated = true;

        itemEClass = createEClass(ITEM);

        associationEClass = createEClass(ASSOCIATION);
        createEReference(associationEClass, ASSOCIATION_COMPOSITION);
        createEReference(associationEClass, ASSOCIATION_ENTITY);

        characteristicProjectionEClass = createEClass(CHARACTERISTICPROJECTION);
        createEAttribute(characteristicProjectionEClass, CHARACTERISTICPROJECTION_PATH);

        compositionEClass = createEClass(COMPOSITION);
        createEAttribute(compositionEClass, COMPOSITION_ROLE_NAME);

        constraintEClass = createEClass(CONSTRAINT);

        conversionEClass = createEClass(CONVERSION);
        createEReference(conversionEClass, CONVERSION_SOURCE);
        createEReference(conversionEClass, CONVERSION_DESTINATION);
        createEOperation(conversionEClass, OPERATION_CONVERSION_SOURCE_DESTINATION_IMPLIES);

        elementEClass = createEClass(ELEMENT);
        createEAttribute(elementEClass, ELEMENT_NAME);

        entityEClass = createEClass(ENTITY);
        createEReference(entityEClass, ENTITY_COMPOSITION);

        informationElementEClass = createEClass(INFORMATIONELEMENT);

        characteristicEClass = createEClass(CHARACTERISTIC);
        createEAttribute(characteristicEClass, CHARACTERISTIC_ROLE_NAME);

        unitEClass = createEClass(UNIT);
        frameOfReferenceEClass = createEClass(FRAME_OF_REFERENCE);

    }

    public void initializePackageContents() {
        if (isInitialized) return;
        isInitialized = true;

        setName(eName);
        setNsPrefix(eNS_PREFIX);
        setNsURI(eNS_URI);

        initEClass(associationEClass, Association.class, "Association", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEClass(characteristicProjectionEClass, CharacteristicProjection.class, "CharacteristicProjection",
                !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getPath(), ecorePackage.getEString(), "path", null, 0, 1,
                CharacteristicProjection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEReference(getAssociationComposition(), getComposition(),
                null, "composition", null, 0, -1,
                Characteristic.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getAssociationEntity(), this.getCharacteristic(),
                null, "associatedEntity", null, 0, -1,
                Characteristic.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);


        initEClass(compositionEClass, Composition.class, "Composition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getRoleName(), ecorePackage.getEString(), "rolename", null, 0, 1,
                Composition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(constraintEClass, Constraint.class, "Constraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);


        initEClass(conversionEClass, Conversion.class, "Conversion", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getConversionSource(), getUnit() ,
                null, "source", null, 0, 1,
                Unit.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getConversionDestination(), getFrameOfReference(),
                null, "destination", null, 0, 1,
                FrameOfReference.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEOperation(getConversionOperation(), ecorePackage.getEBoolean(),
                "unitConvertsToUnit", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        initEOperation(getConversionOperation(), ecorePackage.getEBoolean(),
                "frameOfReferenceConvertsToFrameOfReference", 1, 1, IS_UNIQUE, IS_ORDERED);



        initEClass(elementEClass, Element.class, "Element", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getElementName(), ecorePackage.getEString(), "name", null, 0, 1,
                Element.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);


        initEClass(entityEClass, Entity.class, "Entity", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getEntityComposition(), this.getComposition(),
                null, "composition", null, 0, -1,
                Composition.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(informationElementEClass, InformationElement.class, "InformationElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(characteristicEClass, Characteristic.class, "Characteristic", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getCharacteristicRoleName(), ecorePackage.getEString(), "rolename", null, 0, 1,
                Characteristic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        createResource(eNS_URI);

        initEClass(unitEClass, Unit.class, "Unit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEClass(frameOfReferenceEClass, FrameOfReference.class, "FrameOfReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private boolean isCreated = false;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private boolean isInitialized = false;

    @Override
    public EClass getItem() {
        return itemEClass;
    }

    @Override
    public EClass getAssociation() {
        return associationEClass;
    }

    @Override
    public EClass getCharacteristicProjection() {
        return characteristicProjectionEClass;
    }

    @Override
    public EClass getComposition() {
        return compositionEClass;
    }

    @Override
    public EClass getConstraint() {
        return constraintEClass;
    }

    @Override
    public EClass getConversion() {
        return conversionEClass;
    }

    @Override
    public EClass getElement() {
        return elementEClass;
    }

    public EAttribute getElementName() {
        return (EAttribute)elementEClass.getEStructuralFeature(0);
    }

    public EReference getEntityComposition() {
        return (EReference) entityEClass.getEStructuralFeature(0);
    }

    public EReference getAssociationComposition() {
        return (EReference) associationEClass.getEStructuralFeature(0);
    }

    public EReference getAssociationEntity() {
        return (EReference) associationEClass.getEStructuralFeature(1);
    }

    public EReference getConversionSource() {
        return (EReference) conversionEClass.getEStructuralFeature(0);
    }

    public EReference getConversionDestination() {
        return (EReference) conversionEClass.getEStructuralFeature(1);
    }

    public EAttribute getRoleName() {
        return (EAttribute) compositionEClass.getEStructuralFeature(0);
    }

    public EAttribute getPath() {
        return (EAttribute) characteristicProjectionEClass.getEStructuralFeature(0);
    }

    public EAttribute getCharacteristicRoleName() {
        return (EAttribute) characteristicEClass.getEStructuralFeature(0);
    }

    @Override
    public EClass getEntity() {
        return entityEClass;
    }

    @Override
    public EClass getInformationElement() {
        return informationElementEClass;
    }

    @Override
    public EClass getCharacteristic() {
        return characteristicEClass;
    }

    @Override
    public EClass getUnit() {
        return unitEClass;
    }

    @Override
    public EClass getFrameOfReference() {
        return frameOfReferenceEClass;
    }

    public EOperation getConversionOperation() {
        return conversionEClass.getEOperations().get(0);
    }
}
