def removeDuplicates(nums):
    i = 0
    j = 1
    while True:
        if j >= len(nums) or len(nums) == 0:
            break
        while nums[i] == nums[j]:
            nums.pop(i)
            if j >= len(nums):
                break
        i = i + 1
        j = j + 1
    print(nums)


def removeDuplicates2(nums):
    if len(nums) == 0:
        return 0
    i = 0
    j = 1
    while j < len(nums):
        if nums[j] != nums[i]:
            i = i + 1
            nums[i] = nums[j]
        j = j + 1
    while len(nums) > 1 and nums[-1] == nums[-2]:
        nums.pop()
    print(nums)
    return i + 1


removeDuplicates2([1])
