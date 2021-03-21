package leetcode.mar21;

import java.util.*;
/*
 * Implement the UndergroundSystem class:

void checkIn(int id, string stationName, int t)
A customer with a card id equal to id, gets in the station stationName at time t.
A customer can only be checked into one place at a time.
void checkOut(int id, string stationName, int t)
A customer with a card id equal to id, gets out from the station stationName at time t.
double getAverageTime(string startStation, string endStation)
Returns the average time to travel between the startStation and the endStation.
The average time is computed from all the previous traveling from startStation to endStation that happened directly.
Call to getAverageTime is always valid.
You can assume all calls to checkIn and checkOut methods are consistent. If a customer gets in at time t1 at some station, they get out at time t2 with t2 > t1. All events happen in chronological order.

 
 */

public class UnderGroundSystem {

	static class CustomerTrip {
		public int cardID;
		public String fromStation;
		public String toStation;
		public int checkInTime;
		public int checkOutTime;
	}

	static class TripStats {
		public String fromStation;
		public String toStation;
		public int totalTrips;
		public int totalTime;
	}

	private HashMap<Integer, CustomerTrip> tripMap;
	private Map<String, Map<String, TripStats>> tripsStatsMap;

	public UnderGroundSystem() {
		tripMap = new HashMap<Integer, CustomerTrip>();
		tripsStatsMap = new HashMap<String, Map<String, TripStats>>();
	}

	public void checkIn(int id, String stationName, int t) {

		CustomerTrip ct = new CustomerTrip();
		ct.cardID = id;
		ct.checkInTime = t;
		ct.fromStation = stationName;
		tripMap.put(id, ct);
	}

	public void checkOut(int id, String stationName, int t) {

		CustomerTrip ct = tripMap.get(id);
		TripStats ts = new TripStats();
		ts.fromStation = ct.fromStation;
		ts.toStation = stationName;
		Map<String, TripStats> tmp = new HashMap<String, TripStats>();
		if (tripsStatsMap.containsKey(ct.fromStation)) {
			tmp = tripsStatsMap.get(ct.fromStation);
			if (tmp.containsKey(stationName))
				ts = tmp.get(stationName);
		}

		ts.totalTime += t - ct.checkInTime;
		ts.totalTrips += 1;
		tmp.put(stationName, ts);
		tripsStatsMap.put(ct.fromStation, tmp);
	}

	public double getAverageTime(String startStation, String endStation) {
		if (tripsStatsMap.containsKey(startStation)) {
			Map<String, TripStats> tmp = new HashMap<String, TripStats>();
			tmp = tripsStatsMap.get(startStation);
			if (tmp.containsKey(endStation)) {
				TripStats ts = tmp.get(endStation);
				return ((double) ts.totalTime / (double) ts.totalTrips);
			}
		}

		return 0.0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UnderGroundSystem undergroundSystem = new UnderGroundSystem();
		undergroundSystem.checkIn(10, "Leyton", 3);
		undergroundSystem.checkOut(10, "Paradise", 8);
		System.out.println(undergroundSystem.getAverageTime("Leyton", "Paradise")); // return 5.00000
		undergroundSystem.checkIn(5, "Leyton", 10);
		undergroundSystem.checkOut(5, "Paradise", 16);
		System.out.println(undergroundSystem.getAverageTime("Leyton", "Paradise")); // return 5.50000
		undergroundSystem.checkIn(2, "Leyton", 21);
		undergroundSystem.checkOut(2, "Paradise", 30);
		System.out.println(undergroundSystem.getAverageTime("Leyton", "Paradise")); // return 6.66667

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
