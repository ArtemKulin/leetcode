package number_of_matching_subsequences;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int numMatchingSubseq(String s, String[] words) {
        Map<String,Integer> map = new HashMap<>();
        for(String str : words){
            map.put(str, map.merge(str, 1, Integer::sum));
        }

        int counter = 0;
        char ch[] = s.toCharArray();

        for(String str : map.keySet()){

            char temp[] = str.toCharArray();
            int i = 0;
            int j = 0;

            while(i<ch.length && j<temp.length){
                if(ch[i]==temp[j]){
                    i++;
                    j++;
                }else{
                    i++;
                }
            }

            if(j==temp.length){
                counter+=map.get(str);
            }

        }

        return counter;
    }
}
