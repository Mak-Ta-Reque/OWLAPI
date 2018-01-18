import org.junit.Test;
import org.semanticweb.owlapi.io.OWLOntologyDocumentTarget;
import org.semanticweb.owlapi.model.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;


public class SubClassExtensionTest {

    @Test
    public void addSubclass() throws OWLOntologyCreationException, FileNotFoundException, OWLOntologyStorageException {
        OntologyInitiator initiator = new OntologyInitiator();
        OWLOntology mainontology = new OntologyTools().loadOntology(new File("Destination.owl"));
        OWLOntology extraOntology = new OntologyTools().loadOntology(new File("sourceontology.owl"));
        OWLDataFactory dataFactory_super = mainontology.getOWLOntologyManager().getOWLDataFactory();
        OWLClass superclass = dataFactory_super.getOWLClass(IRI.create("http://owl.mynewontology.example#person"));
        OWLDataFactory dataFactory_extra = extraOntology.getOWLOntologyManager().getOWLDataFactory();
        OWLClass subClassReference = dataFactory_extra.getOWLClass(IRI.create("http://purl.obolibrary.org/obo/GO_1904318"));
        initiator.setMainOntology(mainontology);
        initiator.setExtraOntology(extraOntology);
        //initiator.setSuperClass(superclass);
        //initiator.setSubClassReference(subClassReference);
        SubClassExtension extension = new SubClassExtension(initiator);
        extension.addSubclass(superclass,subClassReference);
        initiator.mainOntology.saveOntology(new FileOutputStream("result.owl"));
        System.out.println(initiator.mainOntology);

    }
}