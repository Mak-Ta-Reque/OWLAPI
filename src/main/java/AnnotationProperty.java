import org.apache.commons.collections4.map.MultiValueMap;
import org.semanticweb.owlapi.model.OWLAnnotationAssertionAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLOntology;

import java.util.HashMap;
import java.util.Map;

public class AnnotationProperty {
    public  String LABEL = "label";
    public MultiValueMap<Object,Object> getAbstractClasInfo(OWLOntology ontology, OWLClass owlClass){
        MultiValueMap<Object, Object> classProperties = new MultiValueMap<Object, Object>();
        for(OWLAnnotationAssertionAxiom asserion : ontology.getAnnotationAssertionAxioms(owlClass.getIRI())){
            classProperties.put(asserion.getProperty(), asserion.getValue());
        }
        return  classProperties;
    }

    public MultiValueMap<String,String> getClasInfo(OWLOntology ontology, OWLClass owlClass){
        MultiValueMap<String, String> classProperties = new MultiValueMap<String, String>();
        for(OWLAnnotationAssertionAxiom asserion : ontology.getAnnotationAssertionAxioms(owlClass.getIRI())){
            String property =  asserion.getProperty().toString();
            if(property.contains("#") && property.contains(">")){
                String key = property.replaceAll(".*\\#|\\>.*", "");
                String val = asserion.getValue().toString();
                classProperties.put(key,val);
            }
            if(asserion.getProperty().isLabel()){
                classProperties.put(LABEL,asserion.getValue().toString());
            }
        }
        return  classProperties;
    }
}
