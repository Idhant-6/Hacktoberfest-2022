#include <stdio.h>
#include <math.h>
int main()
{
  int n,num,rem,sum=0;
  printf("ENTER A NUMBER: ");
  scanf("%d",&n);
  num=n;
  while (n!=0)
  {
    rem = n % 10;
    sum = sum + pow (rem,3);
    n = n/10;
  }
  if (sum==num)
  {
    printf("%d IS AN ARMSTRONG NUMBER\n",num);
  }
  else
  {
    printf("%d IS NOT AN ARMSTRONG NUMBER\n",num);
  }
  return 0;
}
