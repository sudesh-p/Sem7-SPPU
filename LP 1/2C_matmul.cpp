#include<bits/stdc++.h>
using namespace std;
int main()
{
int i,thread;
srand(time(0));
int n;
cout<<"Enter N:";
cin>>n;
int a[n][n],b[n][n],c[n][n];

for(int i=0;i<n;i++)
	{
		for(int j=0;j<n;j++)
			{ 

				a[i][j]=rand()%n;
				b[i][j]=rand()%n;
			}	
	}

    cout<<endl<<"Matrix 1: "<<endl;
    for(int row=0;row<n;row++)
    {
	for(int col=0;col<n;col++)
	{
		cout<<"\t"<<a[row][col];
	}
	cout<<""<<endl;
    }
    
    cout<<endl<<"Matrix 2: "<<endl;
    for(int row=0;row<n;row++)
    {
	for(int col=0;col<n;col++)
	{
		cout<<"\t"<<b[row][col];
	}
	cout<<""<<endl;
    }

	for(int i=0;i<n;i++)
	{
		for(int j=0;j<n;j++)
		{
            c[i][j]=0;
			for(int k=0;k<n;k++)
			{
				c[i][j]+=a[i][k]*b[k][j];
			}	
		}
	}

cout<<"Output: "<<endl;
	for(int i=0;i<n;i++)
	{
		for(int j=0;j<n;j++)
			{
				cout<<"\t"<<c[i][j];
			}	
			cout<<endl;
	}
return 0;
}
