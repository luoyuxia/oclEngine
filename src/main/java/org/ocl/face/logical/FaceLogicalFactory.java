package org.ocl.face.logical;

import org.eclipse.emf.ecore.EFactory;
import org.ocl.face.logical.model.*;

public interface FaceLogicalFactory extends EFactory {
    FaceLogicalFactory eINSTANCE = FaceLogicalFactoryImpl.init();

    Association createAssociation();

    CharacteristicProjection createCharacteristicProjection();

    Composition createComposition();

    Constraint createConstraint();

    Conversion createConversion();

    Element createElement();

    Entity createEntity();

    InformationElement createInformationElement();

    Characteristic createCharacteristic();

    Measurement createMeasurement();

}
