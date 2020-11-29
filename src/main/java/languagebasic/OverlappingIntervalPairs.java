package languagebasic;

import javax.swing.*;
import java.util.ArrayList;

public class OverlappingIntervalPairs {
     /*
    Given a collection of intervals (an interval is defined by start and end property), implement a method to return all overlapping interval pairs.
    Example:
    Given [11, 15], [3, 9], [1, 4], [15, 18] => return [11, 15] and [15, 18], [3, 9] and [1, 4].
    Given [1, 5], [6, 8], [5, 12], [2, 6] => return [1, 5] and [5, 12], [1, 5] and [2, 6], [6, 8] and [5, 12], [5, 12] and [2, 6]
     */


     private boolean isOverlap(Interval a, Interval b){
         return (b.getStartInterval() >= a.getStartInterval()) && (b.getStartInterval()<=a.getEndInterval());
     }


    private String printInterval(Interval interval){
        return "[" + interval.getStartInterval() + ", " + interval.getEndInterval() + "]";
    }

    private String printOverlapInterval(Interval a, Interval b){
        if (isOverlap(a, b)){
            return printInterval(a) + " and " + printInterval(b);
        }
        return "";
    }

    public String[] getInputIntervals(Interval[] intervals){
        ArrayList<String> result = new ArrayList<>();
        for(Interval in: intervals){
            result.add("[" + in.getStartInterval() + ", " + in.getEndInterval() + "]");
        }
        return result.toArray(new String[]{});
    }

     public String[] getAllOverlapPairs(Interval[] intervals){
         ArrayList<String> result = new ArrayList<>();
        for(int i=0; i< intervals.length; i++){
            for (int j = 0; j<intervals.length; j++){
                if (i==j) continue;
                if (isOverlap(intervals[i], intervals[j])){
                    //Not add if duplication
                    if (!result.contains(printOverlapInterval(intervals[i], intervals[j]))) {
                        result.add(printOverlapInterval(intervals[i], intervals[j]));
                    }
                }
            }
        }


        return result.toArray(new String[]{});
     }

    public static void main(String[] args) {

        Interval[] interval = {new Interval(11, 15), new Interval(3, 9),
                new Interval(1, 4), new Interval(15,18), new Interval(2, 7), new Interval(1, 20),
                new Interval(20, 30), new Interval(40, 50), new Interval(20, 30)};
        //Interval[] interval = {new Interval(11, 15)};
        OverlappingIntervalPairs overlap = new OverlappingIntervalPairs();

        System.out.println("Input intervals: ");
        String[] in = overlap.getInputIntervals(interval);
        for (String s: in){
            System.out.print(s + "; ");
        }

        System.out.println("\n\nOverlap Interval Pairs: ");
        String[] out = overlap.getAllOverlapPairs(interval);
        for (String s: out){
            System.out.print(s + ";\n ");
        }

    }
}

class Interval{
    private int start;
    private int end;

    public Interval(int start, int end){
        this.start = start;
        this.end = end;
    }

    public int getStartInterval(){
        return this.start;
    }

    public int getEndInterval(){
        return this.end;
    }

}
