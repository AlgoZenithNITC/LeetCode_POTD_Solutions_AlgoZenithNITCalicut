int maxScoreSightseeingPair(vector<int>& arr) {
        int max_score = 0 ;
        int max_i = arr[0];
         for(int j = 1 ; j<arr.size() ; j++){
               max_score = max(max_score , max_i + arr[j] - j);

               max_i = max(max_i , arr[j]+j);
         }
        return max_score;
    }
