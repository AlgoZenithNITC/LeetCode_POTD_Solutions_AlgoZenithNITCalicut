class Solution:
    def relativeSortArray(self, arr1: List[int], arr2: List[int]) -> List[int]:
        max_element = max(arr1)
        count = [0] * (max_element + 1)

        for num in arr1:
            count[num] += 1

        sorted_array = []
        for num in arr2:
            while count[num] > 0:
                sorted_array.append(num)
                count[num] -= 1

        for i in range(max_element + 1):
            while count[i] > 0:
                sorted_array.append(i)
                count[i] -= 1

        return sorted_array
