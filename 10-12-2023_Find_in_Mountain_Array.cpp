int findInMountainArray(int target, MountainArray &mountainArr){
        int start = 0, end = mountainArr.length() - 1;
        int mid = start + (end - start)/2;
        while(start < end){
            if(mountainArr.get(mid) < mountainArr.get(mid + 1)){
                start = mid + 1;
            }else{
                end = mid;
            }
            mid = start + (end - start)/2;
        }
        int peak_idx = mid;
        int left_idx = -1;
        int start_left = 0, end_left = peak_idx;
        int mid_left = start_left + (end_left - start_left)/2;
        while(start_left <= end_left){
            int middle_element = mountainArr.get(mid_left);
            if(middle_element == target){
                left_idx = mid_left;
            }
            if(middle_element < target){
                start_left = mid_left + 1;
            }else{
                end_left = mid_left - 1;
            }
            mid_left = start_left + (end_left - start_left)/2;
        }
        int right_idx = -1;
        int start_right = peak_idx, end_right = mountainArr.length() - 1;
        int mid_right = start_right + (end_right - start_right)/2;
        while(start_right <= end_right){
            int middle_element = mountainArr.get(mid_right);
            if(middle_element == target){
                right_idx = mid_right;
            }
            if(middle_element > target){
                start_right = mid_right + 1;
            }else{
                end_right = mid_right - 1;
            }
            mid_right = start_right + (end_right - start_right)/2;
        }
        if(left_idx == right_idx){
            return left_idx;
        }else if(left_idx != -1){
            return left_idx;
        }
        return right_idx;
    }
