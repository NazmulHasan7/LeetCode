// 2671. Frequency Tracker
package Medium;
import java.util.HashMap;

public class Medium_2671_Frequency_Tracker {
    static class FrequencyTracker {
        HashMap<Integer, Integer> frequency;
        HashMap<Integer, Integer> frequencyCount;

        public FrequencyTracker() {
            this.frequency = new HashMap<>();
            this.frequencyCount = new HashMap<>();
        }

        public void add(int number) {
            int freq = frequency.getOrDefault(number, 0);
            // Update the frequency of the number
            frequency.put(number, freq + 1);
            // Update the count of the previous frequency
            if (freq > 0) {
                frequencyCount.put(freq, frequencyCount.get(freq) - 1);
                if (frequencyCount.get(freq) == 0)
                    frequencyCount.remove(freq);
            }
            // Update the count of the new frequency
            frequencyCount.put(freq + 1, frequencyCount.getOrDefault(freq + 1, 0) + 1);
        }

        public void deleteOne(int number) {
            int freq = frequency.getOrDefault(number, 0);

            if (freq > 0) {
                // Update the frequency of the number
                if (freq == 1) frequency.remove(number);
                else frequency.put(number, freq - 1);

                // Update the count of the previous frequency
                frequencyCount.put(freq, frequencyCount.get(freq) - 1);
                if (frequencyCount.get(freq) == 0)
                    frequencyCount.remove(freq);

                // Update the count of the new frequency
                if (freq > 1)
                    frequencyCount.put(freq - 1, frequencyCount.getOrDefault(freq - 1, 0) + 1);
            }
        }

        public boolean hasFrequency(int frequency) {
            return frequencyCount.containsKey(frequency);
        }
    }
    public static void main(String[] args) {
        FrequencyTracker frequencyTracker = new FrequencyTracker();
        frequencyTracker.add(3); // The data structure now contains [3]
        frequencyTracker.add(3); // The data structure now contains [3, 3]
        frequencyTracker.hasFrequency(2); // Returns true, because 3 occurs twice
    }
}
