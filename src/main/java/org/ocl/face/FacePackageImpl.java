package org.ocl.face;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.ocl.face.uop.Alias;

public class FacePackageImpl extends EPackageImpl implements FacePackage{
    private EClass aliasEClass = null;
    private EClass itemEClass = null;

    private FacePackageImpl() {
        super(eNS_URI, FaceFactoryImpl.eINSTANCE);
    }

    public static FacePackage init() {
        if (isInited)
            return (FacePackage) Registry.INSTANCE.getEPackage(FacePackage.eNS_URI);
        Object registeredFacePackage = EPackage.Registry.INSTANCE.get(eNS_URI);
        FacePackageImpl theFacePackage = registeredFacePackage instanceof FacePackageImpl ? (FacePackageImpl) registeredFacePackage : new FacePackageImpl();
        isInited = true;
        theFacePackage.createPackageContents();

        theFacePackage.initializePackageContents();

        theFacePackage.freeze();
        EPackage.Registry.INSTANCE.put(FacePackage.eNS_URI, theFacePackage);
        return theFacePackage;
    }

    public void createPackageContents() {
        if (isCreated) return;
        isCreated = true;

        aliasEClass = createEClass(ALIAS);
        createEAttribute(aliasEClass, ALIAS_NAME);
    }

    public void initializePackageContents() {
        if (isInitialized) return;
        isInitialized = true;

        setName(eName);
        setNsPrefix(eNS_PREFIX);
        setNsURI(eNS_URI);

        initEClass(aliasEClass, Alias.class, "Alias", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getAlias_name(), ecorePackage.getEString(), "name", null, 0, 1,
                Alias.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        createResource(eNS_URI);
    }

    public EAttribute getAlias_name() {
        return (EAttribute)aliasEClass.getEStructuralFeature(0);
    }

    private static boolean isInited = false;

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

    public EClass getAlias() {
        return aliasEClass;
    }

    public EClass getItem() {
        return itemEClass;
    }
}
