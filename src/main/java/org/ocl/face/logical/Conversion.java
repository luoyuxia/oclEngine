package org.ocl.face.logical;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EObject;
import org.ocl.face.Item;

import java.util.Map;

public interface Conversion extends Item {
    EObject getSource();
    void setSource(EObject source);

    EObject getDestination();
    void setDestination(EObject destination);

    boolean sourceImpliesDestination(DiagnosticChain diagnosticChain, Map<Object, Object> context);
}
