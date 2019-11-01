package org.ocl.face.logical;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.ocl.extlibrary.impl.ItemImpl;

public class AssociationImpl extends ItemImpl implements Association {
    private EList<Characteristic> composition;
    private EList<Characteristic> associatedEntity;

    @Override
    protected EClass eStaticClass() {
        return FaceLogicalPackage.Literals.ASSOCIATION;
    }

    @Override
    public EList<Characteristic> getComposition() {
        return composition;
    }

    @Override
    public void setComposition(EList<Characteristic> value) {
        EList<Characteristic> oldComposition = this.composition;
        this.composition = value;
        if(eNotificationRequired()) {
            eNotify(new ENotificationImpl(this,
                    Notification.SET, FaceLogicalPackage.ASSOCIATION_COMPOSITION,
                    oldComposition, composition));
        }
    }

    @Override
    public EList<Characteristic> getAssociatedEntity() {
        return associatedEntity;
    }

    @Override
    public void setAssociatedEntity(EList<Characteristic> value) {
        EList<Characteristic> oldAssociatedEntity = this.associatedEntity;
        this.associatedEntity = value;
        if(eNotificationRequired()) {
            eNotify(new ENotificationImpl(this,
                    Notification.SET, FaceLogicalPackage.ASSOCIATION_ENTITY,
                    oldAssociatedEntity, associatedEntity));
        }
    }

    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case FaceLogicalPackage.ASSOCIATION_COMPOSITION:
                return getComposition();
            case FaceLogicalPackage.ASSOCIATION_ENTITY:
                return getAssociatedEntity();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case FaceLogicalPackage.ASSOCIATION_COMPOSITION:
                setComposition((EList<Characteristic>) newValue);
                return;
            case FaceLogicalPackage.ASSOCIATION_ENTITY:
                setAssociatedEntity((EList<Characteristic>) newValue);
        }
        super.eSet(featureID, newValue);
    }
}
