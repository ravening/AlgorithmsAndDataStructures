// given a set of intervals, insert a new interval and merge if necessary
// You may assume that the intervals were initially sorted according to their start times.

// Example 1:
// Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].

// Example 2:
// Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].

// This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].

package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }
    }

    public List<Interval> insertInterval(List<Interval> intervals, Interval newInterval) {
        int i = 0;
        Interval tmpInterval = null;

        // find a position to insert the new interval
        while (i < intervals.size() && intervals.get(i).end <= newInterval.start) {
            i++;
        }

        // now start merging the intervals until the new interval doesnt overlap
        while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
            tmpInterval = new Interval(Math.min(intervals.get(i).start, newInterval.start),
                                                Math.max(intervals.get(i).end, newInterval.end));
            intervals.remove(i);
        }

        // now insert the newly created interval
        intervals.add(i, tmpInterval);

        return intervals;
    }

    // given a list of intervals, merge them so that none of the interval overlap
    public List<Interval> mergeIntervals(List<Interval> intervals) {
        List<Interval> result = new ArrayList<>();

        Interval[] array = intervals.toArray(new Interval[intervals.size()]);

        Arrays.sort(array, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.start == o2.start) {
                    return o1.end - o2.end;
                }
                return o1.start - o2.start;
            }
        });

        for (Interval interval : intervals) {
            if (result.size() == 0) {
                result.add(0, interval);
                continue;
            }

            if (result.get(result.size()-1).end < interval.start) {
                result.add(result.size(), interval);
            } else {
                result.get(result.size()-1).end = Math.max(interval.end, result.get(result.size()-1).end);
            }
        }

        return result;
    }

    Comparator<Interval> comparator = Comparator.comparing(Interval::getStart).thenComparing(Interval::getEnd);

    // given two list with intervals, merge them
    public List<Interval> mergeListIntervals(List<Interval> list1, List<Interval> list2) {
        Interval[] first = list1.toArray(new Interval[list1.size()]);
        Interval[] second = list2.toArray(new Interval[list2.size()]);

        Arrays.sort(first, comparator);
        Arrays.sort(second, comparator);

        list1 = Arrays.asList(first);
        list2 = Arrays.asList(second);

        List<Interval> result = new ArrayList<>();
        int start = Integer.MIN_VALUE, end = Integer.MIN_VALUE;
        int i = 0, j = 0;

        while (i < list1.size() || j < list2.size()) {
            Interval cur = null;
            if (i >= list1.size())
                cur = list2.get(j++);

            if (j >= list2.size())
                cur = list1.get(i++);

            if (cur == null)
                cur = (list1.get(i).start < list2.get(j).start) ? list1.get(i++) : list2.get(j++);

            if (cur.start > end) {
                if (end > Integer.MIN_VALUE) {
                    result.add(new Interval(start, end));
                }

                start = cur.start;
                end = cur.end;
            } else {
                end = Math.max(end, cur.end);
            }
        }

        if (end > Integer.MIN_VALUE) {
            result.add(new Interval(start, end));
        }
        return result;
    }
}
