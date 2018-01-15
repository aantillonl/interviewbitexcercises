package com.interviewbit.exercises.spiralorder;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<Integer> spiralOrder(final List<ArrayList<Integer>> A) {
        int h = A.size();
        int w = A.get(0).size();
        
        ArrayList<Integer> r = new ArrayList<Integer>(h*w);
        // Looping through layer

        int layers = (int)Math.min(Math.ceil((double)w/2), Math.ceil((double)h/2));
        for(int l = 0; l < layers; l++){
            // print top
            for (int t = l; t < w - l; t++) {
                r.add(A.get(l).get(t));
            }
            // right side
            for(int rs = l + 1; rs < h - l - 1; rs++){
                r.add(A.get(rs).get(w-l-1));
            }    
            //bottom
            for(int b = w - l - 1; b > l; b--){
                r.add(A.get(h - l - 1).get(b));
            }            
            //left side
            for(int ls = h - l - 1; ls > l; ls--){
                r.add(A.get(ls).get(l));
            }
        }

        return r;
    }
}
