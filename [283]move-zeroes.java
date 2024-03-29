//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。 
//
// 示例: 
//
// 输入: [0,1,0,3,12]
//输出: [1,3,12,0,0] 
//
// 说明: 
//
// 
// 必须在原数组上操作，不能拷贝额外的数组。 
// 尽量减少操作次数。 
// 
// Related Topics 数组 双指针



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void moveZeroes(int[] nums) {

        // 遍历找第一个为0的，记住下标;
        int p = -1;
        for (int q = 0; q < nums.length; q++) {
            if (nums[q] == 0) {
                if (p < 0) {
                    p = q;
                }
            } else {
                if (p >= 0) {
                    // nums[q] !=0 && p是有效的下标，需交换
                    nums[p] = nums[q];
                    nums[q] = 0;
                    p++;
                }
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
