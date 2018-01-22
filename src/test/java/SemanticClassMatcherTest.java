import org.junit.Test;
import org.semanticweb.owlapi.model.*;

import java.io.File;

import static org.junit.Assert.*;

public class SemanticClassMatcherTest {

    @Test
    public void findBestMatch() throws OWLOntologyCreationException {
        OntologyInitiator initiator = new OntologyInitiator();
        OWLOntology mainontology = new OntologyTools().loadOntology(new File("sourceontology.owl"));
        OWLOntology extraOntology = new OntologyTools().loadOntology(new File("sourceontology.owl"));
        OWLDataFactory dataFactory_super = mainontology.getOWLOntologyManager().getOWLDataFactory();
        OWLClass superclass = dataFactory_super.getOWLClass(IRI.create("http://purl.obolibrary.org/obo/GO_0035811"));
        OWLDataFactory dataFactory_extra = extraOntology.getOWLOntologyManager().getOWLDataFactory();
        OWLClass subClassReference = dataFactory_extra.getOWLClass(IRI.create("http://purl.obolibrary.org/obo/GO_0035818"));
        initiator.setMainOntology(mainontology);
        initiator.setExtraOntology(extraOntology);
        initiator.setSuperClass(superclass);
        initiator.setSubClassReference(subClassReference);
        SemanticClassMatcher symmatch = new SemanticClassMatcher(initiator);
        System.out.println(symmatch.findBestMatch(superclass,subClassReference,true));
    }
}