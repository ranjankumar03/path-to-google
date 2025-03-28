import java.util.*;

class Result {
    public static String getEarliestAvailableTimes(List<String> events, int k) {
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
