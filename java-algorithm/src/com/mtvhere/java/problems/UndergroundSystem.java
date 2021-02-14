package com.mtvhere.java.problems;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class UndergroundSystem {

    public static void main(String[] args) {
        UndergroundSystem undergroundSystem = new UndergroundSystem();
        undergroundSystem.checkIn(45, "Leyton", 3);
        undergroundSystem.checkIn(32, "Paradise", 8);
        undergroundSystem.checkIn(27, "Leyton", 10);
        undergroundSystem.checkOut(45, "Waterloo", 15);
        undergroundSystem.checkOut(27, "Waterloo", 20);
        undergroundSystem.checkOut(32, "Cambridge", 22);
        undergroundSystem.getAverageTime("Paradise", "Cambridge");       // return 14.00000. There was only one travel from "Paradise" (at time 8) to "Cambridge" (at time 22)
        undergroundSystem.getAverageTime("Leyton", "Waterloo");          // return 11.00000. There were two travels from "Leyton" to "Waterloo", a customer with id=45 from time=3 to time=15 and a customer with id=27 from time=10 to time=20. So the average time is ( (15-3) + (20-10) ) / 2 = 11.00000
        undergroundSystem.checkIn(10, "Leyton", 24);
        undergroundSystem.getAverageTime("Leyton", "Waterloo");          // return 11.00000
        undergroundSystem.checkOut(10, "Waterloo", 38);
        undergroundSystem.getAverageTime("Leyton", "Waterloo");          // return 12.00000
    }

    Map<Integer, Trip> checkin = new HashMap<>();
    Map<String, List<Trip>> travels = new HashMap<>();

    public UndergroundSystem() {
        super();
    }

    public void checkIn(int id, String stationName, int t) {
        if (!this.checkin.containsKey(id)) {
            this.checkin.put(id, new Trip(stationName, t));
        }
    }

    public void checkOut(int id, String stationName, int t) {
        if (this.checkin.containsKey(id)) {
            Trip currentTrip = this.checkin.get(id);


            int travelTime = (t - currentTrip.time);
            //  System.out.println("for " + id + " from " + currentTrip.station + " to " + stationName + " took time : " + travelTime);

            Trip travel = new Trip(stationName, travelTime);

            if (this.travels.containsKey(currentTrip.station)) {
                this.travels.get(currentTrip.station).add(travel);
            } else {
                List<Trip> travelTimes = new LinkedList<>();
                travelTimes.add(travel);
                this.travels.put(currentTrip.station, travelTimes);
            }

            this.checkin.remove(id);//remove checkin Entry
        }
    }

    public double getAverageTime(String startStation, String endStation) {

        // System.out.println(this.travels);

        if (this.travels.containsKey(startStation)) {
            List<Trip> travelTrips = this.travels.get(startStation);
            int totalTrip = 0;
            int totalTime = 0;
            for (Trip trip : travelTrips) {
                if (trip.station.equalsIgnoreCase(endStation)) {
                    totalTime += trip.time;
                    totalTrip++;
                }
            }
            System.out.println(startStation + " to " + endStation + ", total trips : " + totalTrip + " time taken " + totalTime);
            return (totalTime * 1.0d) / totalTrip;
        }

        return 0.00;
    }

    class Trip {
        String station;
        int time;

        @Override
        public String toString() {
            return "Trip{" +
                    "station='" + this.station + '\'' +
                    ", time=" + this.time +
                    '}';
        }

        public Trip(String station, int time) {
            this.station = station;
            this.time = time;
        }
    }

}
