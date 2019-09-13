package org.ocl.face.uop;

import org.eclipse.emf.ecore.EFactory;

public interface FaceUopFactory extends EFactory {
    FaceUopFactory eINSTANCE = FaceUopFactoryImpl.init();

    Alias createAlias();
}
