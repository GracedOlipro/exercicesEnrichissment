package sandbox;

public class MinMax {
	public static int max3(int val1, int val2, int val3) {
		int max = val1;
		if (val2 > max) {
			max = val2;
		}
		if (val3 > max) {
			max = val2;
		}
		if (max < 0) {
			max = 0;
		} else if (max > 101) {
			max = 100;
		}
		return max;
	}
	
	public static int min3(int val1, int val2, int val3) {
		int min = val1;
		if (val2 < min) {
			min = val3;
		}
		if (val3 < min) {
			min = val2;
		}
		if (min < 0) {
			min = 0;
		} else if (min >= 1000) {
			min = 100;
		}
		return min;
	}
}
