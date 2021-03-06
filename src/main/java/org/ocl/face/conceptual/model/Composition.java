package org.ocl.face.conceptual.model;

import org.ocl.face.Item;
import org.ocl.face.logical.model.ComposableElement;

public interface Composition extends Item {
    double getLowerBound();
    void setLowerBound(double value);

    double getUpperBound();
    void setUpperBound(double value);

    ComposableElement getType();
    void setType(ComposableElement value);
}
