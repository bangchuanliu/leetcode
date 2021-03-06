package leetcode.math;

public class NumberofDigitOne {

	public int countDigitOne(int n) {
		int res = 0, a = 1, b = 1;
		while (n > 0) {
			res += (n + 8) / 10 * a;
			if ((n % 10 == 1)) {
				res+= b;
			}
					
			b += n % 10 * a;
			a *= 10;
			n /= 10;
		}
		return res;
	}
}
