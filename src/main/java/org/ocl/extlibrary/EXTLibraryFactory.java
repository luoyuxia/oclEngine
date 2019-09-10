package org.ocl.extlibrary;

import org.eclipse.emf.ecore.EFactory;
import org.ocl.extlibrary.impl.EXTLibraryFactoryImpl;

public interface EXTLibraryFactory extends EFactory {
    EXTLibraryFactory eINSTANCE = EXTLibraryFactoryImpl.init();

    Book createBook();
}
