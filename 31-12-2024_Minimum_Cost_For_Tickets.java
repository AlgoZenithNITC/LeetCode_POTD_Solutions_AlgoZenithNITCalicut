class Solution{
    HashSet<Integer> set = new HashSet<>();
    public int mincostTickets(int[] days, int[] costs){
        for (int day : days){
            set.add(day);
        }
    
    return recur(days, costs, days[0]);
    }
    int recur(int[] days, int[] costs, int currDay){
        if (currDay> days[days.length-1]){
            return 0;
        }
        if(!set.contains(currDay)){
            return 0 + recur(days, costs, currDay+1);

        }
        int oneDay = costs[0]+recur(days, costs, currDay+1);
        int sevenDay= costs[1]+recur(days, costs, currDay+7);
        int thirtyDay = costs[2]+recur(days, costs, currDay+30);
        return Math.min(oneDay, Math.min(sevenDay, thirtyDay));
    }
}
