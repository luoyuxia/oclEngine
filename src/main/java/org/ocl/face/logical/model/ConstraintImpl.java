package org.ocl.face.logical.model;

import org.eclipse.emf.ecore.EClass;
import org.ocl.face.ItemImpl;
import org.ocl.face.logical.FaceLogicalPackage;

public class ConstraintImpl extends ItemImpl implements Constraint {
    @Override
    protected EClass eStaticClass() {
        return FaceLogicalPackage.Literals.CONSTRAINT;
    }
}
