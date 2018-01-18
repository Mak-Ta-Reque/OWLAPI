import org.semanticweb.elk.owlapi.ElkReasonerFactory;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.reasoner.OWLReasoner;


import java.util.Set;

public class OWLClassTools {

    private static OWLOntology ontology;
    private static OWLClass _class;
    private static OWLOntologyManager manager;
    public static OWLReasoner reasoner;

    public OWLClassTools(OWLOntology ontology, OWLClass _class){
        this.ontology = ontology;
        this._class =_class;
        this.manager = ontology.getOWLOntologyManager();
        this.reasoner = new ElkReasonerFactory().createReasoner(ontology);
    }

    public  static  Set<OWLClass> subClass(){
        return  reasoner.getSubClasses(_class,true).getFlattened();
    }

    public static Set<OWLClass> superClass(){
        return  reasoner.getSuperClasses(_class,true).getFlattened();
    }
}
