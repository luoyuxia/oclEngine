package org.ocl.face;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.EObjectImpl;

public abstract class ItemImpl extends EObjectImpl implements Item {
    protected ItemImpl() {
        super();
    }

    @Override
    protected EClass eStaticClass() {
        return FacePackage.Literals.ITEM;
    }
}
