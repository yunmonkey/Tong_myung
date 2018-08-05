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
			System.out.println("ÁÖ»çÀ§ ±¼¸°È½¼ö : " + (turn + 1));
			System.out.println(user1 + "ÀÇ ´«±İ : " + user1Arr[index]);
			System.out.println(user2 + "ÀÇ ´«±İ : " + user2Arr[index]);
			if (user1Arr[index] > user2Arr[index]) {
				System.out.println(user1 + "ÀÇ ´«±İÀÌ Ä¿¼­" + user2 + "ÀÇ ¶¥À» »©¾Ò½À´Ï´Ù.");
				if (user1Arr[index] % 2 == 1) {
					System.out.println("test"+user1Arr[index]%2);
					user2Base -= (user1Arr[index] / 2) + 1;
					user1Base += (user1Arr[index] / 2) + 1;
				} else {
					user2Base -= (user1Arr[index] / 2);
					user1Base += (user1Arr[index] / 2);
				}
				System.out.println(user1 + "ÀÇ ¶¥ : " + user1Base);
				System.out.println(user2 + "ÀÇ ¶¥ : " + user2Base);
			}
			if (user2Arr[index] > user1Arr[index]) {
				System.out.println(user2 + "ÀÇ ´«±İÀÌ Ä¿¼­" + user1 + "ÀÇ ¶¥À» »©¾Ò½À´Ï´Ù.");
				if (user2Arr[index] % 2 == 1) {
					user1Base -= (user2Arr[index] / 2) + 1;
					user2Base += (user2Arr[index] / 2) + 1;
				} else {
					user1Base -= (user2Arr[index] / 2);
					user2Base += (user2Arr[index] / 2);
				}
				System.out.println(user1 + "ÀÇ ¶¥ : " + user1Base);
				System.out.println(user2 + "ÀÇ ¶¥ : " + user2Base);
			}
			if (user1Base <= 0 || user2Base <= 0) {
				System.out.println("ÇÑÀ¯ÀúÀÇ ¶¥ÀÌ »¯°Ü °ÔÀÓÀÌ ³¡³µ½À´Ï´Ù.");
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