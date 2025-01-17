class Solution(object):
    def doesValidArrayExist(self, derived):
        """
        :type derived: List[int]
        :rtype: bool
        """
        n = len(derived)

        # Initialize two possible starting values for the original array
        start0 = 0  # Assume original[0] = 0
        start1 = 1  # Assume original[0] = 1

        # Calculate the original array based on start0
        original0 = [0] * n
        original0[0] = start0
        for i in range(1, n):
            original0[i] = original0[i - 1] ^ derived[i - 1]
        # Check if the last condition holds for start0
        if (original0[n - 1] ^ original0[0]) == derived[n - 1]:
            return True

        # Calculate the original array based on start1
        original1 = [0] * n
        original1[0] = start1
        for i in range(1, n):
            original1[i] = original1[i - 1] ^ derived[i - 1]
        # Check if the last condition holds for start1
        if (original1[n - 1] ^ original1[0]) == derived[n - 1]:
            return True

        return False  # No valid original array found
