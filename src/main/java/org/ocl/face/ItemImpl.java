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

    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        return super.eGet(featureID, resolve, coreType);
    }

    @Override
    public void eSet(int featureID, Object newValue) {
        super.eSet(featureID, newValue);
    }
}
