package KakaoCode;

import java.lang.reflect.Array;
import java.util.Scanner;
/*
 카카오 문제를 보면 이진 진법을 잘 활용하면 풀수 있게 해놨다
 여기서 새롭게 알게된 점이 Integer이너 클래스에서 제공하는 함수 toBinaryString(int n) 바이너리 스트링 함수에다 인트값을 넣으면
 그에 해당하는 이진수 값으로 변경해준다
 그 이진수값을 replace("찾을단어", "바꿀 단어") 함수를 써서 변경 해주었다.
 */
public class ProtoMap {
	int n;
	int caseOne_arr1[] = { 9, 20, 28, 18, 11 };
	int caseOne_arr2[] = { 30, 1, 21, 17, 28 };
	int caseTwo_arr1[] = { 46, 33, 33, 22, 31, 50 };
	int caseTwo_arr2[] = { 27, 56, 19, 14, 14, 10 };
	String[] resultArr;

	public ProtoMap() {
		decodeArr(5, caseOne_arr1, caseOne_arr2);
		System.out.println("----첫번째 프로토 지도----");
		print(resultArr);
		System.out.println();
		decodeArr(6, caseTwo_arr1, caseTwo_arr2);
		System.out.println("----두번째 프로토 지도----");
		print(resultArr);
	}

	String[] decodeArr(int n, int[] arr1, int[] arr2) {
		resultArr = new String[n];
		for (int i = 0; i < arr1.length; i++) {
			resultArr[i] = Integer.toBinaryString(arr1[i] | arr2[i]).replace("0", " ").replace("1",
					"#");
		}
		return resultArr;
	}

	void print(String[] resultArr) {
		for (int i = 0; i < resultArr.length; i++) {
			System.out.println(resultArr[i]);
		}
	}

	public static void main(String[] args) {
		ProtoMap f = new ProtoMap();
	}
}
