package org.ocl.face.common;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

public class FaceFactoryImpl extends EFactoryImpl implements FaceFactory{

    public static FaceFactory init() {
        try {
            FaceFactory theFaceFactory = (FaceFactory) EPackage.Registry.INSTANCE.getEFactory(FacePackage.eNS_URI);
            if (theFaceFactory != null) {
                return theFaceFactory;
            }
        }
        catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new FaceFactoryImpl();
    }

    public FaceFactoryImpl() {
        super();
    }

    @Override
    public Unit createUnit() {
        return new UnitImpl();
    }

    @Override
    public FrameOfReference createFacePackage() {
        return new FrameOfReferenceImpl();
    }
}
