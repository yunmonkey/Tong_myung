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
		cout << "집은 전부" << howManyHouse << "채 입니다." << endl;
		cout << "하나의 집을 생성하였습니다" << endl;
		cout << "주소는" << addr << ", 평수는" << width << "이고, 전화번호는" << number << "인 집을 생성하였습니다." << endl;
		howManyHouse++;
		cout << "집은 전부 " << howManyHouse << "채 입니다." << endl;
	}
};
int House::howManyHouse = 0;

/*int main()
{
	House Incheon("인천시 남구", "24", "321-2322");
	House Seoul("서울시 북구", "51", "555-6565");
	return 0;
}*/