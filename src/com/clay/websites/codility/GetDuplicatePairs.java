package websites.codility;

/**
 * Input - {1,2,2,2,2,2,3,4,4,4,5,9,9,9,9,11,13,13,13}
 * Output - {1,2,2,3,,4,4,5,9,9,11,13,13}
 */
public class GetDuplicatePairs {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,2,2,2,2,3,4,4,4,5,9,9,9,9,11,13,13,13};
//        int[] nums = new int[]{1, 2, 2, 2, 13, 13, 13};
        int[] result = getDuplicatePairs(nums);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.println(" ");
    }
    // program to get duplicate value pairs in int sorted array
    public static int[] getDuplicatePairs(int[] nums) {
        int[] result = new int[nums.length];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                result[index++] = nums[i];
            } else {
                if (nums[i] == nums[i - 1]) {
                    result[index++] = nums[i];
                }
            }
        }
        int[] finalResult = new int[index];
        for (int i = 0; i < index; i++) {
            finalResult[i] = result[i];
        }
        return finalResult;
    }

   /* private static int[] getDuplicatePairs1(int[] nums) {
        boolean isPairFound = false;
        int j=0,i=0;

     *//*   for (int index = 0; index < nums.length-1; index++) {
            if (nums[index] != nums[index+1]) {
                nums[j++] = nums[index];
            }
        }
        nums[j++] = nums[nums.length-1];*//*
        while (i < nums.length - 1) {
            j = i;
            if (isPairFound && nums[i] == nums[i + 1]) {
                while (j < nums.length - 1) {
                    nums[j] = nums[j+1];
                    j++;
                }
            }

            if (nums[i] == nums[i + 1] && !isPairFound) {
                isPairFound = true;
            }
            i++;
        }

        return nums;
    }*/
    
    /*private static int[] getDuplicatePairs(int[] nums) {
        boolean isPairFound = false;
        int j, i=0,k=0, extrasCount =0;
        while (i < nums.length-1){
            j=i;
            k=i;

            if (isPairFound && nums[i] == nums[i+1]){
                while (nums[j] == nums[j+1] && j < nums.length-1) {
                    extrasCount++;
                    j++;
                }
                while (extrasCount> 0 && k < nums.length-extrasCount){
                    nums[k] = nums[k+extrasCount];
                    k++;
                }
                extrasCount = 0;
            }

            if (nums[i] == nums[i+1] && !isPairFound) {
                isPairFound = true;
            }
            i++;
        }

        return nums;
    }*/
}
