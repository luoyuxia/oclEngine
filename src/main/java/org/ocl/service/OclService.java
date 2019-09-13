package org.ocl.service;

import org.eclipse.ocl.ParserException;

import java.io.InputStream;

public interface OclService {
    boolean validate(InputStream oclInputStream, InputStream modelInputStream) throws ParserException;
}
