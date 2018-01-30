package com.interviewbit.exercises;

import java.util.HashMap;
import java.util.HashSet;

public class Jewels{
    static int numJewelsInStones(String J, String S) {
        HashMap<Character,Boolean> m = new HashMap<Character,Boolean>();
        
        for(int i = 0; i < J.length(); i++){
            m.put(J.charAt(i), false);
        }
        int myStones = 0;
        for(int i = 0; i < S.length();i++){
            if(m.containsKey(S.charAt(i))){
                myStones++;
            }
        }
        return myStones;
    }

    static int Test(){
        return numJewelsInStones("aA", "aAAbbbb");
    }
}

