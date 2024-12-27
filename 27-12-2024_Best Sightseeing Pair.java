class Solution {
    public int maxScoreSightseeingPair(int[] arr) {
        int maxScore = 0;
        int maxI = arr[0];
        
        for (int j = 1; j < arr.length; j++) {
            maxScore = Math.max(maxScore, maxI + arr[j] - j);
            maxI = Math.max(maxI, arr[j] + j);
        }
        
        return maxScore;
    }
}
