import org.apache.commons.collections4.map.MultiValueMap;
import org.junit.Test;
import org.semanticweb.owlapi.model.*;

import java.io.File;
import java.util.Map;

import static org.junit.Assert.*;
public class AnnotationPropertyTest {

    @Test
    public void getClasInfo() throws OWLOntologyCreationException {
        AnnotationProperty anotationProperty = new AnnotationProperty();
        OntologyTools tools = new OntologyTools();
        File ontologyFile = new File("sourceontology.owl");
        OWLOntology ontology = tools.loadOntology(ontologyFile);
        OWLDataFactory df = ontology.getOWLOntologyManager().getOWLDataFactory();
        OWLClass class_ = df.getOWLClass(IRI.create("http://purl.obolibrary.org/obo/GO_0035818"));
        MultiValueMap < String, String > classProperties = anotationProperty.getClasInfo(ontology,class_);
        classProperties.put("label", "tareq");
        System.out.println(classProperties);
        assertTrue(classProperties.size()>1);
    }


    @Test
    public void getAbstractClasInfo() throws OWLOntologyCreationException {
        AnnotationProperty anotationProperty = new AnnotationProperty();
        OntologyTools tools = new OntologyTools();
        File ontologyFile = new File("sourceontology.owl");
        OWLOntology ontology = tools.loadOntology(ontologyFile);
        OWLDataFactory df = ontology.getOWLOntologyManager().getOWLDataFactory();
        OWLClass class_ = df.getOWLClass(IRI.create("http://purl.obolibrary.org/obo/GO_0035818"));
        MultiValueMap < Object, Object > classProperties = anotationProperty.getAbstractClasInfo(ontology,class_);
        System.out.println(classProperties);
        assertTrue(classProperties.size()>1);

    }
}