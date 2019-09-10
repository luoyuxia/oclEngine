package org.ocl.extlibrary.impl;

import org.eclipse.emf.ecore.*;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.ocl.extlibrary.Book;
import org.ocl.extlibrary.EXTLibraryFactory;
import org.ocl.extlibrary.EXTLibraryPackage;
import org.ocl.extlibrary.Library;

public class EXTLibraryPackageImpl  extends EPackageImpl implements EXTLibraryPackage {

    private EClass libraryEClass = null;

    private EClass bookEClass = null;

    private EClass itemEClass = null;

    /**
     * Creates an instance of the model <b>Package</b>, registered with
     * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
     * package URI value.
     * <p>Note: the correct way to create the package is via the static
     * factory method {@link #init init()}, which also performs
     * initialization of the package, or returns the registered package,
     * if one already exists.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.ecore.EPackage.Registry
     * @see #init()
     * @generated
     */
    private EXTLibraryPackageImpl() {
        super(eNS_URI, EXTLibraryFactory.eINSTANCE);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private static boolean isInited = false;


    public static EXTLibraryPackage init() {
        if (isInited) return (EXTLibraryPackage) EPackage.Registry.INSTANCE.getEPackage(EXTLibraryPackage.eNS_URI);

        // Obtain or create and register package
        Object registeredEXTLibraryPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
        EXTLibraryPackageImpl theEXTLibraryPackage = registeredEXTLibraryPackage instanceof EXTLibraryPackageImpl ? (EXTLibraryPackageImpl)registeredEXTLibraryPackage : new EXTLibraryPackageImpl();

        isInited = true;

        // Create package meta-data objects
        theEXTLibraryPackage.createPackageContents();

        // Initialize created meta-data
        theEXTLibraryPackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theEXTLibraryPackage.freeze();

        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put(EXTLibraryPackage.eNS_URI, theEXTLibraryPackage);
        return theEXTLibraryPackage;
    }

    public void initializePackageContents() {
        if (isInitialized) return;
        isInitialized = true;

        // Initialize package
        setName(eNAME);
        setNsPrefix(eNS_PREFIX);
        setNsURI(eNS_URI);

        initEClass(bookEClass, Book.class, "Book", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getBook_Title(), ecorePackage.getEString(), "title", null, 0, 1, Book.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(libraryEClass, Library.class, "Library", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getLibrary_Books(), this.getBook(), null, "books", null, 0, -1, Library.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
        initEReference(getLibrary_Branches(), this.getLibrary(), this.getLibrary_ParentBranch(), "branches", null, 0, -1, Library.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        itemEClass = createEClass(ITEM);
        createEAttribute(itemEClass, ITEM__PUBLICATION_DATE);
        // Create resource
        createResource(eNS_URI);

        // Create annotations
        // http:///org/eclipse/emf/ecore/util/ExtendedMetaData
        createExtendedMetaDataAnnotations();
    }

    public void createPackageContents() {
        if (isCreated) return;
        isCreated = true;

        bookEClass = createEClass(BOOK);
        createEAttribute(bookEClass, BOOK__TITLE);

        libraryEClass = createEClass(LIBRARY);
        createEReference(libraryEClass, LIBRARY__BOOKS);
        createEReference(libraryEClass, LIBRARY__BRANCHES);
    }



    public EAttribute getBook_Title() {
        return (EAttribute)bookEClass.getEStructuralFeatures().get(0);
    }


    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private boolean isCreated = false;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private boolean isInitialized = false;

    protected void createExtendedMetaDataAnnotations() {
        String source = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData"; //$NON-NLS-1$
    }

    public EReference getLibrary_Books() {
        return (EReference)libraryEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getLibrary_Branches() {
        return (EReference)libraryEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getLibrary_ParentBranch() {
        return (EReference)libraryEClass.getEStructuralFeatures().get(1);
    }

    public EClass getItem() {
        return itemEClass;
    }

    public EClass getBook() {
        return bookEClass;
    }

    public EClass getLibrary() {
        return libraryEClass;
    }

}
