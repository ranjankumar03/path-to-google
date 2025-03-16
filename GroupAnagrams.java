import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

    private static String[] strs = {"eat","tea","tan","ate","nat","bat"};

    public static void main(String[] args){
        System.out.println(groupAnagrams(strs));
    }

    private static List<List<String>> groupAnagrams(String[] strs) {

        if(strs.length == 0) {
            return new ArrayList<List<String>>();
        }

        Map<String, List<String>> keyVal = new HashMap<>();

        for(String str : strs){
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String key = String.valueOf(ch);
            
            if(!keyVal.containsKey(key))
            {
                keyVal.put(key, new ArrayList<String>());
            }

            keyVal.get(key).add(str);

        }

        return new ArrayList<List<String>>(keyVal.values());

    }
    
}
