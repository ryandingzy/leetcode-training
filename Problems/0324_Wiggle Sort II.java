class Solution {
    
    public void wiggleSort(int[] nums) {

        Arrays.sort(nums);

        int length = nums.length;
        int end = nums.length - 1;
        int[] tempArr = new int[length];

        int index = 1;
        while (index < length) {
            tempArr[index] = nums[end];
            end--;
            index += 2;
        }

        index = 0;
        while (index < length) {
            tempArr[index] = nums[end];
            end--;
            index += 2;
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = tempArr[i];
        }
    }
}
