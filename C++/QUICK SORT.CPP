#include<stdio.h>
#include<conio.h>
void QuickSort(int a[10],int,int);
int Partition(int a[10],int,int);
int n;
void main()
{
int i;
int a[10];
clrscr();
printf("Enter the number of elements:\n");
scanf("%d",&n);
printf("Enter %d numbers\n",n);
for(i=0;i<n;i++)
{
scanf("%d",&a[i]);
}
QuickSort(a,0,n-1);
printf("Elements in sorted order:\n");
for(i=0;i<n;i++)
{
printf("%d\n",a[i]);
}
getch();
}
void QuickSort(int a[10],int p,int r)
{
int q,i;
if(p<r)
{
q=Partition(a,p,r);
QuickSort(a,p,q-1);
QuickSort(a,q+1,r);
}
}
int Partition(int a[10],int p,int r)
{
int x,j,k,temp1,temp2;
x=a[r];
k=p-1;
for(j=p;j<r;j++)
{
if(a[j]<=x)
{
k++;
temp1=a[j];
a[j]=a[k];
a[k]=temp1;
}
}
temp2=a[r];
a[r]=a[k+1];
a[k+1]=temp2;
return k+1;
}