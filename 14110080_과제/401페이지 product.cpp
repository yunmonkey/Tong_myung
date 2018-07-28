#include <iostream>
#include <string>
using namespace std;

class Product
{
private:
	int id;
	string ProName;
	string ProPeople;
	int price;
public:
	Product() { ; }
	Product(int id, string ProName, string ProPeople, int price)
	{
		this->id = id;
		this->price = price;
		this->ProName = ProName;
		this->ProPeople = ProPeople;
	}
	void input()
	{
		cout << "��ǰ ����>>";
		cin >> ProName;
		cout << "������>>";
		cin >> ProPeople;
		cout << "����>>";
		cin >> price;
	}
	string getProName()//��ǰ ����
	{
		return ProName;
	}
	string getProPeople()//������
	{
		return ProPeople;
	}
	int getPrice()//����
	{
		return price;
	}
	int getId()//id
	{
		return id;
	}
	virtual void show() = 0;
};
class Book : public Product
{
	string BookName;
	string athor;
	int ISBN;
public:
	Book() { ; }
	Book(string ProName, string ProPeople, int price ,string BookName, string athor,int id, int ISBN) : Product(id, ProName, ProPeople, price)
	{
		
		this->athor = athor;
		this->ISBN = ISBN;
		this->BookName = BookName;
	}
	void BookInput()
	{
		input();
		cout << "å����>>";
		cin >> BookName;
		cout << "����>>";
		cin >> athor;
		cout << "ISBN>>";
		cin >> ISBN;
	}
	string getBookName()
	{
		return BookName;
	}
	string getAthor()
	{
		return athor;
	}
	int getIsbn()
	{
		return ISBN;
	}
	void show()
	{
		cout << "---- ��ǰID : " << getId() << endl;
		cout << "��ǰ ���� : " << getProName() << endl;
		cout << "������ : " << getProPeople() << endl;
		cout << "���� : " << getPrice() << endl;
		cout << "å���� : " << getBookName() << endl;
		cout << "���� : " << getAthor() << endl;
		cout << "ISBN : " << getIsbn() << endl;
	}
};
class ConversationBook : public Book
{
private:
	string language;
public:
	ConversationBook(string language, string ProName, string ProPeople, int price ,string BookName, string athor, int id, int ISBN) : Book(ProName, ProPeople, price, BookName, athor, id, ISBN)
	{
		this->language = language;
	}
	void inputConversationBook()
	{
		input();
		cout << "���>>";
		cin >> language;
	}
	string getLanguage()
	{
		return language;
	}
	void show()
	{
		cout << "---- ��ǰID : " << getId() << endl;
		cout << "��ǰ ���� : " << getProName() << endl;
		cout << "������ : " << getProPeople() << endl;
		cout << "���� : " << getPrice() << endl;
		cout << "å���� : " << getBookName() << endl;
		cout << "���� : " << getAthor() << endl;
		cout << "ISBN : " << getIsbn() << endl;
		cout << "��� : " << getLanguage() << endl;
	}
};
class CompactDisc : public Product
{
	string singer;
	string albumName;
public:
	CompactDisc(string ProName, string ProPeople, string singer, string albumName, int id, int price) : Product(id, ProName, ProPeople, price)
	{
		this->albumName = albumName;
		this->singer = singer;
	}
	string getSinger()
	{
		return singer;
	}
	string getAlbunName()
	{
		return albumName;
	}
	void show()
	{
		cout << "---- ��ǰID : " << getId() << endl;
		cout << "��ǰ ���� : " << getProName() << endl;
		cout << "������ : " << getProPeople() << endl;
		cout << "���� : " << getPrice() << endl;
		cout << "�ٹ����� : " << getAlbunName() << endl;
		cout << "���� : " << getSinger() << endl;
	}
};

int main()
{
	int id = 0;
	int index = 0;
	int firstInput;
	int secondInput;
	int mainPrice, mainIsbn;
	string mainAthor, BookName, mainLanguage, mainProName, mainProPeople, mainAlbumName, mainSinger;
	Product* p[100];
	cout << "***** ��ǰ ���� ���α׷��� �۵��մϴ� *****" << endl;
	while (true)
	{
		cout << "��ǰ�߰�(1), ��� ��ǰ ��ȸ(2), ������(3) ?";
		cin >> firstInput;
		switch (firstInput)
		{
		case 1: cout << "��ǰ���� å(1), ����CD(2), ȸȭå(3) ?";
			cin >> secondInput;
			//switch (secondInput)
			//{
			//case 1:
			if (secondInput == 1) {
				cout << "��ǰ����>>";
				cin >> mainProName;
				cout << "������>>";
				cin >> mainProPeople;
				cout << "����>>";
				cin >> mainPrice;
				cout << "å����>>";
				cin >> BookName;
				cout << "����>>";
				cin >> mainAthor;
				cout << "ISBN>>";
				cin >> mainIsbn;
				Book* b = new Book(mainProName, mainProPeople, mainPrice, BookName, mainAthor, id, mainIsbn);
				p[index] = b;
				id++;
				index++;
				//break;
			}
				//break;
			//case 2:
			if (secondInput == 2) {
				cout << "��ǰ����>>";
				cin >> mainProName;
				cout << "������>>";
				cin >> mainProPeople;
				cout << "����>>";
				cin >> mainPrice;
				cout << "�ٹ�����>>";
				cin >> mainAlbumName;
				cout << "����>>";
				cin >> mainSinger;
				CompactDisc* disc = new CompactDisc(mainProName, mainProPeople, mainSinger, mainAlbumName, id, mainPrice);
				p[index] = disc;
				id++;
				index++;
				//break;
			}
			//break;
			//case 3: 
			 if (secondInput == 3) {
				cout << "��ǰ����>>";
				cin >> mainProName;
				cout << "������>>";
				cin >> mainProPeople;
				cout << "����>>";
				cin >> mainPrice;
				cout << "å����>>";
				cin >> BookName;
				cout << "����>>";
				cin >> mainAthor;
				cout << "���>>";
				cin >> mainLanguage;
				cout << "ISBN>>";
				cin >> mainIsbn;
				ConversationBook* converBook = new ConversationBook(mainLanguage, mainProName, mainProPeople, mainPrice, BookName, mainAthor, id, mainIsbn);
				p[index] = converBook;
				id++; index++; //break;
			}
			break;
			//}
		case 2:
			for (int i = 0; i < index; i++)
				p[i]->show();
			break;
		case 3:
			return 0;
			break;
		}
	}
}