#include<iostream>
using namespace std;
int factorial(int fact){
  if(fact == 1 || fact == 0)
    return 1;
  else 
    return fact * factorial(fact-1);
}
int main(){
  cout<<"Enter number for factorail";
  unsigned int a ;
  cin>>a;
  cout<<factorial(a);
  return 0;
}
