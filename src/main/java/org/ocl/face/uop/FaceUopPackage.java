package org.ocl.face.uop;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

public interface FaceUopPackage extends EPackage {
    String eName = "face.uop";
    String eNS_URI = "http://www.opengroup.us/face/1.0#/";
    String eNS_PREFIX = "face.uop";

    int ALIAS = 0;
    int ALIAS_NAME = 0;

    int ALIAS_COPY = 1;
    int ALIAS_COPY_NAME = 0;

    FaceUopPackage eINSTANCE = FaceUopUopPackageImpl.init();

    interface Literals {
        EClass ITEM = eINSTANCE.getItem();
        EClass ALIAS = eINSTANCE.getAlias();
        EClass ALIAS_COPY = eINSTANCE.getAliasCopy();
    }


    EClass getAlias();

    EClass getItem();

    EClass getAliasCopy();
}