package org.ocl.face.conceptual.model;

import org.eclipse.emf.ecore.EClass;
import org.ocl.face.conceptual.FaceConceptualPackage;

public class EntityImpl extends CompositionImpl implements Entity {

    @Override
    protected EClass eStaticClass() {
        return FaceConceptualPackage.Literals.ENTITY;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof EntityImpl)) {
            return false;
        }
        EntityImpl entity = (EntityImpl)object;
        return entity.lowerBound == this.lowerBound && entity.upperBound == this.upperBound;
    }
}
