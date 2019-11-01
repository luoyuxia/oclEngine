package org.ocl.face.logical;
import org.eclipse.emf.common.util.EList;
import org.ocl.face.Item;

public interface Association extends Item {
    EList<Characteristic> getComposition();
    void setComposition(EList<Characteristic> composition);

    EList<Characteristic> getAssociatedEntity();
    void setAssociatedEntity(EList<Characteristic> associatedEntity);

}
