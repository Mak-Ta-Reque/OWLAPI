import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.*;

import java.util.Set;

public class SubClassExtension {
    private OntologyInitiator initiator;

    public SubClassExtension(OntologyInitiator initiator){
        this.initiator = initiator;
    }

    public void addSubclass(OWLClass superClass, OWLClass subClass){


        OWLOntologyManager manager = initiator.getMainOntology().getOWLOntologyManager();
        OWLDataFactory newdataFactory = manager.getOWLDataFactory();
        OWLAxiom axiom = newdataFactory.getOWLSubClassOfAxiom(subClass, superClass);
        AddAxiom addAxiom = new AddAxiom(initiator.getMainOntology(), axiom);
        Set<OWLAnnotationAssertionAxiom> properties =initiator.extraOntology.getAnnotationAssertionAxioms(subClass.getIRI());
        for (OWLAnnotationAssertionAxiom property : properties) {
            manager.applyChange(new AddAxiom(initiator.mainOntology, property));
        }
        manager.applyChange(addAxiom);

    }
}
