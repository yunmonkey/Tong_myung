package Taeseong;

import java.util.Scanner;

public class Money {
	public Money()
	{
		int money[] = {50000,10000,5000,1000,500,100,50,10};//지폐랑 동전 초기화
		int Many_money[] = new int[8];//각 지폐랑 동전 얼마 남았는지 갯수
		Scanner scan = new Scanner(System.in);
		System.out.print("원하는 금액을 적어주세요>>");
		int Input_money = scan.nextInt();
		for(int i=0; i<money.length; i++)
		{
			Many_money[i] = Input_money/money[i];
			Input_money = Input_money%money[i];
		}//갯수를 Many_money에 넣고 나머지를 다시 Input_money에 저장
		for(int j=0; j<money.length; j++)
		{
			System.out.print(money[j]+"\t");
		}//지폐랑 동전 출력
		System.out.println();
		for(int x=0; x<money.length; x++) {
			if(money[x]>=1000)
				System.out.print(Many_money[x]+"장\t");
			else
				System.out.print(Many_money[x]+"개\t");
		}//지폐랑 동전 갯수 출력 지폐는 단위가 장이고 동전은 갯수니까 if 문 썻음

	}
	public static void main(String[] args) {
		Money m = new Money();
	}
}
