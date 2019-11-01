package org.ocl.main;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageRegistryImpl;
import org.eclipse.ocl.OCLInput;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.EcoreEnvironmentFactory;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.expressions.OCLExpression;
import org.ocl.face.common.FacePackage;
import org.ocl.face.logical.FaceLogicalPackage;
import org.ocl.face.uop.FaceUopFactory;
import org.ocl.face.uop.FaceUopPackage;
import org.ocl.face.uop.Alias;

import java.io.InputStream;
import java.util.List;

public class FaceTest {
    public static void main(String[] args) throws Exception {
        Alias alias = FaceUopFactory.eINSTANCE.createAlias();
        EPackage.Registry registry = new EPackageRegistryImpl();
    //    registry.put(FaceUopPackage.eNS_PREFIX, FaceUopPackage.eINSTANCE);
        registry.put(FacePackage.eNS_PREFIX, FacePackage.eINSTANCE);
        registry.put(FaceLogicalPackage.eNS_PREFIX, FaceLogicalPackage.eINSTANCE);
        EcoreEnvironmentFactory environmentFactory = new EcoreEnvironmentFactory(registry);
        OCL ocl = OCL.newInstance(environmentFactory);

        try(InputStream in = FaceTest.class.getResourceAsStream("/logical.ocl")) {
            OCLInput document = new OCLInput(in);
            List<Constraint> constraints = ocl.parse(document);
            for (Constraint next : constraints) {
                OCLExpression<EClassifier> body = next.getSpecification().getBodyExpression();
                alias.setName("sdsd");
                System.out.println(ocl.evaluate(alias, body));
                alias.setName("abstract");
                System.out.println(ocl.evaluate(alias, body));
            }
        }
    }
}
