package org.ocl.face.common;

import org.eclipse.emf.ecore.EFactory;

public interface FaceFactory extends EFactory {
    FaceFactory eINSTANCE = FaceFactoryImpl.init();

    Unit createUnit();

    FrameOfReference createFacePackage();
}
