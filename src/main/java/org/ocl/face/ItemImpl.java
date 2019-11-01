package org.ocl.face;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.ocl.face.uop.FaceUopPackage;

public  class ItemImpl extends EObjectImpl implements Item {
    protected ItemImpl() {
        super();
    }

    @Override
    protected EClass eStaticClass() {
        return FaceUopPackage.Literals.ITEM;
    }
}
