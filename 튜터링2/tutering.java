package Taeseong;

import java.util.Random;
import java.util.Scanner;

public class tutering {
	public tutering()
	{
		Scanner scan = new Scanner(System.in);
		Random  ran = new Random();
		int howMany = 0;
		int Input;
		System.out.print("���� ���� ������ �����մϴ�.");
		System.out.println();
		int max = Math.max(0, 99);
		int min = Math.min(0, 99);
		int ranNum = ran.nextInt(100);
		while(true)
		{
			System.out.println(min+"-"+max);
			System.out.print((howMany+1)+">>");
			Input = scan.nextInt();
			if(Input>ranNum)
			{
				System.out.println("�� ����");
				max = Input;
			}
			if(Input<ranNum) {
				System.out.println("�� ����");
				min = Input;
			}
			if(Input==ranNum)
				break;
			howMany++;
		}
		Continue();
	}
	void Continue()
	{
		Scanner scan =  new Scanner(System.in);
		String yesorNo;
		System.out.println("�¾ҽ��ϴ�.");
		System.out.print("�ٽ� �Ͻðڽ��ϱ�?(y/n)>>");
		yesorNo = scan.nextLine();
		if(yesorNo.equals("y"))
			new tutering();
		else
			return;
		
	}
	
	public static void main(String[] args) {
		tutering f = new tutering();
	}
}


