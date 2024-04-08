class Solution:
    def countStudents(self, students, sandwiches):
        n = len(students)
        ans = 0
        stu = defaultdict(int)
        sand = defaultdict(int)

        for i in range(n):
            stu[students[i]] += 1

        for i in range(n):
            sand[sandwiches[i]] += 1
            if sand[sandwiches[i]] > stu[sandwiches[i]]:
                return n - i

        return ans
