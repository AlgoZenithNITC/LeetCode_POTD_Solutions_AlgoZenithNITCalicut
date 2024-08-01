class Solution:
    def countSeniors(self, details):
        count = 0

        for info in details:
            tens = int(info[11])
            ones = int(info[12])
            age = tens * 10 + ones

            if age > 60:
                count += 1

        return count
