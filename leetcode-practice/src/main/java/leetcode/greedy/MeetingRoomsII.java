package leetcode.greedy;

import common.Interval;

import java.util.*;

public class MeetingRoomsII {

    public int minMeetingRooms(int[][] intervals) {
        PriorityQueue<Integer> q = new PriorityQueue<>();

        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);

        for (int i = 0; i < intervals.length; i++) {
            if (!q.isEmpty() && intervals[i][0] >= q.peek()) {
                q.poll();
            }

            q.add(intervals[i][1]);
        }

        return q.size();
    }


    public int minMeetingRooms2(Interval[] intervals) {
        List<Interval> rooms = new ArrayList<>();

        Arrays.sort(intervals, (a, b) -> (a.start - b.start));

        for (int i = 0; i < intervals.length; i++) {
            int j = 0;
            while (j < rooms.size()) {
                if (intervals[i].start >= rooms.get(j).end) {
                    rooms.set(j, intervals[i]);
                    break;
                }
                j++;
            }
            if (j == rooms.size()) {
                rooms.add(intervals[i]);
            }
        }

        return rooms.size();
    }

    public int minMeetingRooms3(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] -b[0]);
        Map<Integer, Integer> map = new HashMap<>();
        int[] pre = intervals[0];
        map.put(1, pre[1]);

        for (int i = 1; i < intervals.length; i++) {
            boolean isFoundRoom = false;
            for(int room: map.keySet()) {
                if (intervals[i][0] >= map.get(room)) {
                    map.put(room, intervals[i][1]);
                    isFoundRoom = true;
                    break;
                }
            }
            if (!isFoundRoom) {
                int key = map.size() + 1;
                map.put(key, intervals[i][1]);
            }
        }

        return map.size();
    }

    public static void main(String[] args) {
        MeetingRoomsII meetingRoomsII = new MeetingRoomsII();

        int[][] nums = {{1293, 2986}, {848, 3846}, {4284, 5907}, {4466, 4781}, {518, 2918}, {300, 5870}};
        Interval[] intervals = new Interval[nums.length];
        int i = 0;
        for (int[] x : nums) {
            Interval interval = new Interval();
            interval.start = x[0];
            interval.end = x[1];
            intervals[i++] = interval;
        }


        System.out.println(meetingRoomsII.minMeetingRooms3(nums));
    }
}
