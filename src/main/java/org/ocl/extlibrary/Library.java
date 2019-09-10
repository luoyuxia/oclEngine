package org.ocl.extlibrary;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

public interface Library extends EObject {
    EList<Book> getBooks();
    EList<Library> getBranches();
}
