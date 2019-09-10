package org.ocl.extlibrary.impl;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.ocl.extlibrary.Book;
import org.ocl.extlibrary.EXTLibraryFactory;
import org.ocl.extlibrary.EXTLibraryPackage;
import org.ocl.extlibrary.Library;

public class EXTLibraryFactoryImpl extends EFactoryImpl implements EXTLibraryFactory {

    public static EXTLibraryFactory init() {
        try {
            EXTLibraryFactory theEXTLibraryFactory = (EXTLibraryFactory) EPackage.Registry.INSTANCE.getEFactory(EXTLibraryPackage.eNS_URI);
            if (theEXTLibraryFactory != null) {
                return theEXTLibraryFactory;
            }
        }
        catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new EXTLibraryFactoryImpl();
    }

    public EXTLibraryFactoryImpl() {
        super();
    }


    public Book createBook() {
        BookImpl book = new BookImpl();
        return book;
    }

    public Library createLibrary() {
        LibraryImpl library = new LibraryImpl();
        return library;
    }




}
