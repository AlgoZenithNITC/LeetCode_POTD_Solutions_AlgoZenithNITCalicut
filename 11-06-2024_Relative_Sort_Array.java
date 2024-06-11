class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int maxElement = Arrays.stream(arr1).max().getAsInt();
        int[] count = new int[maxElement + 1];

        for (int num : arr1) {
            count[num]++;
        }

        List<Integer> sortedList = new ArrayList<>();
        for (int num : arr2) {
            while (count[num] > 0) {
                sortedList.add(num);
                count[num]--;
            }
        }

        for (int i = 0; i <= maxElement; i++) {
            while (count[i] > 0) {
                sortedList.add(i);
                count[i]--;
            }
        }

        return sortedList.stream().mapToInt(i -> i).toArray();
    }
}
