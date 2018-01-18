import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLOntology;

public class OntologyInitiator {
    public OWLOntology mainOntology, extraOntology;
    /* mainOntology (VDOT IN OUR CASE )is the ontology we want to extend.
    extraOntology (Ontology from repository )is the ontology where we get the extra class, and we add those classes into the main ontoloy
     */
    public OWLClass superClass, subClassReference;
    /* superClass (its in VDOT) is inside the mainOntology, Under which we add some class as subclass of that.
    subClassReference(its in ontology from repo) is the reference class, all class under this class become subclass of superClass
     */

    public OWLOntology getMainOntology() {
        return mainOntology;
    }

    public void setMainOntology(OWLOntology mainOntology) {
        this.mainOntology = mainOntology;
    }

    public OWLOntology getExtraOntology() {
        return extraOntology;
    }

    public void setExtraOntology(OWLOntology extraOntology) {
        this.extraOntology = extraOntology;
    }

    public OWLClass getSuperClass() {
        return superClass;
    }

    public void setSuperClass(OWLClass superClass) {
        this.superClass = superClass;
    }

    public OWLClass getSubClassReference() {
        return subClassReference;
    }

    public void setSubClassReference(OWLClass subClassReference) {
        this.subClassReference = subClassReference;
    }

}
