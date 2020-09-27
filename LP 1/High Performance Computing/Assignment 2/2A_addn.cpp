//How to add two largest vectors by Parallel execution

#include<bits/stdc++.h>
using namespace std;
#define MAX 100
int main()
{
int a[MAX],b[MAX],c[MAX],i;
cout<<"First Vector:";

for(i=0;i<MAX;i++)
	{
		a[i]=rand()%1000;
	}

for(i=0;i<MAX;i++)
	{
		cout<<"\t"<<a[i];
	}

cout<<endl<<"Second Vector:";

for(i=0;i<MAX;i++)
	{
		b[i]=rand()%1000;
	}

for(i=0;i<MAX;i++)
	{
		cout<<"\t"<<b[i];
	}

cout<<"\n Parallel-Vector Addition:(a,b,c)\t";

for(i=0;i<MAX;i++)
	{
		c[i]=a[i]+b[i];
	}

for(i=0;i<MAX;i++)
	{
		cout<<"\t"<<a[i]<<"\t"<<b[i]<<"\t"<<c[i];
		cout<<"\n";
	}
}

