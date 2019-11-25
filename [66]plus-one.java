//给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。 
//
// 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。 
//
// 你可以假设除了整数 0 之外，这个整数不会以零开头。 
//
// 示例 1: 
//
// 输入: [1,2,3]
//输出: [1,2,4]
//解释: 输入数组表示数字 123。
// 
//
// 示例 2: 
//
// 输入: [4,3,2,1]
//输出: [4,3,2,2]
//解释: 输入数组表示数字 4321。
// 
// Related Topics 数组



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] plusOne(int[] digits) {
        // 法1
//        return plusOne1(digits);
        // 优化
        for (int i = digits.length - 1; i >= 0; i--) {
            if ( digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        //如果没有return，就走到了第1位元素且有进位，开辟新的数组来存储
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

    private int[] plusOne1(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            int num = digits[i] + 1;
            if (i ==0 && num == 10) {
                //开辟新的数组来存储
                int[] newArr = new int[digits.length + 1];
                newArr[0] = 1;
                return newArr;
            }
            if (num < 10) {
                digits[i] = num;
                return digits;
            } else {
                digits[i] = 0;
            }
        }
        return digits;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
