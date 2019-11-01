package org.ocl.face.logical;

import org.eclipse.emf.ecore.EClass;
import org.ocl.extlibrary.impl.ItemImpl;

public class ConstraintImpl extends ItemImpl implements Constraint {
    @Override
    protected EClass eStaticClass() {
        return FaceLogicalPackage.Literals.CONSTRAINT;
    }
}
