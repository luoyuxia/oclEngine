package org.ocl.face.uop;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.ocl.extlibrary.impl.ItemImpl;

public class AliasImpl extends ItemImpl implements Alias {
    protected static final String NAME_DEFAULT = null;
    protected String name = NAME_DEFAULT;
    public String getName() {
        return name;
    }

    public void setName(String value) {
        String oldName = name;
        name = value;
        if(eNotificationRequired()) {
            eNotify(new ENotificationImpl(this,
                    Notification.SET, FaceUopPackage.ALIAS_NAME,
                    oldName, name));
        }
    }

    @Override
    protected EClass eStaticClass() {
        return FaceUopPackage.Literals.ALIAS;
    }

    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case FaceUopPackage.ALIAS_NAME:
                return getName();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case FaceUopPackage.ALIAS_NAME:
                setName((String)newValue);
                return;
        }
        super.eSet(featureID, newValue);
    }
}
