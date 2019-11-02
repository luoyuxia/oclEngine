package org.ocl.face.logical.model;

import org.eclipse.emf.common.util.EList;

public interface Entity extends ComposableElement {
    EList<Composition> getComposition();
    void setComposition(EList<Composition> composition);

    org.ocl.face.conceptual.model.Entity getRealizes();

    void setRealizes(org.ocl.face.conceptual.model.Entity value);
}
