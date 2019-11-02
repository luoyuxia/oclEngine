package org.ocl.face.conceptual.model;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.ocl.extlibrary.impl.ItemImpl;
import org.ocl.face.conceptual.FaceConceptualPackage;
import org.ocl.face.logical.model.ComposableElement;

public class CompositionImpl extends ItemImpl implements Composition {
    private double lowerBound = 0.0;
    private double upperBound = 0.0;
    private ComposableElement type;

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
                    Notification.SET, FaceConceptualPackage.COMPOSITION_LOWER_BOUND,
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
                    Notification.SET, FaceConceptualPackage.COMPOSITION_UPPER_BOUND,
                    old, upperBound));
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
                    Notification.SET, FaceConceptualPackage.COMPOSITION_TYPE,
                    old, type));
        }
    }

    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case FaceConceptualPackage.COMPOSITION_LOWER_BOUND:
                return getLowerBound();
            case FaceConceptualPackage.COMPOSITION_UPPER_BOUND:
                return getUpperBound();
            case FaceConceptualPackage.COMPOSITION_TYPE:
                return getType();

        }
        return super.eGet(featureID, resolve, coreType);
    }

    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case FaceConceptualPackage.COMPOSITION_LOWER_BOUND:
                 setLowerBound((double)newValue);
                 return;
            case FaceConceptualPackage.COMPOSITION_UPPER_BOUND:
                setUpperBound((double) newValue);
            case FaceConceptualPackage.COMPOSITION_TYPE:
                setType((ComposableElement) newValue);
        }
        super.eSet(featureID, newValue);
    }
}
