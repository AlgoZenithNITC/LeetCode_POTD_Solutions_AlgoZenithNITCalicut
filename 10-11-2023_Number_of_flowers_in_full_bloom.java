class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people){
        int m = flowers.length;
        int[] start_time = new int[m];
        int[] end_time = new int[m];
        int n = people.length;
        for(int i = 0; i < m; i++){
            start_time[i] = flowers[i][0];
            end_time[i] = flowers[i][1];
        }
        Arrays.sort(start_time);
        Arrays.sort(end_time);
        int[] ans = new int[n];
        for(int i = 0; i < n; i++){
            int started_blooming = binarySearchUpperBound(start_time, people[i]);
            if(started_blooming < 0){
                started_blooming = -started_blooming - 1;
            }
            int stopped_blooming = binarySearchLowerBound(end_time, people[i]);
            if (stopped_blooming < 0) {
                stopped_blooming = -stopped_blooming - 1;
            }
            ans[i] = started_blooming - stopped_blooming;
        }
        return ans;
    }
    private int binarySearchUpperBound(int[] arr, int target) {
        int left = 0, right = arr.length;
        while(left < right){
            int mid = left + (right - left)/2;
            if(arr[mid] <= target){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return left;
    }
    private int binarySearchLowerBound(int[] arr, int target) {
        int left = 0, right = arr.length;
        while (left < right){
            int mid = left + (right - left)/2;
            if(arr[mid] < target){
                left = mid + 1;
            }else{
                right = mid;
            }
        }   
        return left;
    }
}
