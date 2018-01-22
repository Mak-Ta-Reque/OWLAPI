import info.debatty.java.stringsimilarity.Levenshtein;

public class DistanceCalculator {
    public static double convertLevensteinToPercentage(String searchWord,String owlWord){
        // Refer to https://www.linkedin.com/pulse/percentage-string-match-levenshtein-distance-jacob-parr for algorithm
        Levenshtein l = new Levenshtein();//Function for levenshtein from info.debatty.java.stringsimilarity. ; apache commans can be used as well
        double len=Math.max(searchWord.length(),owlWord.length());
        double distance=len-l.distance(searchWord, owlWord);
        if(distance==0)
            return 0;
        double percentage=(distance/len)*100;
        return percentage;
    }
}
