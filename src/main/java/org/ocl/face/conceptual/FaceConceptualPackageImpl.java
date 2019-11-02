package org.ocl.face.conceptual;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.ocl.face.conceptual.model.Composition;
import org.ocl.face.conceptual.model.Entity;
import org.ocl.face.conceptual.model.InformationElement;
import org.ocl.face.conceptual.model.Observable;
import org.ocl.face.logical.model.ComposableElement;

public class FaceConceptualPackageImpl extends EPackageImpl implements FaceConceptualPackage {
    private EClass compositionEClass = null;
    private EClass entityEClass = null;
    private EClass informationEClass = null;
    private EClass observableEClass = null;

    private static boolean isInited = false;
    private boolean isCreated = false;
    private boolean isInitialized = false;


    public static FaceConceptualPackage init() {
        if (isInited)
            return (FaceConceptualPackage) Registry.INSTANCE.getEPackage(FaceConceptualPackage.eNS_URI);
        Object registeredFacePackage = EPackage.Registry.INSTANCE.get(eNS_URI);
        FaceConceptualPackageImpl theFacePackage = registeredFacePackage instanceof FaceConceptualPackageImpl ?
                (FaceConceptualPackageImpl) registeredFacePackage : new FaceConceptualPackageImpl();
        isInited = true;
        theFacePackage.createPackageContents();

        theFacePackage.initializePackageContents();

        theFacePackage.freeze();
        EPackage.Registry.INSTANCE.put(FaceConceptualPackage.eNS_URI, theFacePackage);
        return theFacePackage;
    }

    public void createPackageContents() {
        if (isCreated) return;
        isCreated = true;

        compositionEClass = createEClass(COMPOSITION);
        createEAttribute(compositionEClass, COMPOSITION_LOWER_BOUND);
        createEAttribute(compositionEClass, COMPOSITION_UPPER_BOUND);
        createEReference(compositionEClass, COMPOSITION_TYPE);

        entityEClass = createEClass(ENTITY);
        informationEClass = createEClass(INFORMATION_ELEMENT);
        observableEClass = createEClass(OBSERVABLE);
    }

    public void initializePackageContents() {
        if (isInitialized) return;
        isInitialized = true;

        setName(eName);
        setNsPrefix(eNS_PREFIX);
        setNsURI(eNS_URI);

        initEClass(compositionEClass, Composition.class, "Composition",  !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getCompositionLowerBound(), ecorePackage.getEDouble(), "lowerBound", null, 0, 1,
                Composition.class,  !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getCompositionUpperBound(), ecorePackage.getEDouble(), "upperBound", null, 0, 1,
                Composition.class,  !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getCompositionType(), getComposition(), null, "type", null, 0, 1,
                ComposableElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
                IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(entityEClass, Entity.class, "Entity", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(informationEClass, InformationElement.class, "InformationElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(observableEClass, Observable.class, "Observable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    }


    @Override
    public EClass getComposition() {
        return compositionEClass;
    }

    @Override
    public EClass getEntity() {
        return entityEClass;
    }

    @Override
    public EClass getInformationElement() {
        return informationEClass;
    }

    @Override
    public EClass getObservable() {
        return observableEClass;
    }

    public EAttribute getCompositionLowerBound() {
        return (EAttribute) compositionEClass.getEStructuralFeature(0);
    }

    public EAttribute getCompositionUpperBound() {
        return (EAttribute) compositionEClass.getEStructuralFeature(1);
    }
    public EReference getCompositionType() {
        return (EReference) compositionEClass.getEStructuralFeature(2);
    }
}
