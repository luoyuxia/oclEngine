package org.ocl.service.impl;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageRegistryImpl;
import org.eclipse.ocl.OCLInput;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.EcoreEnvironmentFactory;
import org.eclipse.ocl.ecore.OCL;
import org.ocl.face.XmlItem;
import org.ocl.face.conceptual.FaceConceptualPackage;
import org.ocl.face.logical.FaceLogicalPackage;
import org.ocl.face.uop.FaceUopPackage;
import org.ocl.face.xml.FaceXmlParser;
import org.ocl.service.OclService;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.List;

@Service
public class OclServiceImpl implements OclService {

    private OCL ocl;
    private FaceXmlParser faceXmlParser;

    public OclServiceImpl() {
        EPackage.Registry registry = new EPackageRegistryImpl();
        registry.put(FaceConceptualPackage.eNS_PREFIX, FaceConceptualPackage.eINSTANCE);
        registry.put(FaceLogicalPackage.eNS_PREFIX, FaceLogicalPackage.eINSTANCE);
        registry.put(FaceUopPackage.eNS_PREFIX, FaceUopPackage.eINSTANCE);
        EcoreEnvironmentFactory environmentFactory = new EcoreEnvironmentFactory(registry);
        ocl = OCL.newInstance(environmentFactory);
        faceXmlParser = new FaceXmlParser();
    }

    @Override
    public boolean validate(InputStream oclInputStream, InputStream modelInputStream) throws ParserException {
        List<XmlItem> xmlItems = faceXmlParser.getAllXmlItem(modelInputStream);
        OCLInput document = new OCLInput(oclInputStream);
        List<Constraint> constraints = ocl.parse(document);
        for (Constraint next : constraints) {
            Class constraintClass = next.getSpecification().getContextVariable().getType().getInstanceClass();
            for (XmlItem item : xmlItems) {
                if (constraintClass.isInstance(item)) {
                    if (!ocl.check(item, next.getSpecification().getBodyExpression())) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
