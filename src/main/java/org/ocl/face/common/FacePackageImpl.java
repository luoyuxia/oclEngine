package org.ocl.face.common;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;

public class FacePackageImpl extends EPackageImpl implements FacePackage{
    private EClass unitEClass = null;
    private EClass frameOfReferenceEClass = null;
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

    private static boolean isInited = false;
    private boolean isCreated = false;
    private boolean isInitialized = false;

    public void createPackageContents() {
        if (isCreated) return;
        isCreated = true;

        unitEClass = createEClass(UNIT);

        frameOfReferenceEClass = createEClass(FRAME_OF_REFERENCE);

    }

    public void initializePackageContents() {
        if (isInitialized) return;
        isInitialized = true;

        setName(eName);
        setNsPrefix(eNS_PREFIX);
        setNsURI(eNS_URI);

        initEClass(unitEClass, Unit.class, "Unit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(frameOfReferenceEClass, FrameOfReference.class, "FrameOfReference",  !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    }

    @Override
    public EClass getUnit() {
        return unitEClass;
    }

    @Override
    public EClass getFrameOfReference() {
        return frameOfReferenceEClass;
    }
}
