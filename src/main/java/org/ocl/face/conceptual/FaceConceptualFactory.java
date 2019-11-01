package org.ocl.face.conceptual;

import org.eclipse.emf.ecore.EFactory;
import org.ocl.face.conceptual.model.Composition;
import org.ocl.face.conceptual.model.Entity;
import org.ocl.face.conceptual.model.InformationElement;
import org.ocl.face.conceptual.model.Observable;

public interface FaceConceptualFactory extends EFactory {
    FaceConceptualFactory eINSTANCE = FaceConceptualFactoryImpl.init();

    Composition createComposition();

    Entity createEntity();

    InformationElement createInformationElement();

    Observable createObservable();
}
