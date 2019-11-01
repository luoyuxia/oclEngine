package org.ocl.face.logical.validator;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.ocl.face.logical.FaceLogicalPackage;

import java.util.Map;

public class ConversionValidator extends EObjectValidator {
    public static ConversionValidator INSTANCE = new ConversionValidator();

    public static final String DIAGNOSTIC_SOURCE = "conversion"; //$NON-NLS-1$

    private static final int CONVERSION_SOURCE_DESTINATION_IMPLIES = 1;

    public ConversionValidator() {
        super();
    }

    @Override
    protected EPackage getEPackage() {
        return FaceLogicalPackage.eINSTANCE;
    }

    @Override
    protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics, Map<Object, Object> context) {
        switch (classifierID) {
            case FaceLogicalPackage.CONVERSION:
                return true;
            default:
                return false;
        }
    }

}
