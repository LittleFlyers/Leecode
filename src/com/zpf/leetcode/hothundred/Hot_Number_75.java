package com.zpf.leetcode.hothundred;

/**
 * 75. 颜色分类
 * <p>
 * 给定一个包含红色、白色和蓝色，一共n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * <p>
 * 此题中，我们使用整数 0、1 和 2 分别表示红色、白色和蓝色。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,0,2,1,1,0]
 * 输出：[0,0,1,1,2,2]
 * 示例 2：
 * <p>
 * 输入：nums = [2,0,1]
 * 输出：[0,1,2]
 * 示例 3：
 * <p>
 * 输入：nums = [0]
 * 输出：[0]
 * 示例 4：
 * <p>
 * 输入：nums = [1]
 * 输出：[1]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-colors
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Hot_Number_75 {
    public void sortColors(int[] nums) {
        int twoFirst = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                for (int j = i + 1; j < twoFirst; j++) {
                    if (nums[j] == 0) {
                        replacement(nums, i, j);
                        break;
                    }
                }
            } else {
                if (nums[i] == 2) {
                    for (int j = twoFirst - 1; j > i; j--) {
                        if (nums[j] == 0) {
                            replacement(nums, i, j);
                            twoFirst = j;
                            break;
                        } else if (nums[j] == 1) {
                            replacement(nums, i, j);
                            twoFirst = j;
                            i--;
                            break;
                        }
                    }
                }
            }
        }
    }

    public void replacement(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
}
