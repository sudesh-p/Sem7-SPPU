

import java.util.*; 

public class P4 
{
	static Stack<String> STACK1 = new Stack<String>(); 
	static Stack<String> STACK2 = new Stack<String>(); 
	static Stack<String> STACK3 = new Stack<String>();
	static Stack<String> pSTACK = new Stack<String>();
	static Stack<String> dSTACK = new Stack<String>();
	
	public static void displayS()
	{
		String[][] a=new String[2][3];
		System.out.println();
		
		for(int i=0;i<2;i++)
		{
			for(int j=0;j<3;j++)
			{
				a[i][j]=" ";
			}
		}
		for(int i=0,j=1;i<STACK1.size();i++,j--)
		{
			a[j][0]=STACK1.elementAt(i);
		}
		
		for(int i=0,j=1;i<STACK2.size();i++,j--)
		{
			a[j][1]=STACK2.elementAt(i);
		}
		
		for(int i=0,j=1;i<STACK3.size();i++,j--)
		{
			a[j][2]=STACK3.elementAt(i);
		}
		
		for(int i=0;i<2;i++)
		{
			for(int j=0;j<3;j++)
			{
				System.out.print(a[i][j]+"\t");
			}
			System.out.print("\n");
		}
	}
	public static void InitialState()
	{
		STACK1.push("A"); 
		STACK1.push("B"); 
		STACK2.push("C"); 
		STACK3.push("D"); 
		
		dSTACK.push("A"); 
		dSTACK.push("B"); 
		dSTACK.push("C"); 
		dSTACK.push("D"); 

		System.out.println("Initial State"); 
		System.out.println(); 
		displayS();
	}
	public static void GoalState()
	{
		System.out.println("\nGoal State"); 
		System.out.println();
		
		
		System.out.println("C\t B");
		System.out.println("A\t D");

	}

	public static void preReq1()
	{
		System.out.println("Prerequisite for B on D");
		int f=0;
		for(int i=0;i<dSTACK.size();i++)
		{
			if(STACK1.peek().equals(dSTACK.elementAt(i)))
			{
				f=1;
			}
		}
		if(f==1)
			System.out.println("B is on the table");
		
		
		
		if(!STACK1.peek().equals("B"))
		{	
			while(!STACK1.peek().equals("B"))
			{
				pSTACK.push(STACK1.peek());
				STACK1.pop();
			}
		}
		else
			System.out.println("B is Clear");
		
		
		
		int f1=0;
		for(int i=0;i<dSTACK.size();i++)
		{
			if(STACK3.peek().equals(dSTACK.elementAt(i)))
			{
				f1=1;
			}
		}
		if(f==1)
			System.out.println("D is on the table");
		
		
		if(!STACK3.peek().equals("D"))
		{	
			while(!STACK3.peek().equals("D"))
			{
				pSTACK.push(STACK3.peek());
				STACK3.pop();
			}
		}
		else
			System.out.println("D is Clear");
	
	
	}
	public static void preReq2()
	{
		System.out.println("Prerequisite for C on A");
		int f=0;
		for(int i=0;i<dSTACK.size();i++)
		{
			if(STACK1.peek().equals(dSTACK.elementAt(i)))
			{
				f=1;
			}
		}
		if(f==1)
			System.out.println("A is on the table");
		if(!STACK1.peek().equals("A"))
		{	
			while(!STACK1.peek().equals("A"))
			{
				pSTACK.push(STACK1.peek());
				STACK1.pop();
			}
		}
		else
			System.out.println("A is Clear");
			
		
		
		int f1=0;
		for(int i=0;i<dSTACK.size();i++)
		{
			if(STACK2.peek().equals(dSTACK.elementAt(i)))
			{
				f1=1;
			}
		}
		if(f==1)
			System.out.println("C is on the table");
		if(!STACK2.peek().equals("C"))
		{	
			while(!STACK2.peek().equals("C"))
			{
				pSTACK.push(STACK2.peek());
				STACK2.pop();
			}
		}
		else
			System.out.println("C is Clear");
		
		System.out.println("Arm Empty");
	}
	public static void operation1()
	{
		System.out.println("Operation for B on D");
		String s1=STACK1.peek();
		STACK1.pop();
		displayS();
		System.out.println(s1+" on Arm");
		
		STACK3.push(s1);
		System.out.println("After Operation for B on D");
		System.out.println();	
		displayS();
	}
	
	public static void operation2()
	{
		System.out.println("Operation for C on A");
		String s1=STACK2.peek();
		STACK2.pop();
		displayS();
		System.out.println(s1+" on Arm");
		
		STACK1.push(s1);
		System.out.println("After Operation for C on A");
		System.out.println();	
		displayS();
	}
	public static void main(String args[]) throws Exception
	{ 
		InitialState();
		GoalState();
		preReq1();
		operation1();
		preReq2();
		operation2();
	} 
} 
