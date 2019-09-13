package org.ocl.main;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageRegistryImpl;
import org.eclipse.ocl.OCLInput;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.EcoreEnvironmentFactory;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.expressions.OCLExpression;
import org.ocl.face.FaceFactory;
import org.ocl.face.FacePackage;
import org.ocl.face.uop.Alias;

import java.io.InputStream;
import java.util.List;

public class FaceTest {
    public static void main(String[] args) throws Exception {
        Alias alias = FaceFactory.eINSTANCE.createAlias();
        EPackage.Registry registry = new EPackageRegistryImpl();
        registry.put(FacePackage.eNS_PREFIX, FacePackage.eINSTANCE);
        EcoreEnvironmentFactory environmentFactory = new EcoreEnvironmentFactory(registry);
        OCL ocl = OCL.newInstance(environmentFactory);

        try(InputStream in = FaceTest.class.getResourceAsStream("/uop.ocl")) {
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
