package org.ocl.face.conceptual.model;

import org.eclipse.emf.ecore.EClass;
import org.ocl.face.ItemImpl;
import org.ocl.face.conceptual.FaceConceptualPackage;

public class InformationElementImpl extends ItemImpl implements InformationElement {
    @Override
    protected EClass eStaticClass() {
        return FaceConceptualPackage.Literals.INFORMATION_ELEMENT;
    }
}
