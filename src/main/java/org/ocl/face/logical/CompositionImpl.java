package org.ocl.face.logical;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.ocl.extlibrary.impl.ItemImpl;

public class CompositionImpl extends ItemImpl implements Composition {
    protected static final String ROLE_NAME_DEFAULT = null;
    protected String roleName = ROLE_NAME_DEFAULT;
    @Override
    protected EClass eStaticClass() {
        return FaceLogicalPackage.Literals.COMPOSITION;
    }

    @Override
    public String getRoleName() {
        return roleName;
    }

    @Override
    public void setRoleName(String value) {
        String oldName = roleName;
        roleName = value;
        if(eNotificationRequired()) {
            eNotify(new ENotificationImpl(this,
                    Notification.SET, FaceLogicalPackage.ELEMENT_NAME,
                    oldName, roleName));
        }
    }

    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case FaceLogicalPackage.COMPOSITION_ROLE_NAME:
                return getRoleName();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case FaceLogicalPackage.COMPOSITION_ROLE_NAME:
                setRoleName((String)newValue);
                return;
        }
        super.eSet(featureID, newValue);
    }
}
