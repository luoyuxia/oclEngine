package org.ocl.face.common;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

public interface FacePackage extends EPackage {
    String eName = "";
    String eNS_URI = "http://www.opengroup.us/face/1.0#/common";
    String eNS_PREFIX = "";

    int UNIT = 0;
    int FRAME_OF_REFERENCE = 1;

    FacePackage eINSTANCE = FacePackageImpl.init();

    interface Literals {
        EClass UNIT = eINSTANCE.getUnit();
        EClass FRAME_OF_REFERENCE = eINSTANCE.getFrameOfReference();
    }

    EClass getUnit();

    EClass getFrameOfReference();


}
