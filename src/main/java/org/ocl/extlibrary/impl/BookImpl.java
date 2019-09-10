package org.ocl.extlibrary.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.ocl.extlibrary.Book;
import org.ocl.extlibrary.EXTLibraryPackage;

public class BookImpl extends ItemImpl implements Book {
    protected static final String TITLE_EDEFAULT = null;
    protected BookImpl() {
        super();
    }

    protected String title = TITLE_EDEFAULT;
    public String getTitle() {
        return title;
    }

    public void setTitle(String newTitle) {
        String oldTitle = title;
        title = newTitle;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET,
                    EXTLibraryPackage.BOOK__TITLE,
                    oldTitle, title));
    }

    @Override
    protected EClass eStaticClass() {
        return EXTLibraryPackage.Literals.BOOK;
    }

    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case EXTLibraryPackage.BOOK__TITLE:
                return getTitle();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case EXTLibraryPackage.BOOK__TITLE:
                setTitle((String)newValue);
                return;
        }
        super.eSet(featureID, newValue);
    }
}
