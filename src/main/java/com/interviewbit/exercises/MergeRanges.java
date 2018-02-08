package com.interviewbit.exercises;

import java.util.ArrayList;

public class MergeRanges implements ProblemInterface {
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
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> result = new ArrayList<Interval>();
        boolean interval_copied = false;
        for(int i = 0; i < intervals.size(); i++){
            Interval curInterval = intervals.get(i);
            if(newInterval.start > newInterval.end){
                int tmp = newInterval.start;
                newInterval.start = newInterval.end;
                newInterval.end = tmp;
            }
            
            if(Overlap(curInterval, newInterval)){
                newInterval.start = Math.min(curInterval.start, newInterval.start);
                newInterval.end = Math.max(curInterval.end, newInterval.end);
            }
            else{
                if(curInterval.start > newInterval.end && !interval_copied){
                    result.add(newInterval);
                    interval_copied = true;
                }
                result.add(curInterval);
            }            
        }
        if(!interval_copied){
            result.add(newInterval);
        }
        return result;
    }

    public void Test(){
        ArrayList<MergeRanges.Interval> intervals = new ArrayList<MergeRanges.Interval>();
        intervals.add(new MergeRanges.Interval(1,3));
        intervals.add(new MergeRanges.Interval(6,9));
        Interval newInterval = new Interval(2,5);
        ArrayList<Interval> res = insert(intervals, newInterval);

        for(int i = 0; i < res.size();i++){
            Interval interval = res.get(i);
            System.out.format("interval: %d: start: %d, end:%d%n", i, interval.start, interval.end);
        }
    }
}
