#include <iostream>
#include <string>

using namespace std;

class Histogram
{
	string histo = "";
	int alpha[26] = { 0 };
	int len = 0;
public:
	Histogram(string mainhisto)
	{
		this->histo.append(mainhisto);
		for (int i = 0; i < histo.length(); i++)
		{
			if (isalpha(histo[i]))
			{
				histo[i] = tolower(histo[i]);
				char tmp = histo[i];
				alpha[tmp - 'a']++;
				len++;
			}
		}
	}
	void put(string hist)
	{
		this->histo.append(hist);
		for (int i = 0; i < hist.length(); i++)
		{
			if (isalpha(histo[i]))
			{
				histo[i] = tolower(histo[i]);
				char tmp = histo[i];
				alpha[tmp - 'a']++;
				len++;
			}
		}
	}
	void putc(string hipon)
	{
		this->histo.append(hipon);
		for (int i = 0; i < hipon.length(); i++)
		{
			if (isalpha(histo[i]))
			{
				histo[i] = tolower(histo[i]);
				char tmp = histo[i];
				alpha[tmp - 'a']++;
				len++;
			}
		}
	}
	void print()
	{
		for (int i = 0; i < histo.length(); i++)
		{
			cout << histo[i];
		}
		cout << endl;
		cout << "ÃÑ ¾ËÆÄºª ¼ö : " << len << endl;
		for (char c = 'a'; c <= 'z'; c++)
		{
			cout << c << "(" << alpha[c - 'a'] << ")";
			for (int i = 0; i < alpha[c - 'a']; i++)
				cout << "*";
			cout << endl;
		}
	}
};

/*int main()
{
	Histogram elvisHisto("Wise men say, only fools rush in But I can`t help.");
	elvisHisto.put("falling in love with you");
	elvisHisto.putc("-");
	elvisHisto.put("Elvis Presley");
	elvisHisto.print();
	return 0;
	
}*/