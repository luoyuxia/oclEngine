package org.ocl.extlibrary.impl;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.ocl.extlibrary.Book;
import org.ocl.extlibrary.EXTLibraryPackage;
import org.ocl.extlibrary.Library;

public class LibraryImpl extends EObjectImpl implements Library {
    protected EList<Book> books;
    protected EList<Library> branches;
    protected LibraryImpl() {
        super();
    }
    public EList<Book> getBooks() {
        if (books == null) {
            books = new EObjectResolvingEList<Book>(Book.class, this, EXTLibraryPackage.LIBRARY__BOOKS);
        }
        return books;
    }

    public EList<Library> getBranches() {
        if (branches == null) {
            branches = new EObjectContainmentWithInverseEList.Resolving<Library>(Library.class, this,
                    EXTLibraryPackage.LIBRARY__BRANCHES,
                    EXTLibraryPackage.LIBRARY__PARENT_BRANCH);
        }
        return branches;
    }
}
