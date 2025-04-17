package hackerrank;

import java.util.*;

/**
 * Create a basic meeting assistant. You are given a list of strings, events[n], where each string is in the format
"person_name <action> <start> <end>".
This indicates that person_name performs action from start to end, inclusive.
The times are given in the "HH:MM" format. Determine the earliest time in the day, between "00:00" and "23:59", 
when all individuals mentioned in at least one event are available for a meeting lasting k minutes.
Return the result as "HH:MM" or "-1" if no such time exists.
events = [ "Bob sleep 00:00 08:00", "Peter work 07:00 13:00", "Bob lunch 12:30 13:59" ]
k = 60


Bob is not available until 08:00. After that, Peter is not available until 13:00.
Then Bob is busy until 13:59. Return the earliest time they are both available: "14:00".

Function Description
Complete the function getEarliestAvailableTime in the editor below.

java
Copy
Edit
getEarliestAvailableTime` takes the following arguments:
- List<String> events: event descriptors
- int k: meeting duration


Returns
String: the earliest time for the meeting or "-1" if it is not possible.

Constraints
1 ≤ n ≤ 10⁵

1 ≤ length of events[i] ≤ 40

1 ≤ k ≤ 1440

It is guaranteed that the number of people is less than 5000.

It is guaranteed that no person’s events overlap.
 */
class GetEarliestAvailableTime {
    public static String getEarliestAvailableTime(List<String> events, int k) {
        boolean[] busy = new boolean[1440]; // 1440 minutes in a day (0 to 1439)

        // Parse events and mark busy times
        for (String event : events) {
            String[] parts = event.split(" ");
            int start = timeToMinutes(parts[2]);
            int end = timeToMinutes(parts[3]); // No need for Math.min, since constraints ensure end <= 1439

            // Mark busy minutes
            for (int i = start; i <= end; i++) { // Change '<' to '<=' to mark the full range
                busy[i] = true;
            }
        }

        // Find the first k-minute free slot
        int freeMinutes = 0;
        for (int i = 0; i < 1440; i++) {
            if (!busy[i]) {
                freeMinutes++;
                if (freeMinutes == k) {
                    return minutesToTime(i - k + 1); // Return start time of free slot
                }
            } else {
                freeMinutes = 0; // Reset if we hit a busy minute
            }
        }

        return "-1"; // No available slot found
    }

    // Convert "HH:MM" to minutes from 00:00
    private static int timeToMinutes(String time) {
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }

    // Convert minutes from 00:00 to "HH:MM"
    private static String minutesToTime(int minutes) {
        int hours = minutes / 60;
        int mins = minutes % 60;
        return String.format("%02d:%02d", hours, mins);
    }

    public static void main(String[] args) {
        List<String> events = Arrays.asList(
            "sam sleep 12:00 18:59",
            "alex gaming 00:00 11:00"
        );
        int k = 60;

        System.out.println(getEarliestAvailableTime(events, k)); // Expected Output: "19:00"
    }
}