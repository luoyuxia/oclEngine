package org.ocl.face.logical;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.ocl.extlibrary.impl.ItemImpl;

public class ElementImpl extends ItemImpl implements Element{
    protected static final String NAME_DEFAULT = null;
    protected String name = NAME_DEFAULT;
    @Override
    protected EClass eStaticClass() {
        return FaceLogicalPackage.Literals.ELEMENT;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String value) {
        String oldName = name;
        name = value;
        if(eNotificationRequired()) {
            eNotify(new ENotificationImpl(this,
                    Notification.SET, FaceLogicalPackage.ELEMENT_NAME,
                    oldName, name));
        }
    }

    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case FaceLogicalPackage.ELEMENT_NAME:
                return getName();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case FaceLogicalPackage.ELEMENT_NAME:
                setName((String)newValue);
                return;
        }
        super.eSet(featureID, newValue);
    }
}
