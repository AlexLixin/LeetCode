package Leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode15 {
	public static int[] stringToIntegerArray(String input) {
		input = input.trim();
		input = input.substring(1, input.length() - 1);
		if (input.length() == 0) {
			return new int[0];
		}

		String[] parts = input.split(",");
		int[] output = new int[parts.length];
		for (int index = 0; index < parts.length; index++) {
			String part = parts[index].trim();
			output[index] = Integer.parseInt(part);
		}
		return output;
	}

	public static String integerArrayListToString(List<Integer> nums, int length) {
		if (length == 0) {
			return "[]";
		}

		String result = "";
		for (int index = 0; index < length; index++) {
			Integer number = nums.get(index);
			result += Integer.toString(number) + ", ";
		}
		return "[" + result.substring(0, result.length() - 2) + "]";
	}

	public static String integerArrayListToString(List<Integer> nums) {
		return integerArrayListToString(nums, nums.size());
	}

	public static String int2dListToString(List<List<Integer>> nums) {
		StringBuilder sb = new StringBuilder("[");
		for (List<Integer> list : nums) {
			sb.append(integerArrayListToString(list));
			sb.append(",");
		}

		sb.setCharAt(sb.length() - 1, ']');
		return sb.toString();
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line;
		while ((line = in.readLine()) != null) {
			int[] nums = stringToIntegerArray(line);

			List<List<Integer>> ret = new Leetcode15().threeSum(nums);

			String out = int2dListToString(ret);

			System.out.print(out);
		}
	}

	public List<List<Integer>> threeSum(int[] nums) {
        if(nums.length<3)return new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        for(int i = 0; i<nums.length-2;i++){
            if(i>0&&nums[i]==nums[i-1])continue;
            int l = i+1;
            int r = nums.length-1;
            while(true){
                if(l<r){
                    int s = nums[i]+nums[l]+nums[r];
                    if(s<0)l++;
                    if(s>0)r--;
                    if(s==0){
                        results.add(Arrays.asList(nums[i],nums[l],nums[r]));
                        while(l<r&&nums[l]==nums[l+1])l++;
                        while(l<r&&nums[r]==nums[r-1])r--;
                        l++;//System.out.println(nums[l]);
                        r--;//System.out.println(nums[r]);
                    }
                }else{
                    break;
                } 
            } 
        }
    
    return results;
	}
}
