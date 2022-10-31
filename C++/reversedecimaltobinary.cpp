#include <iostream>
#include <math.h> 
using namespace std;

int main() {
  int dec;
  cout<<"Enter a number: ";
  cin>>dec;
  dec = abs(dec);
  
  int bin = 0;
  int i = 0;
  
  while (dec!=0){
    int bit = dec&1; // n = 5 --> 101, 1&1=1, 0&1=0, 1&1=0
    bin = bin + (bit * pow(10, i));
    dec = dec>>1;
    i++;
  }
  
  int neg = ~bin + 1;
  
  int ans = ~neg + 1;
  cout<<ans <<endl;
}
