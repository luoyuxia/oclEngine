package org.ocl.face;

import org.eclipse.emf.ecore.EFactory;
import org.ocl.face.uop.Alias;

public interface FaceFactory extends EFactory {
    FaceFactory eINSTANCE = FaceFactoryImpl.init();

    Alias createAlias();
}
