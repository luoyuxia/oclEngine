package org.ocl.face.conceptual;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.ocl.face.conceptual.model.*;

public class FaceConceptualFactoryImpl extends EFactoryImpl implements FaceConceptualFactory {

    public static FaceConceptualFactory init() {
        try {
            FaceConceptualFactory factory = (FaceConceptualFactory) EPackage.Registry.INSTANCE.getEFactory(FaceConceptualPackage.eNS_URI);
            if (factory != null) {
                return factory;
            }
        } catch (Exception e) {
            EcorePlugin.INSTANCE.log(e);
        }
        return new FaceConceptualFactoryImpl();
    }

    @Override
    public Composition createComposition() {
        return new CompositionImpl();
    }

    @Override
    public Entity createEntity() {
        return new EntityImpl();
    }

    @Override
    public InformationElement createInformationElement() {
        return new InformationElementImpl();
    }

    @Override
    public Observable createObservable() {
        return new ObservableImpl();
    }
}
