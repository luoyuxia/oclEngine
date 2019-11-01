package org.ocl.face.logical;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.ocl.extlibrary.impl.ItemImpl;

import java.util.Map;

public class ConversionImpl extends ItemImpl implements Conversion {
    private EObject source;
    private EObject destination;
    @Override
    protected EClass eStaticClass() {
        return FaceLogicalPackage.Literals.CONVERSION;
    }

    @Override
    public EObject getSource() {
        return source;
    }

    @Override
    public void setSource(EObject value) {
        EObject oldValue = this.source;
        this.source = value;
        if(eNotificationRequired()) {
            eNotify(new ENotificationImpl(this,
                    Notification.SET, FaceLogicalPackage.ENTITY_COMPOSITION,
                    oldValue, source));
        }
    }

    @Override
    public EObject getDestination() {
        return destination;
    }

    @Override
    public void setDestination(EObject value) {
        EObject oldValue = this.destination;
        this.destination = value;
        if(eNotificationRequired()) {
            eNotify(new ENotificationImpl(this,
                    Notification.SET, FaceLogicalPackage.CONVERSION_DESTINATION,
                    oldValue, destination));
        }
    }

    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case FaceLogicalPackage.CONVERSION_SOURCE:
                return getSource();
            case FaceLogicalPackage.CONVERSION_DESTINATION:
                return getDestination();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case FaceLogicalPackage.CONVERSION_SOURCE:
                setSource((EObject) newValue);
                return;
            case FaceLogicalPackage.CONVERSION_DESTINATION:
                setDestination((EObject) newValue);
                return;
        }
        super.eSet(featureID, newValue);
    }

    @Override
    public boolean sourceImpliesDestination(DiagnosticChain diagnosticChain, Map<Object, Object> context) {
        //todo to check the implies logic
        return true;
    }
}
