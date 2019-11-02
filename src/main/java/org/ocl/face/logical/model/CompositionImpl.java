package org.ocl.face.logical.model;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.ocl.extlibrary.impl.ItemImpl;
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
                    Notification.SET, FaceLogicalPackage.COMPOSITION_ROLE_NAME,
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
                    Notification.SET, FaceLogicalPackage.COMPOSITION_LOWER_BOUND,
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
                    Notification.SET, FaceLogicalPackage.COMPOSITION_UPPER_BOUND,
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
                    Notification.SET, FaceLogicalPackage.COMPOSITION_REALIZES,
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
                    Notification.SET, FaceLogicalPackage.COMPOSITION_TYPE,
                    old, type));
        }
    }

    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case FaceLogicalPackage.COMPOSITION_ROLE_NAME:
                return getRoleName();
            case FaceLogicalPackage.COMPOSITION_REALIZES:
                return getRealizes();
            case FaceLogicalPackage.COMPOSITION_LOWER_BOUND:
                return getLowerBound();
            case FaceLogicalPackage.COMPOSITION_UPPER_BOUND:
                return getUpperBound();
            case FaceLogicalPackage.COMPOSITION_TYPE:
                return getType();

        }
        return super.eGet(featureID, resolve, coreType);
    }

    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case FaceLogicalPackage.COMPOSITION_ROLE_NAME:
                setRoleName((String)newValue);
                return;
            case FaceLogicalPackage.COMPOSITION_REALIZES:
                setRealizes((org.ocl.face.conceptual.model.Composition) newValue);
                return;
            case FaceLogicalPackage.COMPOSITION_LOWER_BOUND:
                setLowerBound((double) newValue);
                return;
            case FaceLogicalPackage.COMPOSITION_UPPER_BOUND:
                setUpperBound((double) newValue);
                return;
            case FaceLogicalPackage.COMPOSITION_TYPE:
                setType((ComposableElement) newValue);
                return;
        }
        super.eSet(featureID, newValue);
    }
}
