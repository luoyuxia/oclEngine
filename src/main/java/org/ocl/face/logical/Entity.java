package org.ocl.face.logical;

import org.eclipse.emf.common.util.EList;
import org.ocl.face.Item;

public interface Entity extends Item {
    EList<Composition> getComposition();
    void setComposition(EList<Composition> composition);
}
