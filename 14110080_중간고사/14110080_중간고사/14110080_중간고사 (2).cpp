#include <iostream>
#include <string>

using namespace std;

class House
{
	string addr, width, number;
	static int howManyHouse;
public:
	House(string addr, string width, string number)
	{
		cout << "���� ����" << howManyHouse << "ä �Դϴ�." << endl;
		cout << "�ϳ��� ���� �����Ͽ����ϴ�" << endl;
		cout << "�ּҴ�" << addr << ", �����" << width << "�̰�, ��ȭ��ȣ��" << number << "�� ���� �����Ͽ����ϴ�." << endl;
		howManyHouse++;
		cout << "���� ���� " << howManyHouse << "ä �Դϴ�." << endl;
	}
};
int House::howManyHouse = 0;

/*int main()
{
	House Incheon("��õ�� ����", "24", "321-2322");
	House Seoul("����� �ϱ�", "51", "555-6565");
	return 0;
}*/