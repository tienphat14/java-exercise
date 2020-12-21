package languagebasic;

import java.util.ArrayList;

public class OverlappingIntervalPairs {


     private boolean isOverlap(Interval a, Interval b){
         return (a.getStartInterval()<= b.getEndInterval() && a.getEndInterval() >= b.getStartInterval());
     }


    private String printInterval(Interval interval){
        return "[" + interval.getStartInterval() + ", " + interval.getEndInterval() + "]";
    }

    private String printOverlapInterval(Interval a, Interval b){
        if (isOverlap(a, b)){
            //sort the the pair interval so it will not be duplicated by swapping
            return (a.getStartInterval() <= b.getStartInterval())? printInterval(a) + " and " + printInterval(b):
                    printInterval(b) + " and " + printInterval(a);
        }
        return "";
    }


     public String[] getAllOverlapPairs(Interval[] intervals){
         ArrayList<String> result = new ArrayList<>();
        for(int i=0; i< intervals.length; i++){
            for (int j = i+1; j<intervals.length; j++){
                    //Not add if duplication
                    if (!result.contains(printOverlapInterval(intervals[i], intervals[j]))) {
                        result.add(printOverlapInterval(intervals[i], intervals[j]));

                }
            }
        }


        return result.toArray(new String[]{});
     }

    public String[] getInputIntervals(Interval[] intervals){
        ArrayList<String> result = new ArrayList<>();
        for(Interval in: intervals){
            result.add("[" + in.getStartInterval() + ", " + in.getEndInterval() + "]");
        }
        return result.toArray(new String[]{});
    }



    public static void main(String[] args) {

        Interval[] interval = {new Interval(11, 15), new Interval(3, 9),
                new Interval(1, 4), new Interval(15,18), new Interval(2, 7), new Interval(1, 20),
                new Interval(20, 30), new Interval(40, 50), new Interval(20, 30)};
        OverlappingIntervalPairs overlap = new OverlappingIntervalPairs();

        System.out.println("Input intervals: ");
        String[] in = overlap.getInputIntervals(interval);
        for (String s: in){
            System.out.print(s + "; ");
        }

        System.out.println("\n\nOverlap Interval Pairs: ");
        String[] out = overlap.getAllOverlapPairs(interval);
        for (String s: out){
            System.out.println(s + ";");
        }

    }
}

class Interval {
    private int start;
    private int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStartInterval() {
        return this.start;
    }

    public int getEndInterval() {
        return this.end;
    }
}