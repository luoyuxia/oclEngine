package org.ocl.extlibrary;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.ocl.extlibrary.impl.EXTLibraryPackageImpl;

public interface EXTLibraryPackage extends EPackage {
    String eNAME = "extlibrary"; //$NON-NLS-1$
    String eNS_URI = "http:///org/eclipse/ocl/examples/tests/extlibrary.ecore/1.0.0"; //$NON-NLS-1$
    String eNS_PREFIX = "extlib"; //$NON-NLS-1$

    int LIBRARY = 1;
    int LIBRARY__BOOKS = 3;
    int LIBRARY__BRANCHES = 4;
    int LIBRARY__PARENT_BRANCH = 5;

    int BOOK = 0;
    int BOOK__TITLE = 0;

    int ITEM = 2;
    int ITEM__PUBLICATION_DATE = 0;



    EXTLibraryPackage eINSTANCE = EXTLibraryPackageImpl.init();


    interface Literals {
        EClass BOOK = eINSTANCE.getBook();
        EClass ITEM = eINSTANCE.getItem();
    }

    EClass getItem();

    EClass getBook();

}
