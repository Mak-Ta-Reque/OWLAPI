import org.junit.Test;
import org.semanticweb.owlapi.model.*;
import java.io.File;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class OWLClassToolsTest {

    @Test
    public void subClass() throws OWLOntologyCreationException {
        OWLOntology ontology = new OntologyTools().loadOntology(new File("sourceontology.owl"));
        OWLDataFactory df = ontology.getOWLOntologyManager().getOWLDataFactory();
        OWLClass class_ = df.getOWLClass(IRI.create("http://purl.obolibrary.org/obo/GO_0098801"));
        Set<OWLClass> subclasses = new OWLClassTools(ontology,class_).subClass();
        System.out.println(subclasses);


    }
    @Test
    public void superClass() throws OWLOntologyCreationException {
        OWLOntology ontology = new OntologyTools().loadOntology(new File("sourceontology.owl"));
        OWLDataFactory df = ontology.getOWLOntologyManager().getOWLDataFactory();
        OWLClass class_ = df.getOWLClass(IRI.create("http://purl.obolibrary.org/obo/GO_1904318"));
        Set<OWLClass> superlasses = new OWLClassTools(ontology,class_).superClass();
        System.out.println(superlasses);
    }
}