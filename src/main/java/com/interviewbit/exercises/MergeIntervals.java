package com.interviewbit.exercises;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MergeIntervals implements ProblemInterface {
    class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
     }
    
    private boolean Overlap(Interval a, Interval b){
        Interval earlier = a.start <= b.start ? a : b;
        Interval later = a.start > b.start ? a : b;
        return later.start <= earlier.end;
    }

    class IntervalComparator implements Comparator<Interval> {
        public int compare(Interval a, Interval b) {
            return a.start - b.start;
        }
    }
        // next is merged into cur
    private void merge(Interval cur, Interval next){
        cur.start = Math.min(cur.start, next.start);
        cur.end = Math.max(cur.end, next.end);
    }
    
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        Collections.sort(intervals,new IntervalComparator());
        ArrayList<Interval> result = new ArrayList<Interval>();
        result.add(intervals.get(0));

        int last_merged_index = 0;
        for(int i = 1; i < intervals.size(); i++){
            if(Overlap(intervals.get(i), result.get(last_merged_index))){
                merge(result.get(last_merged_index),intervals.get(i));
            }
            else{
                result.add(intervals.get(i));
                last_merged_index++;
            }
        }
        return result;
    }

    public void Test(){
        ArrayList<Interval> A = new ArrayList<MergeIntervals.Interval>();
        A.add(new Interval(1,3));
        A.add(new Interval(8,10));
        A.add(new Interval(15,18));
        A.add(new Interval(2,6));
        
        ArrayList<Interval> merged = merge(A);

        for(int i = 0; i < merged.size(); i++){
            Interval cur = merged.get(i);
            System.out.format("start: %d, end: %d%n", cur.start, cur.end);
        }
        
    }
}
