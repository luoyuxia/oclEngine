package org.ocl.face.logical.model;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.ocl.extlibrary.impl.ItemImpl;
import org.ocl.face.logical.FaceLogicalPackage;

public class CharacteristicImpl extends ItemImpl implements Characteristic{
    private String roleName = null;
    @Override
    protected EClass eStaticClass() {
        return FaceLogicalPackage.Literals.CHARACTERISTIC;
    }

    @Override
    public String getRoleName() {
        return roleName;
    }

    @Override
    public void setRoleName(String value) {
        String oldValue = this.roleName;
        this.roleName = value;
        if(eNotificationRequired()) {
            eNotify(new ENotificationImpl(this,
                    Notification.SET, FaceLogicalPackage.CHARACTERISTIC_ROLE_NAME,
                    oldValue, roleName));
        }
    }

    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case FaceLogicalPackage.CHARACTERISTIC_ROLE_NAME:
                return getRoleName();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case FaceLogicalPackage.CHARACTERISTIC_ROLE_NAME:
                setRoleName((String)newValue);
                return;
        }
        super.eSet(featureID, newValue);
    }
}
