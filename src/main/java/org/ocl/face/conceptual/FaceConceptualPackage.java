package org.ocl.face.conceptual;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

public interface FaceConceptualPackage extends EPackage {
    String eName = "face.conceptual";
    String eNS_URI = "http://www.opengroup.us/face/1.0#/face#conceptual";
    String eNS_PREFIX = "face.conceptual";

    int COMPOSITION = 0;

    int ENTITY = 1;

    int INFORMATION_ELEMENT = 2;

    int OBSERVABLE = 3;

    FaceConceptualPackage eINSTANCE = FaceConceptualPackageImpl.init();

    interface Literals {
        EClass COMPOSITION = eINSTANCE.getComposition();
        EClass ENTITY = eINSTANCE.getEntity();
        EClass INFORMATION_ELEMENT = eINSTANCE.getInformationElement();
        EClass OBSERVABLE = eINSTANCE.getObservable();
    }

    EClass getComposition();

    EClass getEntity();

    EClass getInformationElement();

    EClass getObservable();

}
