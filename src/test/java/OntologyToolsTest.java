import com.google.common.base.Optional;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.semanticweb.owlapi.io.StringDocumentSource;
import org.semanticweb.owlapi.io.StringDocumentTarget;
import org.semanticweb.owlapi.model.*;


import java.io.File;

import static org.junit.Assert.*;

public class OntologyToolsTest {
    static Logger log = Logger.getLogger(OntologyToolsTest.class);


    @org.junit.Test
    public void createOntology() throws OWLOntologyCreationException {
        BasicConfigurator.configure();
        OntologyTools ontotoTools = new OntologyTools();
        String iri = "www.mak.com/exampleOntology.owl";
        OWLOntology ontology = ontotoTools.createOntology(iri);
        assertEquals(ontology.getOWLOntologyManager().getOntologyDocumentIRI(ontology).toString(),iri);
    }

    @org.junit.Test
    public void createOntology1() throws OWLOntologyCreationException {
        OntologyTools ontotoTools = new OntologyTools();
        String iri = "www.mak.com/exampleOntology.owl";
        IRI IRI = org.semanticweb.owlapi.model.IRI.create(iri);
        OWLOntology ontology = ontotoTools.createOntology(IRI);
        assertEquals(ontology.getOWLOntologyManager().getOntologyDocumentIRI(ontology),IRI);
    }

    @org.junit.Test
    public void create() {
        OntologyTools ontologyTools = new OntologyTools();
        assertNotNull(ontologyTools.create());

    }

    @org.junit.Test
    public void saveOntology() throws OWLOntologyCreationException, OWLOntologyStorageException {
        OntologyTools ontoTools = new OntologyTools();
        String iri = "http://www.mak.com/exampleOntology.owl";
        IRI IRI = org.semanticweb.owlapi.model.IRI.create(iri);
        OWLOntology ontology = ontoTools.createOntology(IRI);
        StringDocumentTarget ontologxStringDocTarget = ontoTools.saveOntology(ontology);
        assertEquals(ontoTools.loadOntology(new StringDocumentSource(ontologxStringDocTarget.toString())),ontology);

    }

    @Test
    public void loadOntology() throws OWLOntologyCreationException {
        OntologyTools tools = new OntologyTools();
        File ontologyFile = new File("Destination.owl");
        OWLOntology ontology = tools.loadOntology(ontologyFile);
        assertEquals(ontology.getOntologyID().getOntologyIRI().get(),IRI.create("http://owl.mynewontology.example"));

    }

    @Test
    public void includeVersion() throws OWLOntologyCreationException, OWLOntologyStorageException {
        OntologyTools ontotoTools = new OntologyTools();
        String version = "3.1";
        Optional<String> gender = Optional.of("MALE");
        System.out.println(gender);
        String iri = "www.mak.com/exampleOntology.owl";
        OWLOntology ontology = ontotoTools.createOntology(iri);
        ontology = ontotoTools.includeVersion(ontology, version);
        System.out.println(ontology);
        assertNotNull(ontology.getOntologyID().getVersionIRI());


    }
}