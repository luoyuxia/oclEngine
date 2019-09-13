package org.ocl.face;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.ocl.face.uop.Alias;
import org.ocl.face.uop.AliasImpl;

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

    public Alias createAlias() {
        AliasImpl alias = new AliasImpl();
        return alias;
    }

}
