package org.ocl.face.logical.model;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.ocl.face.ItemImpl;
import org.ocl.face.logical.FaceLogicalPackage;

public class CharacteristicProjectionImpl extends ItemImpl implements CharacteristicProjection {
    private String path;
    @Override
    protected EClass eStaticClass() {
        return FaceLogicalPackage.Literals.CHARACTERISTICPROJECTION;
    }

    @Override
    public String getPath() {
        return path;
    }

    @Override
    public void setPath(String value) {
        String oldValue = this.path;
        this.path = value;
        if(eNotificationRequired()) {
            eNotify(new ENotificationImpl(this,
                    Notification.SET, FaceLogicalPackage.CHARACTERISTIC_ROLE_NAME,
                    oldValue, path));
        }
    }
}
