package org.ocl.face.logical.model;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.ocl.face.conceptual.model.Observable;
import org.ocl.face.logical.FaceLogicalPackage;

public class MeasurementImpl extends ComposableElementImpl implements Measurement{
    @Override
    protected EClass eStaticClass() {
        return FaceLogicalPackage.Literals.MEASUREMENT;
    }
    private Observable realizes;
    @Override
    public Observable getRealizes() {
        return realizes;
    }

    @Override
    public void setRealizes(Observable value) {
        Observable old= realizes;
        this.realizes = value;
        if(eNotificationRequired()) {
            eNotify(new ENotificationImpl(this,
                    Notification.SET, FaceLogicalPackage.MEASUREMENT_REALIZES,
                    old, realizes));
        }
    }

    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case FaceLogicalPackage.MEASUREMENT_REALIZES:
                return getRealizes();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case FaceLogicalPackage.MEASUREMENT_REALIZES:
                setRealizes((Observable) newValue);
                return;
        }
        super.eSet(featureID, newValue);
    }
}
