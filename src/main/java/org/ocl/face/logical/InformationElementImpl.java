package org.ocl.face.logical;

import org.eclipse.emf.ecore.EClass;
import org.ocl.extlibrary.impl.ItemImpl;

public class InformationElementImpl extends ItemImpl implements InformationElement {
    @Override
    protected EClass eStaticClass() {
        return FaceLogicalPackage.Literals.INFORMATIONELEMENT;
    }
}
