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
		cout << "상품 설명>>";
		cin >> ProName;
		cout << "생산자>>";
		cin >> ProPeople;
		cout << "가격>>";
		cin >> price;
	}
	string getProName()//상품 설명
	{
		return ProName;
	}
	string getProPeople()//생산자
	{
		return ProPeople;
	}
	int getPrice()//가격
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
		cout << "책제목>>";
		cin >> BookName;
		cout << "저자>>";
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
		cout << "---- 상품ID : " << getId() << endl;
		cout << "상품 설명 : " << getProName() << endl;
		cout << "생산자 : " << getProPeople() << endl;
		cout << "가격 : " << getPrice() << endl;
		cout << "책제목 : " << getBookName() << endl;
		cout << "저자 : " << getAthor() << endl;
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
		cout << "언어>>";
		cin >> language;
	}
	string getLanguage()
	{
		return language;
	}
	void show()
	{
		cout << "---- 상품ID : " << getId() << endl;
		cout << "상품 설명 : " << getProName() << endl;
		cout << "생산자 : " << getProPeople() << endl;
		cout << "가격 : " << getPrice() << endl;
		cout << "책제목 : " << getBookName() << endl;
		cout << "저자 : " << getAthor() << endl;
		cout << "ISBN : " << getIsbn() << endl;
		cout << "언어 : " << getLanguage() << endl;
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
		cout << "---- 상품ID : " << getId() << endl;
		cout << "상품 설명 : " << getProName() << endl;
		cout << "생산자 : " << getProPeople() << endl;
		cout << "가격 : " << getPrice() << endl;
		cout << "앨범제목 : " << getAlbunName() << endl;
		cout << "가수 : " << getSinger() << endl;
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
	cout << "***** 상품 관리 프로그램을 작동합니다 *****" << endl;
	while (true)
	{
		cout << "상품추가(1), 모든 상품 조회(2), 끝내기(3) ?";
		cin >> firstInput;
		switch (firstInput)
		{
		case 1: cout << "상품종류 책(1), 음악CD(2), 회화책(3) ?";
			cin >> secondInput;
			//switch (secondInput)
			//{
			//case 1:
			if (secondInput == 1) {
				cout << "상품설명>>";
				cin >> mainProName;
				cout << "생산자>>";
				cin >> mainProPeople;
				cout << "가격>>";
				cin >> mainPrice;
				cout << "책제목>>";
				cin >> BookName;
				cout << "저자>>";
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
				cout << "상품설명>>";
				cin >> mainProName;
				cout << "생산자>>";
				cin >> mainProPeople;
				cout << "가격>>";
				cin >> mainPrice;
				cout << "앨범제목>>";
				cin >> mainAlbumName;
				cout << "가수>>";
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
				cout << "상품설명>>";
				cin >> mainProName;
				cout << "생산자>>";
				cin >> mainProPeople;
				cout << "가격>>";
				cin >> mainPrice;
				cout << "책제목>>";
				cin >> BookName;
				cout << "저자>>";
				cin >> mainAthor;
				cout << "언어>>";
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