package org.ocl.main;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageRegistryImpl;
import org.eclipse.ocl.OCLInput;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.EcoreEnvironmentFactory;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.expressions.OCLExpression;
import org.ocl.extlibrary.Book;
import org.ocl.extlibrary.EXTLibraryFactory;
import org.ocl.extlibrary.EXTLibraryPackage;

import java.io.InputStream;
import java.util.List;

public class Test {
    public static void main(String[] args) throws Exception {
        Book book = EXTLibraryFactory.eINSTANCE.createBook();
        EPackage.Registry registry = new EPackageRegistryImpl();
        registry.put(EXTLibraryPackage.eNS_URI, EXTLibraryPackage.eINSTANCE);
        EcoreEnvironmentFactory environmentFactory = new EcoreEnvironmentFactory(registry);
        OCL ocl = OCL.newInstance(environmentFactory);
        // get an OCL text file via some hypothetical API
        InputStream in = Test.class.getResourceAsStream("/parsingDocumentsExample.ocl");
        // parse the contents as an OCL document
        try {
            OCLInput document = new OCLInput(in);
            List<Constraint> constraints = ocl.parse(document);
            for (Constraint next : constraints) {
                OCLExpression<EClassifier> body = next.getSpecification().getBodyExpression();
                System.out.printf("%s: %s%n", next.getName(), body);
                if (next.getName() == null || next.getName().equals("")) {
                    continue;
                }
                book.setTitle("SDSDDS");
                System.out.println(ocl.check(book, body));
                book.setTitle("abstract");
                System.out.println(ocl.check(book, body));
            }
        } finally {
            in.close();
        }
    }
}
