package org.ocl.face.conceptual.model;

import org.eclipse.emf.ecore.EClass;
import org.ocl.face.conceptual.FaceConceptualPackage;
import org.ocl.face.logical.model.ComposableElementImpl;

public class ObservableImpl extends ComposableElementImpl implements Observable {
    @Override
    protected EClass eStaticClass() {
        return FaceConceptualPackage.Literals.OBSERVABLE;
    }
}
