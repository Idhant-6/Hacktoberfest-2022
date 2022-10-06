#include<stdio.h>
#include<conio.h>
void main()
{
clrscr();
int a[20],n,i,j,s,temp;
printf("Enter the number of elements\n");
scanf("%d",&n);
printf("Enter %d elements\n",n);
for(i=0;i<n;i++)
{
scanf("%d",&a[i]);
}
for(i=0;i<n;i++)
{
s=0;
for(j=0;j<n;j++)
{
if(a[j]>a[j+1])
{
s=1;
temp=a[j];
a[j]=a[j+1];
a[j+1]=temp;
}
}
if(s==0)
{
break;
}
}
printf("Elements in sorted order:\n");
for(i=0;i<n;i++)
{
printf("%d\n",a[i]);
}
getch();
}
