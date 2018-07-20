#include <iostream>
#include <string>
#include <fstream>
using namespace std;

class Product {
	string product_name;
	int howMuch;
	int howMany;
public:
	Product(string product_name = "9999", int howMuch = 0, int howMany = 0) {//디폴트 매개변수를 주었음
		this->product_name = product_name;
		this->howMany = howMany;
		this->howMuch = howMuch;
	}
	string getProname() { return product_name; }
	int gethowMuch() { return howMuch; }
	int gethowMany() { return howMany; }
	int getDan() { return howMany * howMuch; }
	void show() {
		cout << "상품 : " << getProname();
	}
	Product operator++(int x);
	Product operator--(int x);
};

Product Product::operator++(int x) {//후위 연산자 오버로딩
	Product tmp = *this;
	tmp.howMany++;
	return tmp;
}

Product Product::operator--(int x) {//후위 연산자 오버로딩
	Product tmp = *this;
	tmp.howMany--;
	return tmp;
}

int main()
{
	int main_input = 0; 
	int main_howMany, main_howMuch;
	string main_productName;
	string what_plusName, what_minName;
	cout << "처리할 상품의 개수를 입력하세요->>";
	cin >> main_input;
	Product *p = new Product[main_input];
	cout << endl;

	for (int i = 0; i < main_input-1; i++) {
		cout << "상품 번호를 입력하세요=>";
		cin >> main_productName;
		cout << "단가를 입력하세요=>";
		cin >> main_howMuch;
		cout << "수량을 입력하세요=>";
		cin >> main_howMany;
		Product pro(main_productName, main_howMuch, main_howMany);
		p[i] = pro;
		cout << endl;
	}
	
	cout << "\t<<상품목록 출력>>" << endl;
	cout << "=======================" << endl;
	for (int i = 0; i < main_input; i++) {
		cout << "상품번호 : " << p[i].getProname();
		cout << "단가 : " << p[i].gethowMuch();
		cout << "수량 : " << p[i].gethowMany();
		cout << "금액 : " << p[i].getDan();
		cout << endl;
	}
	cout << "=======================" << endl;
	cout << "후위 ++ 연산자 함수를 수행할 상품번호를 입력하세요 >>";
	cin >> what_plusName;
	for (int i = 0; i < main_input; i++)
	{
		if (p[i].getProname() == what_plusName)
		{
			Product Pro = p[i]++;
			cout << "상품번호 : " << Pro.getProname();
			cout << "단가 : " << Pro.gethowMuch();
			cout << "수량 : " << Pro.gethowMany();
			cout << "금액 : " << Pro.getDan();
		}
	}
	cout << endl;
	cout << "후위 -- 연산자 함수를 수행할 상품번호를 입력하세요 >>";
	cin >> what_minName;
	for (int i = 0; i < main_input; i++)
	{
		if (p[i].getProname() == what_minName)
		{
			Product Pro = p[i]++;
			cout << "상품번호 : " << Pro.getProname();
			cout << "단가 : " << Pro.gethowMuch();
			cout << "수량 : " << Pro.gethowMany();
			cout << "금액 : " << Pro.getDan();
		}
	}
	cout << endl;
	ofstream fout("C:\\Users\\윤태성\\Desktop\\C++\\student.txt");
	if (!fout)
	{
		cout << "student.txt를 열 수 없습니다.";
		return 0;
	}
	for (int i = 0; i < main_input; i++) {
		fout << "상품 번호 : " << p[i].getProname() << "단가 : " << p[i].gethowMuch() << "수량 : " << p[i].gethowMany() << "금액 : " << p[i].getDan()<< endl;
	}
	fout.close();
	return 0;
}