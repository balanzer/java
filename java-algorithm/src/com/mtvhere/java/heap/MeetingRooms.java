package com.mtvhere.java.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class MeetingRooms {
    public static void main(String[] args) {
        MeetingRooms solution = new MeetingRooms();

        //int[][] intervals = {{0, 30}, {5, 10}, {15, 20}, {21, 23}};
        int[][] intervals = {{1293, 2986}, {848, 3846}, {4284, 5907}, {4466, 4781}, {518, 2918}, {300, 5870}};
        int output = solution.minMeetingRooms(intervals);
        System.out.println(output + " rooms needed for " + Arrays.deepToString(intervals));
    }


    public int minMeetingRooms(int[][] intervals) {


        if (intervals.length < 1) {
            //no meeting rooms needed if no meetings
            return 0;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return Integer.compare(a[0], b[0]);
        });

        for (int[] interval : intervals) {
            pq.add(interval);
        }

        List<int[]> meetingRooms = new ArrayList<>();


        //int totalRooms = 1; //default 1 room if atleast one meeting present

        while (pq.size() > 0) {
            int[] firstInterval = pq.poll();

            int[] nextInterval = pq.peek();

            System.out.println("first is " + Arrays.toString(firstInterval) + "  next is " + Arrays.toString(nextInterval));


            if (nextInterval != null && nextInterval[0] >= firstInterval[1]) {
                //keep next interval
                //delete first interval
                //assign default room for this meeting


            } else if (nextInterval != null && nextInterval[0] <= firstInterval[1]) {
                // First meeting still going
                // next meeting need one room and delete next internal
                // add first meeting to queue

                nextInterval = pq.poll(); // remove next meeting
                pq.add(firstInterval);
                if (meetingRooms.size() == 0) {
                    System.out.println("no rooms so adding room for meeting " + Arrays.toString(nextInterval));
                    meetingRooms.add(nextInterval);
                } else {

                    //check any meetings are over and replace or add new room

                    boolean roomFound = false;
                    for (int i = 0; i < meetingRooms.size() && !roomFound; i++) {

                        int[] lastMeeting = meetingRooms.get(i);

                        if (lastMeeting[1] <= nextInterval[0]) {
                            meetingRooms.remove(i);//remove last meeting

                            meetingRooms.add(i, nextInterval); //add current meeting
                            System.out.println("delete last meeting " + Arrays.toString(lastMeeting) + " and adding room for meeting " + Arrays.toString(nextInterval));
                            roomFound = true;
                        }
                    }


                    if (!roomFound) {
                        //last meeting still going on
                        //add new room
                        meetingRooms.add(nextInterval);
                        System.out.println("need extra room adding room for meeting " + Arrays.toString(nextInterval));
                    }
                }


            } else if (nextInterval == null) {
                //no next meetings
                //assign a room for this meeting and delete
                meetingRooms.add(firstInterval);
                System.out.println("final meeting adding room for meeting " + Arrays.toString(firstInterval));
            }

            //System.out.println("rooms : " + meetingRooms);
            // System.out.println("rooms : " + meetingRooms.size() + "  first is " + Arrays.toString(firstInterval) + "  next is " + Arrays.toString(nextInterval));
        }

        return meetingRooms.size();
    }
}
