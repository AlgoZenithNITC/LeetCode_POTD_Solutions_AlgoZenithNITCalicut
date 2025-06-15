int maxDiff(int num) {
        int mult = 1;
        while(num%mult == 0)
            mult *= 10;
        mult /= 10;

        int rev = 0;
        int copy = num;
        while(copy){
            rev *= 10;
            rev += copy%10;
            copy /= 10;
        }

        //max_num
        int max = 0;
        copy = rev;
        int prev_rep = -1;
        while(copy%10 == 9){
            max *= 10;
            max += 9;
            copy /= 10;
        }
        int rep = copy%10;
        prev_rep = rep;
        while(copy){
            max *= 10;
            int x = copy%10;
            if(x == rep)
                x = 9;
            max += x;
            copy /= 10;
        }

        //min_num
        int min = 0;
        copy = rev;
        while(copy && copy%10 <= 1){
            min *= 10;
            min += copy%10;
            copy /= 10;
        }
        rep = copy%10;
        int replaced = 0;
        if(min == 0)
            replaced = 1;
        while(copy){
            min *= 10;
            int x = copy%10;
            if(x == rep)
                x = replaced;
            min += x;
            copy /= 10;
        }
        
        int ans = max-min;

        // case where there are trailing zeros in num
        // and 0 is chosen to maximize
        if(prev_rep == 0){
            while(mult > 1){
                ans *= 10;
                ans += 9;
                mult /= 10;
            }
            return ans;
        }

        return ans*mult;
    }