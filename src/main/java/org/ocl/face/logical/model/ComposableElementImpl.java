package org.ocl.face.logical.model;

import org.eclipse.emf.ecore.EClass;
import org.ocl.face.ItemImpl;
import org.ocl.face.logical.FaceLogicalPackage;

public class ComposableElementImpl extends ItemImpl implements ComposableElement{
    @Override
    protected EClass eStaticClass() {
        return FaceLogicalPackage.Literals.COMPOSABLE;
    }
}
