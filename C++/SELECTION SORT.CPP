#include<stdio.h>
#include<conio.h>
void main()
{
clrscr();
int a[20],n,i,j,min,temp;
printf("Enter the number of elements\n");
scanf("%d",&n);
printf("Enter %d elements\n",n);
for(i=0;i<n;i++)
{
scanf("%d",&a[i]);
}
for(i=0;i<n;i++)
{
min=i;
for(j=i;j<n;j++)
{
if(a[j]<a[min])
{
min=j;
}
}
temp=a[min];
a[min]=a[i];
a[i]=temp;
}
printf("Elements in sorted order:\n");
for(i=0;i<n;i++)
{
printf("%d\n",a[i]);
}
getch();
}
