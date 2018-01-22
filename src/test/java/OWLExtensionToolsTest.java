import org.junit.Test;
import org.semanticweb.owlapi.model.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import static org.junit.Assert.*;

public class OWLExtensionToolsTest {

    @Test
    public void extend() throws OWLOntologyCreationException, FileNotFoundException, OWLOntologyStorageException {
        OntologyInitiator initiator = new OntologyInitiator();
        OWLOntology mainontology = new OntologyTools().loadOntology(new File("Destination.owl"));
        OWLOntology extraOntology = new OntologyTools().loadOntology(new File("sourceontology.owl"));
        OWLDataFactory dataFactory_super = mainontology.getOWLOntologyManager().getOWLDataFactory();
        OWLClass superclass = dataFactory_super.getOWLClass(IRI.create("http://owl.mynewontology.example#person"));
        OWLDataFactory dataFactory_extra = extraOntology.getOWLOntologyManager().getOWLDataFactory();
        OWLClass subClassReference = dataFactory_extra.getOWLClass(IRI.create("http://purl.obolibrary.org/obo/GO_0050878"));
        initiator.setMainOntology(mainontology);
        initiator.setExtraOntology(extraOntology);
        initiator.setSuperClass(superclass);
        initiator.setSubClassReference(subClassReference);
        OWLExtensionTools extensionTools = new OWLExtensionTools(initiator);
        ExtensionProparty.extensionDepth = 2;
        extensionTools.extend();
        initiator.mainOntology.saveOntology(new FileOutputStream("result2.owl"));
        System.out.println(initiator.mainOntology);
    }
}