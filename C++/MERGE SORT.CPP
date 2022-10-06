#include<stdio.h>
#include<conio.h>
void MergeSort(int a[10],int,int);
void Merge(int a[10],int,int,int);
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
MergeSort(a,0,n-1);
printf("Elements in sorted order:\n");
for(i=0;i<n;i++)
{
printf("%d\n",a[i]);
}
getch();
}
void MergeSort(int a[10],int p,int r)
{
int q;
if(p<r)
{
q=(p+r)/2;
MergeSort(a,p,q);
MergeSort(a,q+1,r);
Merge(a,p,q,r);
}
}
void Merge(int a[10],int p,int q,int r)
{
int j,k,l,n1,n2;
n1=q-p+1;
n2=r-q;
int a1[20];
int a2[20];
for(j=1;j<=n1;j++)
{
a1[j]=a[p+j-1];
}
for(k=1;k<=n2;k++)
{
a2[k]=a[q+k];
}
a1[n1+1]=500;
a2[n2+1]=500;
j=1;
k=1;
for(l=p;l<=r;l++)
{
if(a1[j]<=a2[k])
{
a[l]=a1[j];
j++;
}
else
{
a[l]=a2[k];
k++;
}
}

}