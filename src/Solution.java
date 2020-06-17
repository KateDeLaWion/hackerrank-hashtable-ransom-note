import java.util.HashMap;
import java.util.Hashtable;

public class Solution {
//    https://www.hackerrank.com/challenges/ctci-ransom-note/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dictionaries-hashmaps

    static void checkMagazine(String[] magazine, String[] note) {

        // my code starts here
        // check if the constraints set by the question are fit
        if ((magazine.length == 0 || note.length == 0) ||
                (magazine.length > 30_000 || note.length > 30_000)) {
            System.out.println("No");
            return;
        }

        // put magazine array into Hashtable or HashMap array
        Hashtable<String, Integer> magazineWords = new Hashtable();
        // or
//        Hashtable<String,Integer> magazineWords = new Hashtable<>();
        // or
//        HashMap<String,Integer> magazineWords = new HashMap();
        // First check if HashMap has the same word , if yes, add count by 1.
        // otherwise add that word to the HashMap.
        for (int i = 0; i < magazine.length; i++) {
            if (magazineWords.get(magazine[i]) != null) {
                int count = magazineWords.get(magazine[i]);
                magazineWords.put(magazine[i], ++count); // add 1 to count then assign so count++ is not right.
            } else {
                magazineWords.put(magazine[i], 1);
            }
        }
        //Iterate the ransom note to find match in magazineWords
        for (int j = 0; j < note.length; j++) {
            // if magazineWords doesn't  have that note word
            if (magazineWords.get(note[j]) == null) {
                System.out.println("No");
                return;
            }
            // magazineWords has that note word, so check if magazine has sufficient number of that same word
            else {
                int count = magazineWords.get(note[j]);
                // for every match the count should be >0 otherwise magazine does not have enough
                if (count > 0) {
                    magazineWords.put(note[j], --count); // minus 1 from count then assign so count-- is not right.
                } else {
                    System.out.println("No"); // magazine has the same word but count=0 so "No"
                    return;
                }
            }
        }
        System.out.println("Yes");
        // my code ends here

    }
}
