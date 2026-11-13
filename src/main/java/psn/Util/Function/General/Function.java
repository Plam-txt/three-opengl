package psn.Util.Function.General;

import java.lang.reflect.Array;


public class Function {
	public static <T> void print_all_arrays(T[] array) {
		int len = array.length; System.out.print("{");
		for (int i = 0; i < len; i++) {
			if (array instanceof String[]) {
				if (i == len - 1) { System.out.printf("\"%s\"",array[i]);
				} else{ System.out.printf("\"%s\",",array[i]); }
			} else if (array instanceof Character[]) {
				if (i == len - 1) { System.out.printf("'%s'",array[i]);
				} else{ System.out.printf("'%s',",array[i]); }
			} else if (array instanceof Float[]) {
				if (i == len - 1) { System.out.printf("%sf",array[i]);
				} else{ System.out.printf("%sf,",array[i]); }
			} else if (array instanceof Number[]) {
				if (i == len - 1) { System.out.printf("%s",array[i]);
				} else{ System.out.printf("%s,",array[i]); }
			} else if (array instanceof Boolean[]) {
				if (i == len - 1) { System.out.printf("%b",array[i]);
				} else{ System.out.printf("%b,",array[i]); }
			} else {throw  new IllegalArgumentException(
						"Illegal type of array,must be String[], Character[](char), " +
								"Number[](int), Double[](double), " +
								"Boolean[](boolean) or Float[](float)" );}
		} System.out.println("}");
	}

	@SuppressWarnings("unchecked") public static <T> T[] remove_selected_array(T[] array, int target_row) {
		if (array == null || target_row < 0 || target_row >= array.length) {
			if (array == null) { System.out.println("array is null"); }
			if (target_row < 0) { System.out.println("target_row is negative pls be positive"); }
			if (target_row >= array.length) { System.out.println("target_row is greater than array length"); }
			return array;
		} T[] new_array = (T[]) Array.newInstance(array.getClass().getComponentType(), array.length - 1);
		int newIndex = 0; for (int i = 0; i < array.length; i++) {
			if (i != target_row) { new_array[newIndex] = array[i]; newIndex++; }
		} return new_array;
	}

}
