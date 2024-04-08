class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int n = students.length;
        int ans = 0;
        Map<Integer, Integer> stu = new HashMap<>();
        Map<Integer, Integer> sand = new HashMap<>();
        for (int student : students) {
            stu.put(student, stu.getOrDefault(student, 0) + 1);
        }
        for (int i = 0; i < n; i++) {
            int sandwich = sandwiches[i];
            sand.put(sandwich, sand.getOrDefault(sandwich, 0) + 1);
            
            if (sand.get(sandwich) > stu.getOrDefault(sandwich, 0)) {
                return n - i;
            }
        }

        return ans;
    }
}
