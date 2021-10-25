class Solution {
	private static int[] table1 = new int[10];// table1[2] 表示2位数上一共多少个数(按位算)
	private static int[] table2 = new int[10];// table2[2] 表示2位数之前一共多少个数

	static {
		for (int i = 1; i < 9; i++) {
			table1[i] = ((int) Math.pow(10, i) - (int) Math.pow(10, i - 1)) * i;
		}
		table2[9] = Integer.MAX_VALUE;

		for (int i = 1; i < 9; i++) {
			table2[i] += table2[i - 1] + table1[i];
		}
	}

	public int findNthDigit(int n) {
		int w = 0;// n是w+1位数, w是n的位数-1
		for (; w < 9; w++) {
			if (n <= table2[w + 1]) {
				break;
			}
		}
		int left = n - table2[w];// n的前一位所有数字都减掉
		int num = left / (w + 1) + (int) Math.pow(10, w);// n是哪个数上的一位
		int mod = left % (w + 1); // n是num第几个
		if (mod == 0) {
			num = num - 1;// 余0是上一个数的最后一位
			return num - (num / 10) * 10;
		} else {
			num = num / (int) Math.pow(10, w + 1 - mod);// 将num的第mod个数变成个位数
			return num - (num / 10) * 10;// 取出个位数
		}
	}
}
