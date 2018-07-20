#include <iostream>
#include <string>
#include <fstream>
using namespace std;

class Product {
	string product_name;
	int howMuch;
	int howMany;
public:
	Product(string product_name = "9999", int howMuch = 0, int howMany = 0) {//����Ʈ �Ű������� �־���
		this->product_name = product_name;
		this->howMany = howMany;
		this->howMuch = howMuch;
	}
	string getProname() { return product_name; }
	int gethowMuch() { return howMuch; }
	int gethowMany() { return howMany; }
	int getDan() { return howMany * howMuch; }
	void show() {
		cout << "��ǰ : " << getProname();
	}
	Product operator++(int x);
	Product operator--(int x);
};

Product Product::operator++(int x) {//���� ������ �����ε�
	Product tmp = *this;
	tmp.howMany++;
	return tmp;
}

Product Product::operator--(int x) {//���� ������ �����ε�
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
	cout << "ó���� ��ǰ�� ������ �Է��ϼ���->>";
	cin >> main_input;
	Product *p = new Product[main_input];
	cout << endl;

	for (int i = 0; i < main_input-1; i++) {
		cout << "��ǰ ��ȣ�� �Է��ϼ���=>";
		cin >> main_productName;
		cout << "�ܰ��� �Է��ϼ���=>";
		cin >> main_howMuch;
		cout << "������ �Է��ϼ���=>";
		cin >> main_howMany;
		Product pro(main_productName, main_howMuch, main_howMany);
		p[i] = pro;
		cout << endl;
	}
	
	cout << "\t<<��ǰ��� ���>>" << endl;
	cout << "=======================" << endl;
	for (int i = 0; i < main_input; i++) {
		cout << "��ǰ��ȣ : " << p[i].getProname();
		cout << "�ܰ� : " << p[i].gethowMuch();
		cout << "���� : " << p[i].gethowMany();
		cout << "�ݾ� : " << p[i].getDan();
		cout << endl;
	}
	cout << "=======================" << endl;
	cout << "���� ++ ������ �Լ��� ������ ��ǰ��ȣ�� �Է��ϼ��� >>";
	cin >> what_plusName;
	for (int i = 0; i < main_input; i++)
	{
		if (p[i].getProname() == what_plusName)
		{
			Product Pro = p[i]++;
			cout << "��ǰ��ȣ : " << Pro.getProname();
			cout << "�ܰ� : " << Pro.gethowMuch();
			cout << "���� : " << Pro.gethowMany();
			cout << "�ݾ� : " << Pro.getDan();
		}
	}
	cout << endl;
	cout << "���� -- ������ �Լ��� ������ ��ǰ��ȣ�� �Է��ϼ��� >>";
	cin >> what_minName;
	for (int i = 0; i < main_input; i++)
	{
		if (p[i].getProname() == what_minName)
		{
			Product Pro = p[i]++;
			cout << "��ǰ��ȣ : " << Pro.getProname();
			cout << "�ܰ� : " << Pro.gethowMuch();
			cout << "���� : " << Pro.gethowMany();
			cout << "�ݾ� : " << Pro.getDan();
		}
	}
	cout << endl;
	ofstream fout("C:\\Users\\���¼�\\Desktop\\C++\\student.txt");
	if (!fout)
	{
		cout << "student.txt�� �� �� �����ϴ�.";
		return 0;
	}
	for (int i = 0; i < main_input; i++) {
		fout << "��ǰ ��ȣ : " << p[i].getProname() << "�ܰ� : " << p[i].gethowMuch() << "���� : " << p[i].gethowMany() << "�ݾ� : " << p[i].getDan()<< endl;
	}
	fout.close();
	return 0;
}