package org.ocl.face.logical.model;

import org.eclipse.emf.ecore.EClass;
import org.ocl.extlibrary.impl.ItemImpl;
import org.ocl.face.logical.FaceLogicalPackage;

public class ComposableElementImpl extends ItemImpl implements ComposableElement{
    @Override
    protected EClass eStaticClass() {
        return FaceLogicalPackage.Literals.COMPOSABLE;
    }
}
