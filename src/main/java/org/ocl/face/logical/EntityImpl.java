package org.ocl.face.logical;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.ocl.extlibrary.impl.ItemImpl;

public class EntityImpl extends ItemImpl implements Entity{
    protected static final EList<Composition> defaultComposition = null;
    protected EList<Composition> compositions = defaultComposition;
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
                    Notification.SET, FaceLogicalPackage.ENTITY_COMPOSITION,
                    oldComposition, compositions));
        }
    }


    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case FaceLogicalPackage.ENTITY_COMPOSITION:
                return getComposition();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case FaceLogicalPackage.ENTITY_COMPOSITION:
                setComposition((EList<Composition>) newValue);
                return;
        }
        super.eSet(featureID, newValue);
    }
}
