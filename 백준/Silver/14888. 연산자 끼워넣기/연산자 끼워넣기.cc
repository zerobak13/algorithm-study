#include<iostream>
using namespace std;

int operands[11];
int operators[4];
int n;

int MAX=-1000000001;
int MIN = 1000000001;
void solve(int calc, int index) {
	if (index == n) {
		if (calc > MAX) {
			MAX = calc;
		}
		if (calc < MIN) {
			MIN = calc;
		}
		return;
	}

	for (int i = 0; i < 4; i++) {
		if (operators[i] >= 1) {
			operators[i]--;
			if (i == 0) {
				solve(calc + operands[index], index+1);
			}
			else if (i == 1) {
				solve(calc - operands[index], index+1);
			}
			else if (i == 2) {
				solve(calc * operands[index], index+1);
			}
			else if (i == 3) {
				solve(calc / operands[index], index+1);
			}
			operators[i]++;
		}

	}




}


int main() {
	
	cin >> n;
	
	for (int i = 0; i < n; i++) {
		cin >> operands[i];
	}
	for (int i = 0; i < 4; i++) {
		cin >> operators[i];
	}
	solve(operands[0], 1);
	cout << MAX << endl << MIN << endl;


	return 0;
}