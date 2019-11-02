package org.ocl.face.logical.model;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.ocl.face.ItemImpl;
import org.ocl.face.logical.FaceLogicalPackage;

public class CompositionImpl extends ItemImpl implements Composition {
    private static final String ROLE_NAME_DEFAULT = null;
    private String roleName = ROLE_NAME_DEFAULT;
    private double lowerBound = 0.0;
    private double upperBound = 0.0;
    private org.ocl.face.conceptual.model.Composition realizes;
    private ComposableElement type;
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
                    Notification.SET, 0,
                    oldName, roleName));
        }
    }

    @Override
    public double getLowerBound() {
        return lowerBound;
    }

    @Override
    public void setLowerBound(double value) {
        double old = lowerBound;
        lowerBound = value;
        if(eNotificationRequired()) {
            eNotify(new ENotificationImpl(this,
                    Notification.SET, 1,
                    old, lowerBound));
        }
    }

    @Override
    public double getUpperBound() {
        return upperBound;
    }

    @Override
    public void setUpperBound(double value) {
        double old = upperBound;
        upperBound = value;
        if(eNotificationRequired()) {
            eNotify(new ENotificationImpl(this,
                    Notification.SET, 2,
                    old, upperBound));
        }
    }

    @Override
    public org.ocl.face.conceptual.model.Composition getRealizes() {
        return realizes;
    }

    @Override
    public void setRealizes(org.ocl.face.conceptual.model.Composition value) {
        org.ocl.face.conceptual.model.Composition old = realizes;
        realizes = value;
        if(eNotificationRequired()) {
            eNotify(new ENotificationImpl(this,
                    Notification.SET, 3,
                    old, realizes));
        }
    }

    @Override
    public ComposableElement getType() {
        return type;
    }

    @Override
    public void setType(ComposableElement value) {
        ComposableElement old = type;
        type = value;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this,
                    Notification.SET, 4,
                    old, type));
        }
    }

    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case 0:
                return getRoleName();
            case 1:
                return getLowerBound();
            case 2:
                return getUpperBound();
            case 3:
                return getRealizes();
            case 4:
                return getType();

        }
        return super.eGet(featureID, resolve, coreType);
    }

    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case 0:
                setRoleName((String)newValue);
                return;
            case 1:
                setRealizes((org.ocl.face.conceptual.model.Composition) newValue);
                return;
            case 2:
                setLowerBound((double) newValue);
                return;
            case 3:
                setUpperBound((double) newValue);
                return;
            case 4:
                setType((ComposableElement) newValue);
                return;
        }
        super.eSet(featureID, newValue);
    }
}
