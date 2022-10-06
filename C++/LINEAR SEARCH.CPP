#include<stdio.h>
#include<conio.h>
void main()
{
clrscr();
int a[10],i,n,k,f=0;
printf("Enter the number of elements\n");
scanf("%d",&n);
printf("Enter %d elements\n",n);
for(i=0;i<n;i++)
{
scanf("%d",&a[i]);
}
printf("Enter the element to be searched\n");
scanf("%d",&k);
for(i=0;i<n;i++)
{
if(a[i]==k)
{
f=i+1;
break;
}
}
if(f!=0)
{
printf("Element is present at position %d",f);
}
else
{
printf("Element is not present");
}
getch();
}



