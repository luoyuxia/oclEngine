package org.ocl.face.logical.model;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.ocl.face.logical.FaceLogicalPackage;

public class EntityImpl extends ComposableElementImpl implements Entity{
    protected static final EList<Composition> defaultComposition = null;
    protected EList<Composition> compositions = defaultComposition;
    private org.ocl.face.conceptual.model.Entity realizes;
    @Override
    protected EClass eStaticClass() {
        return FaceLogicalPackage.Literals.ENTITY;
    }

    @Override
    public EList<Composition> getComposition() {
        return compositions;
    }

    @Override
    public void setComposition(EList<Composition> value) {
        EList<Composition> oldComposition = this.compositions;
        this.compositions = value;
        if(eNotificationRequired()) {
            eNotify(new ENotificationImpl(this,
                    Notification.SET, 0,
                    oldComposition, compositions));
        }
    }

    @Override
    public org.ocl.face.conceptual.model.Entity getRealizes() {
        return realizes;
    }

    @Override
    public void setRealizes(org.ocl.face.conceptual.model.Entity value) {
        org.ocl.face.conceptual.model.Entity old = realizes;
        this.realizes = value;
        if(eNotificationRequired()) {
            eNotify(new ENotificationImpl(this,
                    Notification.SET, 1,
                    old, realizes));
        }
    }


    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case 0:
                return getComposition();
            case 1:
                return getRealizes();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case 0:
                setComposition((EList<Composition>) newValue);
                return;
            case 1:
                setRealizes((org.ocl.face.conceptual.model.Entity)newValue);
                return;
        }
        super.eSet(featureID, newValue);
    }
}
