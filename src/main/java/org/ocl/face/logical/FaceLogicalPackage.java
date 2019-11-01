package org.ocl.face.logical;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

public interface FaceLogicalPackage extends EPackage {
    String eName = "face.logical";
    String eNS_URI = "http://www.opengroup.us/face/1.0#/";
    String eNS_PREFIX = "face.logical";

    // class name
    int ITEM = -1 ;

    int ASSOCIATION = 0;

    int CHARACTERISTICPROJECTION = 1;

    int COMPOSITION = 2;

    int CONSTRAINT = 3;

    int CONVERSION = 4;

    int ELEMENT = 5;

    int ENTITY = 6;

    int INFORMATIONELEMENT = 7;

    int CHARACTERISTIC = 8;

    int UNIT = 9;
    int FRAME_OF_REFERENCE = 10;

    // attributes
    int ELEMENT_NAME = 0;
    int COMPOSITION_ROLE_NAME = 1;
    int ENTITY_COMPOSITION = 2;
    int ASSOCIATION_COMPOSITION = 3;
    int ASSOCIATION_ENTITY = 4;
    int CHARACTERISTIC_ROLE_NAME = 5;
    int CHARACTERISTICPROJECTION_PATH = 6;
    int CONVERSION_SOURCE = 7;
    int CONVERSION_DESTINATION = 8;

    // operation
    int OPERATION_CONVERSION_SOURCE_DESTINATION_IMPLIES = 0;




    FaceLogicalPackage eINSTANCE = FaceLogicalPackageImpl.init();

    interface Literals {
        EClass ASSOCIATION = eINSTANCE.getAssociation();
        EClass CHARACTERISTICPROJECTION = eINSTANCE.getCharacteristicProjection();
        EClass COMPOSITION = eINSTANCE.getComposition();
        EClass CONSTRAINT = eINSTANCE.getConstraint();
        EClass CONVERSION = eINSTANCE.getConversion();
        EClass ELEMENT = eINSTANCE.getElement();
        EClass ENTITY = eINSTANCE.getEntity();
        EClass INFORMATIONELEMENT = eINSTANCE.getInformationElement();
        EClass CHARACTERISTIC = eINSTANCE.getCharacteristic();
    }

    EClass getItem();

    EClass getAssociation();

    EClass getCharacteristicProjection();

    EClass getComposition();

    EClass getConstraint();

    EClass getConversion();

    EClass getElement();

    EClass getEntity();

    EClass getInformationElement();

    EClass getCharacteristic();

    EClass getUnit();

    EClass getFrameOfReference();

}
