import org.apache.commons.collections4.map.MultiValueMap;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLOntology;
import java.util.*;
public class SemanticClassMatcher {
    // Intialize the ontologyInitializer
    boolean levenshtein = false;
    public String LABEL = "label";
    public String SYNONYM = "Synonym";

    OWLOntology mainOntology, extraOntology;

    public SemanticClassMatcher(OntologyInitiator ontoInitiator) {
        this.mainOntology = ontoInitiator.mainOntology;
        this.extraOntology = ontoInitiator.extraOntology;
    }

    public boolean findBestMatch(OWLClass main_onto, OWLClass extra_onto, boolean levenshtein){
        this.levenshtein = levenshtein;
        boolean  match = false;
        AnnotationProperty anotationProperty_main = new AnnotationProperty();
        MultiValueMap< String, String > classProperties_main = anotationProperty_main.getClasInfo(mainOntology,main_onto);
        MultiValueMap< String, String > classProperties_extra = anotationProperty_main.getClasInfo(extraOntology,extra_onto);

        Iterator<String> iter1= classProperties_main.keySet().iterator();
        Collection<String> mainlist = new ArrayList<String>();
        while(iter1.hasNext()){
            String key = iter1.next();
            if ( key.contains(LABEL) ||  key.contains(SYNONYM)){
                mainlist.addAll(classProperties_main.getCollection(key));
            }
        }
        Collection<String> extralist = new ArrayList<String>();
        Iterator<String> iter2= classProperties_extra.keySet().iterator();
        while(iter2.hasNext()){
            String key = iter2.next();
            if ( key.contains(LABEL) ||  key.contains(SYNONYM)){
                extralist.addAll(classProperties_extra.getCollection(key));
            }
        }

        if (levenshtein){

            Iterator<String> iterator1 = mainlist.iterator();
            while(iterator1.hasNext()){

                Iterator<String> iterator2 = extralist.iterator();
                String word = iterator1.next();
                while (iterator2.hasNext()){
                    double distance = DistanceCalculator.convertLevensteinToPercentage(word, iterator2.next());
                    System.out.println(distance);
                    if(distance >= ExtensionProparty.levenshtein_match_per){
                        match = true;
                        break;
                    }

                }
                if(match){
                    break;
                }
            }
        }else{
            System.out.println("Not implemented");
        }
        System.out.println(extralist);
        System.out.println(mainlist);
        return match;
    }




}
