package dec_bin_converter;

import java.util.ArrayList;
import java.util.List;

/**
 * 10進位 <-> 2進位
 * @author Ming_Wu
 */
public class DecBinConverter {
	/**
	 * 10進位 -> 2進位
	 * @param num
	 * @return
	 */
	static List<Integer> decTobin(int num) {
		List<Integer> list = new ArrayList<Integer>();
		if (num < 0) return list;
		while (num > 0) {
			list.add(num % 2);
			num = num /2;
		}
		return list;
	}
	
	/**
	 * 原來寫法
	 * @param list
	 * @return
	 */
	static int binTodec_mine(List<Integer> list) {
		if (list == null || list.isEmpty()) return 0;
		// 在for loop外宣告變數a, j
		int num = 0, a, j;		
		for (int i = 0; i < list.size(); i++) {
			a = 1;
			j = i;
			while (j > 0) {
				a *= 2;
				j--;
			}
			// 補上少掉的list.get(i)
			num += (a * list.get(i));
		}
		return num;
	}

	/**
	 * 將2次方獨立為function
	 * @param list
	 * @return
	 */
	static int binTodec_improve(List<Integer> list) {
		if (list == null || list.isEmpty()) return 0;
		int num = 0;		
		for (int i = 0; i < list.size(); i++) {
			num += (power(i) * list.get(i));
		}
		return num;
	}
	
	/**
	 * Calculate 2^n
	 * @param n
	 * @return
	 */
	static int power(int n) {
		int result = 1;
		while (n > 0) {
			result *= 2;
			n--;
		}
		return result;
	}
	
	public static void main(String[] args) throws CustomException  {
		int num = 14;
		List<Integer> list = decTobin(num);
		/*
		 * 兩種寫法計算結果如果不一樣，throw customer exception
		 */
		if (binTodec_mine(list) != num || binTodec_improve(list) != num) {
			throw new CustomException("Exception");
		}
	}
}

/**
 * Customr Exception
 * @author Ming_Wu *
 */
class CustomException extends Exception {
    public CustomException (String message) {
        super(message);
    }
}
