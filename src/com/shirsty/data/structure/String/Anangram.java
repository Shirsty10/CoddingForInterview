package com.shirsty.data.structure.String;

import java.util.*;

public class Anangram {

    //LeetCode - 49. Group Anagrams
    /*Given an array of strings strs, group the anagrams together. You can return the answer in any order.

      An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
      typically using all the original letters exactly once.

      Example 1:
      Input: strs = ["eat","tea","tan","ate","nat","bat"]
      Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
     */

    //With sorting
    public List<List<String>> groupAnagrams(String[] strs){
        List<List<String>> ans = new ArrayList<>();

        Map<String,List<String>> mp = new HashMap<>();

        for(int i=0;i< strs.length;i++) {
            char[] words = strs[i].toCharArray();
            Arrays.sort(words);
            String st = new String(words);

            if (!mp.containsKey(st)) {
                mp.put(st, new ArrayList<>());
            }
            mp.get(st).add(strs[i]);

        }
        for(List<String> list: mp.values()){
            ans.add(list);
        }

        return ans;
    }
}
