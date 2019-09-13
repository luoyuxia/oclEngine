package org.ocl.face.uop;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

public class FaceUopFactoryImpl extends EFactoryImpl implements FaceUopFactory {

    public static FaceUopFactory init() {
        try {
            FaceUopFactory theFaceUopFactory = (FaceUopFactory) EPackage.Registry.INSTANCE.getEFactory(FaceUopPackage.eNS_URI);
            if (theFaceUopFactory != null) {
                return theFaceUopFactory;
            }
        }
        catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new FaceUopFactoryImpl();
    }
    public FaceUopFactoryImpl() {
        super();
    }

    public Alias createAlias() {
        return new AliasImpl();
    }

}
