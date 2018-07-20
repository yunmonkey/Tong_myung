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
			cout << "상품 번호를 입력하세요=>";
			cin >> p[i].name;
			cout << "단가를 입력하세요=>";
			cin >> p[i].howMuch;
			cout << "수량을 입력하세요=>";
			cin >> p[i].howMany;
			cout << endl;
		}

		string searchName;
		cout << "\t" << "<<상품 목록 출력>>" << "\t" << endl;;
		cout << "======================================" << endl;
		int i = 0;
		for (i = 0; i < size-1; i++)
		{
			cout << "상품번호:" << p[i].name << "\t" << "단가:" << p[i].howMuch << "수량:" << p[i].howMany << "금액:" << p[i].calculation(p[i].howMuch,p[i].howMany) << endl;
		}
		cout << "상품번호:" << p[i].name << "\t" << "단가:" << p[i].howMuch << "수량:" << p[i].howMany << "금액:" << p[i].calculation(p[i].howMuch, p[i].howMany) << endl;
		
		cout << "======================================" << endl;
		cout << "찾을 상품번호를 입력하세요>>";
		cin >> searchName;
		for (int i = 0; i < size-1; i++)
		{
			if (searchName == p[i].name)
			{
				cout << "상품번호:" << p[i].name << "\t" << "단가:" << p[i].howMuch << "수량:" << p[i].howMany << "금액:" << p[i].calculation(p[i].howMuch,p[i].howMany) << endl;
			}
		}
	}
};

int main()
{
	int HowMany;
	cout << "처리할 상품 갯수를 입력하세요->>";
	cin >> HowMany;
	Market *market = new Market(HowMany);
	market->input();
	return 0;
}
