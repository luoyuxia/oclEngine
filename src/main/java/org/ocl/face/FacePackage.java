package org.ocl.face;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

public interface FacePackage extends EPackage {
    String eName = "face.uop";
    String eNS_URI = "http://www.opengroup.us/face/1.0#/";
    String eNS_PREFIX = "face.uop";

    int ALIAS = 0;
    int ALIAS_NAME = 0;

    FacePackage eINSTANCE = FacePackageImpl.init();

    interface Literals {
        EClass ITEM = eINSTANCE.getItem();
        EClass ALIAS = eINSTANCE.getAlias();
    }


    EClass getAlias();

    EClass getItem();
}
