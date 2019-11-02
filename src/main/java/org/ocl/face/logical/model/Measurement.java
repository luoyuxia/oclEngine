package org.ocl.face.logical.model;

import org.ocl.face.conceptual.model.Observable;

public interface Measurement extends ComposableElement{

    Observable getRealizes();

    void setRealizes(Observable value);
}
