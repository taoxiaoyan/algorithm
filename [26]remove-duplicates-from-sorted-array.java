//给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。 
//
// 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。 
//
// 示例 1: 
//
// 给定数组 nums = [1,1,2], 
//
//函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。 
//
//你不需要考虑数组中超出新长度后面的元素。 
//
// 示例 2: 
//
// 给定 nums = [0,0,1,1,1,2,2,3,3,4],
//
//函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
//
//你不需要考虑数组中超出新长度后面的元素。
// 
//
// 说明: 
//
// 为什么返回数值是整数，但输出的答案是数组呢? 
//
// 请注意，输入数组是以“引用”方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。 
//
// 你可以想象内部操作如下: 
//
// // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
//int len = removeDuplicates(nums);
//
//// 在函数里修改输入数组对于调用者是可见的。
//// 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
//for (int i = 0; i < len; i++) {
//    print(nums[i]);
//}
// 
// Related Topics 数组 双指针



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int removeDuplicates(int[] nums) {
        // 边界，当数组为空时，直接返回0
        if (nums == null) return 0;
        if (nums.length < 2) return nums.length;
        // 已知数组有序，那么首先以len所指的值作为比较基准，然后遍历数组，判断后续元素是否与当前的相同。
        // 相同，则继续往后遍历；不同，则把len指针移动一个位置，并把相应的值记录到len指针上，开始对此值继续比较。
        int len = 0;
        for (int j = 1; j < nums.length; j++) {
            //判断j的值与len的值是否相同，相同则j继续往下循环；不同时，len移动一个位置，并把j的值记录到len的位置中
            if (nums[j] != nums[len]) {
                len++;
                nums[len] = nums[j];
            }
        }
        // 最后返回长度，因为i从0开始，长度则为i+1;
        return len+1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
