package org.ocl.face.logical;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.ocl.face.logical.model.*;

public class FaceLogicalFactoryImpl extends EFactoryImpl implements FaceLogicalFactory {
    public static FaceLogicalFactory init() {
        try {
            FaceLogicalFactory faceLogicalFactory = (FaceLogicalFactory) EPackage.Registry.INSTANCE.getEFactory(FaceLogicalPackage.eNS_URI);
            if (faceLogicalFactory != null) {
                return faceLogicalFactory;
            }
        } catch (Exception e) {
            EcorePlugin.INSTANCE.log(e);
        }
        return new FaceLogicalFactoryImpl();
    }

    public FaceLogicalFactoryImpl() {
        super();
    }


    @Override
    public Association createAssociation() {
        return new AssociationImpl();
    }

    @Override
    public CharacteristicProjection createCharacteristicProjection() {
        return new CharacteristicProjectionImpl();
    }

    @Override
    public Composition createComposition() {
        return new CompositionImpl();
    }

    @Override
    public Constraint createConstraint() {
        return new ConstraintImpl();
    }

    @Override
    public Conversion createConversion() {
        return new ConversionImpl();
    }

    @Override
    public Element createElement() {
        return new ElementImpl();
    }

    @Override
    public Entity createEntity() {
        return new EntityImpl();
    }

    @Override
    public InformationElement createInformationElement() {
        return new InformationElementImpl();
    }

    @Override
    public Characteristic createCharacteristic() {
        return new CharacteristicImpl();
    }

    @Override
    public Measurement createMeasurement() {
        return new MeasurementImpl();
    }


}
