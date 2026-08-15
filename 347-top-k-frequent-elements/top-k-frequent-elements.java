class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        List<Integer>[] buckets = new List[nums.length + 1];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            int num = entry.getKey();
            int frequency = entry.getValue();
            buckets[frequency].add(num);
        }
        int[] result = new int[k];
        int resultIndex = 0;
        for (int freq = buckets.length - 1; freq >= 0 && resultIndex < k; freq--) {
            for (int num : buckets[freq]) {
                result[resultIndex++] = num;
                if (resultIndex == k) {
                    break;
                }
            }
        }
        return result;
    }
}