import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.change.OWLOntologyChangeData;
import org.semanticweb.owlapi.change.OWLOntologyChangeRecord;
import org.semanticweb.owlapi.change.SetOntologyIDData;
import org.semanticweb.owlapi.io.StringDocumentSource;
import org.semanticweb.owlapi.io.StringDocumentTarget;
import org.semanticweb.owlapi.model.*;

import java.io.File;

public class OntologyTools {

    public OntologyTools(){

    }

    public OWLOntology createOntology(String iri) throws OWLOntologyCreationException {
        OWLOntologyManager manager = create();
        return manager.createOntology(IRI.create(iri));
    }

    public OWLOntology createOntology(IRI iri) throws OWLOntologyCreationException {
        OWLOntologyManager manager = create();
        return manager.createOntology(iri);
    }

    public OWLOntologyManager create(){
        return OWLManager.createOWLOntologyManager() ;
    }

    public StringDocumentTarget saveOntology(OWLOntology ontology) throws OWLOntologyStorageException {
        StringDocumentTarget target = new StringDocumentTarget();
        ontology.getOWLOntologyManager().saveOntology(ontology, target);
        return target ;
    }

    public  OWLOntology loadOntology(StringDocumentSource documentSource) throws OWLOntologyCreationException {
        OWLOntologyManager manger = create();
        return manger.loadOntologyFromOntologyDocument(documentSource);

    }

    public  OWLOntology includeVersion(OWLOntology ontology, String version) throws OWLOntologyStorageException, OWLOntologyCreationException {
        OWLOntologyID owlID = new OWLOntologyID(ontology.getOntologyID().getOntologyIRI(),IRI.create(version).asIRI());
        OWLOntologyManager MAN =  ontology.getOWLOntologyManager();
        OWLOntologyChange change = new SetOntologyIDData(owlID).createOntologyChange(ontology);
        MAN.applyChange(change);
        return ontology;
    }
}
