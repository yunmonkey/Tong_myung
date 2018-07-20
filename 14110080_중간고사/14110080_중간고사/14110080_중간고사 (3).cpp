#include <iostream>
#include <string>

using namespace std;

class Market
{
	string name;
	int howMuch;
	int howMany;
	int money;
	int size = 0;
public:
	Market(int size = 9999)
	{
		if (size == 9999)
		{
			this->howMany = 0;
			this->howMuch = 0;
			this->name = "9999";
		}
		this->size = size;
	}
	int calculation(int a, int b)
	{
		return a * b;
	}
	void input()
	{
		Market *p = new Market[size];
		for (int i = 0; i < size-1; i++) 
		{
			cout << endl;
			cout << "��ǰ ��ȣ�� �Է��ϼ���=>";
			cin >> p[i].name;
			cout << "�ܰ��� �Է��ϼ���=>";
			cin >> p[i].howMuch;
			cout << "������ �Է��ϼ���=>";
			cin >> p[i].howMany;
			cout << endl;
		}

		string searchName;
		cout << "\t" << "<<��ǰ ��� ���>>" << "\t" << endl;;
		cout << "======================================" << endl;
		int i = 0;
		for (i = 0; i < size-1; i++)
		{
			cout << "��ǰ��ȣ:" << p[i].name << "\t" << "�ܰ�:" << p[i].howMuch << "����:" << p[i].howMany << "�ݾ�:" << p[i].calculation(p[i].howMuch,p[i].howMany) << endl;
		}
		cout << "��ǰ��ȣ:" << p[i].name << "\t" << "�ܰ�:" << p[i].howMuch << "����:" << p[i].howMany << "�ݾ�:" << p[i].calculation(p[i].howMuch, p[i].howMany) << endl;
		
		cout << "======================================" << endl;
		cout << "ã�� ��ǰ��ȣ�� �Է��ϼ���>>";
		cin >> searchName;
		for (int i = 0; i < size-1; i++)
		{
			if (searchName == p[i].name)
			{
				cout << "��ǰ��ȣ:" << p[i].name << "\t" << "�ܰ�:" << p[i].howMuch << "����:" << p[i].howMany << "�ݾ�:" << p[i].calculation(p[i].howMuch,p[i].howMany) << endl;
			}
		}
	}
};

int main()
{
	int HowMany;
	cout << "ó���� ��ǰ ������ �Է��ϼ���->>";
	cin >> HowMany;
	Market *market = new Market(HowMany);
	market->input();
	return 0;
}
