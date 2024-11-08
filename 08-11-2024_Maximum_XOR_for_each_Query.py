def getMaximumXor(nums, maximumBit):
    numsSize = len(nums)
    answer = []
    xor_prefix = [0] * numsSize
    xor_prefix[0] = nums[0]
    
    # Calculate XOR prefix
    for i in range(1, numsSize):
        xor_prefix[i] = xor_prefix[i - 1] ^ nums[i]
    
    # Calculate maximum XOR for each query
    max_num = (1 << maximumBit) - 1  # Max number with maximumBit bits set to 1
    for i in range(numsSize):
        answer.append(xor_prefix[numsSize - i - 1] ^ max_num)
    
    return answer
