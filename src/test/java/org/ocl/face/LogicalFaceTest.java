package org.ocl.face;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageRegistryImpl;
import org.eclipse.ocl.OCLInput;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.EcoreEnvironmentFactory;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.expressions.OCLExpression;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.ocl.face.conceptual.FaceConceptualFactory;
import org.ocl.face.conceptual.FaceConceptualFactoryImpl;
import org.ocl.face.conceptual.FaceConceptualPackage;
import org.ocl.face.conceptual.model.EntityImpl;
import org.ocl.face.logical.FaceLogicalFactory;
import org.ocl.face.logical.FaceLogicalFactoryImpl;
import org.ocl.face.logical.FaceLogicalPackage;
import org.ocl.face.logical.model.Composition;
import org.ocl.face.logical.model.Entity;
import org.ocl.face.uop.FaceUopFactory;
import org.ocl.face.uop.FaceUopFactoryImpl;
import org.ocl.face.uop.FaceUopPackage;

import java.io.InputStream;
import java.util.List;

public class LogicalFaceTest {
    private FaceConceptualFactory faceConceptualFactory;
    private FaceLogicalFactory faceLogicalFactory;
    private FaceUopFactory faceUopFactory;
    private OCL ocl;
    @Before
    public void setUp() {
        faceConceptualFactory = FaceConceptualFactoryImpl.init();
        faceLogicalFactory = FaceLogicalFactoryImpl.init();
        faceUopFactory = FaceUopFactoryImpl.init();

        EPackage.Registry registry = new EPackageRegistryImpl();
        registry.put(FaceConceptualPackage.eNS_PREFIX, FaceConceptualPackage.eINSTANCE);
        registry.put(FaceLogicalPackage.eNS_PREFIX, FaceLogicalPackage.eINSTANCE);
        registry.put(FaceUopPackage.eNS_PREFIX, FaceUopPackage.eINSTANCE);
        EcoreEnvironmentFactory environmentFactory = new EcoreEnvironmentFactory(registry);
        ocl = OCL.newInstance(environmentFactory);
    }

    @Test
    public void testLogicalEntity() {

        org.ocl.face.conceptual.model.Entity conceptualEntity = faceConceptualFactory.createEntity();
        Entity entity = faceLogicalFactory.createEntity();
        entity.setRealizes(conceptualEntity);
        Composition composition = faceLogicalFactory.createComposition();
        composition.setType(entity);

        org.ocl.face.conceptual.model.Composition conceptualComposition = faceConceptualFactory.createComposition();
    //    conceptualComposition.setType(faceConceptualFactory.createEntity());
        conceptualComposition.setType(conceptualEntity);
        composition.setRealizes(conceptualComposition);

//        Composition composition = faceLogicalFactory.createComposition();
//        org.ocl.face.conceptual.model.Composition conceptualComposition = faceConceptualFactory.createComposition();
//        composition.setRealizes(conceptualComposition);




        try(InputStream in = LogicalFaceTest.class.getResourceAsStream("/logical_small.ocl")) {
            OCLInput document = new OCLInput(in);
            List<Constraint> constraints = ocl.parse(document);
            for (Constraint next : constraints) {
                OCLExpression<EClassifier> body = next.getSpecification().getBodyExpression();
                Assert.assertTrue(ocl.check(composition, body));

                org.ocl.face.conceptual.model.Entity falseEntity = faceConceptualFactory.createEntity();
                ((EntityImpl)falseEntity).setLowerBound(2.0);
                conceptualComposition.setType(falseEntity);
                composition.setRealizes(conceptualComposition);
                Assert.assertFalse(ocl.check(composition, body));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
