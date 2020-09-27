#include<bits/stdc++.h>
using namespace std;

int main()
{
srand(time(0));  // Initialize Random Number generator. 
int m=3,n=3;
int mat[m][n],vec[n],out[m];

//Matrix of Size 3x2
for(int row=0;row<m;row++)
{
	for(int col=0;col<n;col++)
	{
		mat[row][col]=(rand() % 10);
	}
}

//Display matrix
cout<<"Input Matrix"<<endl;
for(int row=0;row<m;row++)
{
	for(int col=0;col<n;col++)
	{
		cout<<"\t"<<mat[row][col];
	}
	cout<<""<<endl;
}

for(int row=0;row<n;row++)
	{
		vec[row]=(rand() % 10);
	}

//Display Vector
cout<<"Input Col-Vector"<<endl;
for(int row=0;row<n;row++)
	{
		cout<<vec[row]<<endl;
	}

for(int row=0;row<m;row++)
{
		out[row]=0;
		for(int col=0;col<n;col++)
		{
			out[row]+=mat[row][col]*vec[col];
		}
}


//Display Resultant Vector
cout<<endl<<"Resultant Col-Vector"<<endl;
for(int row=0;row<m;row++)
	{
		cout<<"vec["<<row<<"]:"<<out[row]<<endl;
	}
return 0;
}