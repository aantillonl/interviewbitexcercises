package com.interviewbit.exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class LargestNumber{

    static class StringComparator implements Comparator<String>{
        public int compare(String s1, String s2){ 

            String s1s2 = s1 + s2;
            String s2s1 = s2 + s1;

            for(int i = 0; i < s1s2.length();i++){
                if(s1s2.charAt(i) != s2s1.charAt(i))
                    return s2s1.charAt(i) - s1s2.charAt(i) ;
            }
            return 0;
            /*
            String shortest = s1.length() <= s2.length() ? s1:s2;
            int ptr_s1, ptr_s2;
            ptr_s1 = ptr_s2 = 0;
            
            while(ptr_s1 < s1.length() && ptr_s2 < s2.length()){
                if(s1.charAt(ptr_s1) - s2.charAt(ptr_s2) != 0){
                    return s2.charAt(ptr_s2) - s1.charAt(ptr_s1);
                }
                else {
                    ptr_s1++;
                    ptr_s2++;
                    if(s1.equals(shortest) && ptr_s1 == s1.length())
                        ptr_s1 = 0;
                    else if(s2.equals(shortest) && ptr_s2 == s2.length())
                        ptr_s2 = 0;                    
                }
            }
            return 0;
            */
        }
    }

    static String largestNumber(final List<Integer> A){
        ArrayList<String> A_s = new ArrayList<String>();
        for(int i = 0; i < A.size(); i ++)
            A_s.add(A.get(i).toString());
        Collections.sort(A_s,new StringComparator());

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < A_s.size(); i++){
            if(A_s.get(i).equals("0") && sb.length() == 0){
                continue;
            }
            else{
                sb.append(A_s.get(i));
            }
        }
        return sb.length() > 0 ? sb.toString(): "0";
    }

    static String Test(){
        return largestNumber(new ArrayList<Integer>(Arrays.asList( 931, 94, 209, 448, 716, 903, 124, 372, 462, 196, 715, 802, 103, 740, 389, 872, 615, 638, 771, 829, 899, 999, 29, 163, 342, 902, 922, 312, 326, 817, 288, 75, 37, 286, 708, 589, 975, 747, 743, 699, 743, 954, 523, 989, 114, 402, 236, 855, 323, 79, 949, 176, 663, 587, 322)));
    }
}