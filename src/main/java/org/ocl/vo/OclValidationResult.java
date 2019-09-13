package org.ocl.vo;

public class OclValidationResult {
    public boolean isValid;
    public OclValidationResult(boolean isValid) {
        this.isValid = isValid;
    }

    public static OclValidationResult validResult() {
        return new OclValidationResult(true);
    }

    public static OclValidationResult invalidResult() {
        return new OclValidationResult(false);
    }
}
