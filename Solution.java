import java.util.*;

class Solution {
	/* Using LinkedHashMap */
	public int firstUniqCharLinkedHashMap(String s) {
        if (s.isBlank()) {
            return -1;
        }
        
        Map<Character, Integer> nonRepeatingIndices = new LinkedHashMap<>();
        
        for (int i = 0; i < s.length(); i++) {
            Character current = s.charAt(i);
            
            if (nonRepeatingIndices.containsKey(current)) {
                nonRepeatingIndices.put(current, null);
            } else {
                nonRepeatingIndices.put(current, i);
            }
        }
        
        for (Map.Entry<Character, Integer> entry: nonRepeatingIndices.entrySet()) {
            if (entry.getValue() != null) {
                return entry.getValue();
            }
        }
        return -1;
    }

    /* Using array to store count of occurrences */
    public int firstUniqCharUsingArrayOfOccurrences(String s) {
        if (s.isBlank()) {
            return -1;
        }
        
        int[] reps = new int[26];
        
        for (int i = 0; i < s.length(); i++) {
            reps[s.charAt(i) - 97] ++;
        }
        
        for (int i = 0; i < s.length(); i++) {
            if (reps[s.charAt(i) - 97] == 1) {
                return i;
            }
        }
        
        return -1;
    }
}