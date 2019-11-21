//给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。 
//
// 示例 1: 
//
// 输入: [1,2,3,4,5,6,7] 和 k = 3
//输出: [5,6,7,1,2,3,4]
//解释:
//向右旋转 1 步: [7,1,2,3,4,5,6]
//向右旋转 2 步: [6,7,1,2,3,4,5]
//向右旋转 3 步: [5,6,7,1,2,3,4]
// 
//
// 示例 2: 
//
// 输入: [-1,-100,3,99] 和 k = 2
//输出: [3,99,-1,-100]
//解释: 
//向右旋转 1 步: [99,-1,-100,3]
//向右旋转 2 步: [3,99,-1,-100] 
//
// 说明: 
//
// 
// 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。 
// 要求使用空间复杂度为 O(1) 的 原地 算法。 
// 
// Related Topics 数组



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void rotate(int[] nums, int k) {
        // 法1：开辟空间，借用数组。空间复杂度O(n)，时间复杂度O(n)
//        rotateOne(nums, k);

        // 法2：用一个k的数组存储需要往前移动的元素，空间复杂度O(k),时间复杂度O(n)
//        rotateTwo(nums, k);

        // 法3：三次反转
//        rotateThree(nums, k);

        // 法4：环状
        rotateFour(nums, k);

    }

    private void rotateFour(int[] nums, int k) {
        if (nums == null || nums.length == 0) return;
        k = k % nums.length;
        if (k <= 0) return;

        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int pre = nums[start];
            do {
                int next = (current + k) % nums.length;
                int tmp = nums[next];
                nums[next] = pre;
                pre = tmp;
                current = next;
                count++;
            } while (start != current);
        }
    }

    private void rotateThree(int[] nums, int k) {
        if (nums == null || nums.length == 0) return;
        k = k % nums.length;
        if (k <= 0) return;

        // 1、反转前len-k-1个元素
        reverse(nums, 0, nums.length - k - 1);
        // 2、反转 len-k 到 len -1个元素
        reverse(nums, nums.length - k, nums.length - 1);
        // 3、反转整个数组
        reverse(nums, 0, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }

    private void rotateTwo(int[] nums, int k) {
        if (nums == null || nums.length == 0) return;
        k = k % nums.length;
        if (k <= 0) return;

        int j = k - 1;
        int[] phase2 = new int[k];
        for (int i = nums.length-1; i >= 0; i--) {
            if (i >= nums.length - k) {
                phase2[j] = nums[i];
                j--;
            } else {
                nums[i+k] = nums[i];
            }
        }

        for (int i = 0; i < k; i++) {
            nums[i] = phase2[i];
        }
    }

    private void rotateOne(int[] nums, int k) {
        if (nums == null || nums.length == 0) return;
        k = k % nums.length;
        if (k <= 0) return;
        // 1、创建一个数组用来存储新的
        int[] phase1 = new int[nums.length - k];
        int[] phase2 = new int[k];
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i < nums.length - k) {
                phase1[i] = nums[i];
            } else {
                phase2[j] = nums[i];
                j++;
            }
        }
        for (int i = 0; i < k; i++) {
            nums[i] = phase2[i];
        }
        for (int i = 0; i < phase1.length; i++) {
            nums[i+k] = phase1[i];
        }
    }
}

//leetcode submit region end(Prohibit modification and deletion)
