import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.*;

import java.util.Set;

public class SubClassExtension {
    private OntologyInitiator initiator;

    public SubClassExtension(OntologyInitiator initiator){
        this.initiator = initiator;
    }

    public void addSubclass(OWLClass superClass, OWLClass subClass){
        OWLOntology mainOntlogy = initiator.mainOntology;

        OWLOntology extraOntlogy = initiator.extraOntology;


        OWLOntologyManager manager = OWLManager.createOWLOntologyManager();

        OWLDataFactory factory = manager.getOWLDataFactory();

        OWLAxiom axiom = factory.getOWLSubClassOfAxiom(subClass,superClass);
        AddAxiom addAxiom = new AddAxiom(mainOntlogy, axiom);
        Set<OWLAnnotationAssertionAxiom> properties = extraOntlogy.getAnnotationAssertionAxioms(subClass.getIRI());
        for (OWLAnnotationAssertionAxiom property : properties){
            manager.applyChange(new AddAxiom(mainOntlogy,property));
        }
        manager.applyChange(addAxiom);

    }
}
