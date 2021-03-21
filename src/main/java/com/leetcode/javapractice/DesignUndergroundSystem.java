package com.leetcode.javapractice;

import java.util.HashMap;
import java.util.Map;

class UndergroundSystem {

    private Map<String, Pair<Double, Double>> journeyData;
    private Map<Integer, Pair<String, Integer>> checkInData;

    public UndergroundSystem() {
        this.journeyData = new HashMap<String, Pair<Double, Double>>();
        this.checkInData = new HashMap<Integer, Pair<String, Integer>>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkInData.put(id, new Pair<String, Integer>(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        Pair<String, Integer> checkInDataForId = checkInData.get(id);
        String startStation = checkInDataForId.first;
        Integer checkInTime = checkInDataForId.second;
        String routeKey = stationsKey(startStation, stationName);
        Pair<Double, Double> routeStats =
                journeyData.getOrDefault(routeKey, new Pair<Double, Double>(0.0, 0.0));
        Double totalTripTime = routeStats.first;
        Double totalTrips = routeStats.second;
        double tripTime = t - checkInTime;
        journeyData.put(routeKey, new Pair<Double, Double>(totalTripTime + tripTime, totalTrips + 1));
        checkInData.remove(id);
    }

    public double getAverageTime(String startStation, String endStation) {
        String routeKey = stationsKey(startStation, endStation);
        Double totalTime = journeyData.get(routeKey).first;
        Double totalTrips = journeyData.get(routeKey).second;
        return totalTime / totalTrips;
    }

    private String stationsKey(String startStation, String endStation) {
        return startStation + "->" + endStation;
    }
}

public class DesignUndergroundSystem {

    public static void main(String[] args) {

        UndergroundSystem undergroundSystem = new UndergroundSystem();
        undergroundSystem.checkIn(45, "Leyton", 3);
        undergroundSystem.checkIn(32, "Paradise", 8);
        undergroundSystem.checkIn(27, "Leyton", 10);
        undergroundSystem.checkOut(45, "Waterloo", 15);
        undergroundSystem.checkOut(27, "Waterloo", 20);
        undergroundSystem.checkOut(32, "Cambridge", 22);
        System.out.println(undergroundSystem.getAverageTime("Paradise", "Cambridge"));
        System.out.println(undergroundSystem.getAverageTime("Leyton", "Waterloo"));
        undergroundSystem.checkIn(10, "Leyton", 24);
        System.out.println(undergroundSystem.getAverageTime("Leyton", "Waterloo"));
        undergroundSystem.checkOut(10, "Waterloo", 38);
        System.out.println(undergroundSystem.getAverageTime("Leyton", "Waterloo"));
    }
}
