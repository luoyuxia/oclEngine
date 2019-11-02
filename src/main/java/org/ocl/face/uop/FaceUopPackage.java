package org.ocl.face.uop;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

public interface FaceUopPackage extends EPackage {
    String eName = "face.uop";
    String eNS_URI = "http://www.opengroup.us/face/1.0#/#face#uop";
    String eNS_PREFIX = "face.uop";

    int ALIAS = 0;
    int ALIAS_NAME = 0;

    int ALIAS_COPY = 1;
    int ALIAS_COPY_NAME = 0;

    FaceUopPackage eINSTANCE = FaceUopPackageImpl.init();

    interface Literals {
        EClass ITEM = eINSTANCE.getItem();
        EClass ALIAS = eINSTANCE.getAlias();
    }


    EClass getAlias();

    EClass getItem();
}
