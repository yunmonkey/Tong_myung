package Taeseong;

import java.util.Scanner;

public class Money {
	public Money()
	{
		int money[] = {50000,10000,5000,1000,500,100,50,10};//����� ���� �ʱ�ȭ
		int Many_money[] = new int[8];//�� ����� ���� �� ���Ҵ��� ����
		Scanner scan = new Scanner(System.in);
		System.out.print("���ϴ� �ݾ��� �����ּ���>>");
		int Input_money = scan.nextInt();
		for(int i=0; i<money.length; i++)
		{
			Many_money[i] = Input_money/money[i];
			Input_money = Input_money%money[i];
		}//������ Many_money�� �ְ� �������� �ٽ� Input_money�� ����
		for(int j=0; j<money.length; j++)
		{
			System.out.print(money[j]+"\t");
		}//����� ���� ���
		System.out.println();
		for(int x=0; x<money.length; x++) {
			if(money[x]>=1000)
				System.out.print(Many_money[x]+"��\t");
			else
				System.out.print(Many_money[x]+"��\t");
		}//����� ���� ���� ��� ����� ������ ���̰� ������ �����ϱ� if �� ����

	}
	public static void main(String[] args) {
		Money m = new Money();
	}
}
