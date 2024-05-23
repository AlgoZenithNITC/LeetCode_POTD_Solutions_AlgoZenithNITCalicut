class Solution:
    def beautifulSubsets(self, nums: List[int], k: int) -> int:
        remainder_map = defaultdict(list)
        for num in nums:
            remainder_map[num % k].append(num)

        total_subsets = 1
        for remainder, num_list in remainder_map.items():
            num_list.sort()
            frequency_map = defaultdict(int)
            for num in num_list:
                frequency_map[num] += 1

            prev_num = float('-inf')
            prev_not_taken = 1
            prev_taken = 0
            now_not_taken = 0
            now_taken = 0
            
            for num, frequency in frequency_map.items():
                possible_subsets = int(pow(2, frequency) - 1)
                if prev_num + k == num:
                    now_not_taken = prev_not_taken + prev_taken
                    now_taken = prev_not_taken * possible_subsets
                else:
                    now_not_taken = prev_not_taken + prev_taken
                    now_taken = (prev_not_taken + prev_taken) * possible_subsets

                prev_not_taken = now_not_taken
                prev_taken = now_taken
                prev_num = num

            total_subsets *= (now_not_taken + now_taken)
        
        return total_subsets - 1
