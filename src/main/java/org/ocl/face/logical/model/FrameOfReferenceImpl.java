package org.ocl.face.logical.model;

import org.eclipse.emf.ecore.EClass;
import org.ocl.face.ItemImpl;
import org.ocl.face.logical.FaceLogicalPackage;

public class FrameOfReferenceImpl extends ItemImpl implements FrameOfReference {
    @Override
    protected EClass eStaticClass() {
        return FaceLogicalPackage.Literals.FRAME_OF_REFERENCE;
    }
}
