package org.ocl.face.logical.model;

import org.ocl.face.Item;

public interface Composition extends Item {
    String getRoleName();
    void setRoleName(String roleName);

    double getLowerBound();
    void setLowerBound(double value);

    double getUpperBound();
    void setUpperBound(double value);

    org.ocl.face.conceptual.model.Composition getRealizes();
    void setRealizes(org.ocl.face.conceptual.model.Composition value);

    ComposableElement getType();
    void setType(ComposableElement value);
}
