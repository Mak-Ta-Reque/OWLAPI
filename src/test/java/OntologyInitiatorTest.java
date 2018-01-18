import org.junit.Test;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;

import java.io.File;

import static org.junit.Assert.*;

public class OntologyInitiatorTest {

    @Test
    public void getMainOntology() throws OWLOntologyCreationException {
        File mainOntology = new File("Destination.owl");
        OntologyInitiator initiator = new OntologyInitiator();
        OWLOntology ontology = new OntologyTools().loadOntology(mainOntology);
        initiator.setMainOntology(ontology);
        assertEquals(ontology,initiator.getMainOntology());
    }

    @Test
    public void getExtraOntology() throws OWLOntologyCreationException {
        File ontologySource = new File("sourceontology.owl");
        OntologyInitiator intitiator = new OntologyInitiator();
        OWLOntology ontology = new OntologyTools().loadOntology(ontologySource);
        intitiator.setExtraOntology(ontology);
        assertEquals(ontology, intitiator.getExtraOntology());
    }

    @Test
    public void getSuperClass() throws OWLOntologyCreationException {
        File mainOntology = new File("Destination.owl");
        OntologyInitiator initiator = new OntologyInitiator();
        OWLOntology ontology = new OntologyTools().loadOntology(mainOntology);
        OWLDataFactory datafactory = ontology.getOWLOntologyManager().getOWLDataFactory();
        initiator.setSuperClass(datafactory.getOWLClass(IRI.create("http://owl.mynewontology.example")));
        assertEquals(initiator.getSuperClass().toStringID(),"http://owl.mynewontology.example");
    }

    @Test
    public void getSubClassReference() throws OWLOntologyCreationException {
        File mainOntology = new File("sourceontology.owl");
        OntologyInitiator initiator = new OntologyInitiator();
        OWLOntology ontology = new OntologyTools().loadOntology(mainOntology);
        OWLDataFactory datafactory = ontology.getOWLOntologyManager().getOWLDataFactory();
        initiator.setSuperClass(datafactory.getOWLClass(IRI.create("http://owl.mynewontology.example")));
        assertEquals("http://owl.mynewontology.example",initiator.getSuperClass().toStringID());
    }
}