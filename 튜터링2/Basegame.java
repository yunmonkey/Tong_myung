package Taeseong;

import java.util.Random;

public class Basegame {
	public Basegame() {
		String user1 = "user1";
		String user2 = "user2";
		int turn = 0;
		int user1Base = 10;
		int user2Base = 10;
		int[] user1Arr = new int[100];
		int[] user2Arr = new int[100];
		Random r = new Random();
		int index = 0;
		for (int i = 0; i < user1Arr.length; i++) {
			user1Arr[i] = r.nextInt(6) + 1;
			user2Arr[i] = r.nextInt(6) + 1;
		}
		while (true) {
			System.out.println("�ֻ��� ����Ƚ�� : " + (turn + 1));
			System.out.println(user1 + "�� ���� : " + user1Arr[index]);
			System.out.println(user2 + "�� ���� : " + user2Arr[index]);
			if (user1Arr[index] > user2Arr[index]) {
				System.out.println(user1 + "�� ������ Ŀ��" + user2 + "�� ���� ���ҽ��ϴ�.");
				if (user1Arr[index] % 2 == 1) {
					System.out.println("test"+user1Arr[index]%2);
					user2Base -= (user1Arr[index] / 2) + 1;
					user1Base += (user1Arr[index] / 2) + 1;
				} else {
					user2Base -= (user1Arr[index] / 2);
					user1Base += (user1Arr[index] / 2);
				}
				System.out.println(user1 + "�� �� : " + user1Base);
				System.out.println(user2 + "�� �� : " + user2Base);
			}
			if (user2Arr[index] > user1Arr[index]) {
				System.out.println(user2 + "�� ������ Ŀ��" + user1 + "�� ���� ���ҽ��ϴ�.");
				if (user2Arr[index] % 2 == 1) {
					user1Base -= (user2Arr[index] / 2) + 1;
					user2Base += (user2Arr[index] / 2) + 1;
				} else {
					user1Base -= (user2Arr[index] / 2);
					user2Base += (user2Arr[index] / 2);
				}
				System.out.println(user1 + "�� �� : " + user1Base);
				System.out.println(user2 + "�� �� : " + user2Base);
			}
			if (user1Base <= 0 || user2Base <= 0) {
				System.out.println("�������� ���� ���� ������ �������ϴ�.");
				break;
			}
			index++;
			turn++;
		}

	}

	public static void main(String[] args) {
		Basegame f = new Basegame();
	}
}