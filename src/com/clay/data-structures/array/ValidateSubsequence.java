package array;

public class ValidateSubsequence {

    public static void main(String[] args) {
        
        int[] nums1 = {1, 2, 3, 4, 5};
        int[] nums2 = {2, 3, 4};
        System.out.println(validateSubsequence(nums1, nums2));
    }

    private static boolean validateSubsequence(int[] nums1, int[] nums2) {

        int i=0;

        for (int j=0; j<nums1.length; j++) {
            if (nums1[j] == nums2[i]) {
                i++;
            }
            if (nums2.length == i) {
                return true;
            }
        }

        return nums2.length == i;
    }
}
