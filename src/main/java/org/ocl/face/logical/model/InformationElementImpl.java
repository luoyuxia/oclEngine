package org.ocl.face.logical.model;

import org.eclipse.emf.ecore.EClass;
import org.ocl.face.logical.FaceLogicalPackage;

public class InformationElementImpl extends ComposableElementImpl implements InformationElement {
    @Override
    protected EClass eStaticClass() {
        return FaceLogicalPackage.Literals.INFORMATIONELEMENT;
    }

    @Override
    public void setInformationElement(org.ocl.face.conceptual.model.InformationElement value) {

    }

    @Override
    public org.ocl.face.conceptual.model.InformationElement getInformationElement() {
        return null;
    }
}
