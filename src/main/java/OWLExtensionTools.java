
import org.semanticweb.owlapi.model.OWLClass;
import java.util.Set;


public class OWLExtensionTools {
    OntologyInitiator initiator;
    OWLClass subClassReference;
    OWLClass superClass ;

    public OWLExtensionTools(OntologyInitiator initiator) {
        this.initiator = initiator;
        subClassReference = initiator.getSubClassReference();
        superClass = initiator.getSuperClass();
    }
    public void extend(){
        //OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
        //OWLDataFactory factory = initiator.extraOntology.getOWLOntologyManager().getOWLDataFactory();
        Set<OWLClass> subClasses = new OWLClassTools(initiator.extraOntology, subClassReference).subClass();
        SubClassExtension subClassExtension = new SubClassExtension(initiator);
        for (OWLClass _class : subClasses){
            if (! _class.isOWLThing() || !_class.isOWLNothing() ){
                switch (ExtensionProparty.extensionDepth){
                    case 0 :
                        subClassExtension.addSubclass(superClass, _class);
                        break;
                    case 1 :
                        subClassExtension.addSubclass(superClass, _class);
                        subClassReference = _class;
                        superClass = _class;
                        ExtensionProparty.extensionDepth -= 1;
                        extend();
                        break;
                    case 2 :
                        subClassExtension.addSubclass(superClass, _class);
                        subClassReference = _class;
                        superClass = _class;
                        ExtensionProparty.extensionDepth -= 1;
                        extend();
                        break;

                    default :
                        System.out.println("Please define a valid value for the depth oof the extension");
                        break;
                }
            }


        }

    }
}
