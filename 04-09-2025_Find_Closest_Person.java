class Solution {
    public int findClosest(int x, int y, int z) {
        int d1 = Math.abs(x - z); // Distance from Person 1 to Person 3
        int d2 = Math.abs(y - z); // Distance from Person 2 to Person 3

        if (d1 < d2) return 1;
        else if (d2 < d1) return 2;
        else return 0;
    }
}
