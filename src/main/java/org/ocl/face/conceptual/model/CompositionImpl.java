package org.ocl.face.conceptual.model;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.ocl.face.ItemImpl;
import org.ocl.face.conceptual.FaceConceptualPackage;
import org.ocl.face.logical.model.ComposableElement;

public class CompositionImpl extends ItemImpl implements Composition {
    @Override
    protected EClass eStaticClass() {
        return FaceConceptualPackage.Literals.COMPOSITION;
    }
    protected double lowerBound = 0.0;
    protected double upperBound = 0.0;
    protected ComposableElement type;

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
                    Notification.SET, 0,
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
                    Notification.SET, 1,
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
                    Notification.SET, 2,
                    old, type));
        }
    }

    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case 0:
                return getLowerBound();
            case 1:
                return getUpperBound();
            case 2:
                return getType();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case 0:
                 setLowerBound((double)newValue);
                 return;
            case 1:
                setUpperBound((double) newValue);
                return;
            case 2:
                setType((ComposableElement) newValue);
                return;
        }
        super.eSet(featureID, newValue);
    }
}
