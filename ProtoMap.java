package KakaoCode;

import java.lang.reflect.Array;
import java.util.Scanner;
/*
 īī�� ������ ���� ���� ������ �� Ȱ���ϸ� Ǯ�� �ְ� �س���
 ���⼭ ���Ӱ� �˰Ե� ���� Integer�̳� Ŭ�������� �����ϴ� �Լ� toBinaryString(int n) ���̳ʸ� ��Ʈ�� �Լ����� ��Ʈ���� ������
 �׿� �ش��ϴ� ������ ������ �������ش�
 �� ���������� replace("ã���ܾ�", "�ٲ� �ܾ�") �Լ��� �Ἥ ���� ���־���.
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
		System.out.println("----ù��° ������ ����----");
		print(resultArr);
		System.out.println();
		decodeArr(6, caseTwo_arr1, caseTwo_arr2);
		System.out.println("----�ι�° ������ ����----");
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
