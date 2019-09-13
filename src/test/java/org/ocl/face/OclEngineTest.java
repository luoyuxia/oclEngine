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
import org.ocl.face.uop.Alias;
import org.ocl.face.uop.FaceUopFactory;
import org.ocl.face.uop.FaceUopFactoryImpl;
import org.ocl.face.uop.FaceUopPackage;
import org.ocl.face.xml.FaceXmlParser;
import org.ocl.main.FaceTest;

import java.io.InputStream;
import java.util.List;

public class OclEngineTest {
    private FaceUopFactory faceUopFactory;
    private OCL ocl;
    private FaceXmlParser faceXmlParser;

    @Before
    public void setUp() {
        faceUopFactory = FaceUopFactoryImpl.init();
        EPackage.Registry registry = new EPackageRegistryImpl();
        registry.put(FaceUopPackage.eNS_PREFIX, FaceUopPackage.eINSTANCE);
        EcoreEnvironmentFactory environmentFactory = new EcoreEnvironmentFactory(registry);
        ocl = OCL.newInstance(environmentFactory);
        faceXmlParser = new FaceXmlParser();
    }


    @Test
    public void testSingleObject() {
        Alias alias = faceUopFactory.createAlias();
        try(InputStream in = FaceTest.class.getResourceAsStream("/uop.ocl")) {
            OCLInput document = new OCLInput(in);
            List<Constraint> constraints = ocl.parse(document);
            for (Constraint next : constraints) {
                OCLExpression<EClassifier> body = next.getSpecification().getBodyExpression();
                alias.setName("alias_test");
                Assert.assertTrue(ocl.check(alias, body));
                alias.setName("abstract");
                Assert.assertFalse(ocl.check(alias, body));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testWithOCLAndFaceFile() {
        List<XmlItem> xmlItems = faceXmlParser.getAllXmlItem(this.getClass().getResourceAsStream("/faceTest.face"));
        try(InputStream inputStream = FaceTest.class.getResourceAsStream("/uop.ocl")) {
            OCLInput document = new OCLInput(inputStream);
            List<Constraint> constraints = ocl.parse(document);
            for (Constraint next : constraints) {
                Class constraintClass = next.getSpecification().getContextVariable().getType().getInstanceClass();
                xmlItems.forEach(item -> {
                    if (constraintClass.isInstance(item)) {
                        System.out.println(ocl.check(item, next.getSpecification().getBodyExpression()));
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
