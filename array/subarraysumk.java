package array;

import java.util.HashMap;

public class subarraysumk {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 1, 1 };
		System.out.println(subarraySum(nums, 2));
		System.out.println(subarraySumopti(nums, 2));

	}

	// brute force
	public static int subarraySum(int[] nums, int k) {
		int c = 0;
		for (int i = 0; i < nums.length; i++) {
			int sum = 0;
			for (int j = i; j < nums.length; j++) {
				sum += nums[j];
				if (sum == k) {
					c++;
				}

			}

		}
		return c;

	}

	public static int subarraySumopti(int[] nums, int k) {
		HashMap<Integer, Integer> map = new HashMap<>();
		int sum = 0;
		int c = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (sum == k) {
				c++;
			}
			if (map.containsKey(sum - k)) {
				c += map.get(sum - k);
			}
			map.put(sum, map.getOrDefault(sum, 0) + 1);
		}
		return c;
	}

}
