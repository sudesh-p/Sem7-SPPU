import java.util.Scanner;
import java.util.Arrays;

public class P3
{
	public static void main(String args[])throws Exception
	{
		
		String[] stocks={"share_of_ownership","shareholder","raise_money_for_startup","common_stock","preferred_stock"};
		String[] bonds={"lending_money_to_a_company","bondholder","treasury_bonds","foreign_bonds","municipal_bonds"};
		String[] cash_equivalent={"savings_accounts","money_market_accounts","certificates_of_deposit","treasury_bills","commercial_papers"};
		
		String[] Investment= {"stocks","bonds","cash_equivalent"};
		int c1=0,c2=0,c3=0;
		Scanner sc=new Scanner(System.in);
		
		for(int i=0;i<stocks.length;i++)
		{
			System.out.println("Bot:Is it this your requirement "+stocks[i]);
			System.out.print("You:");
			String ans=sc.next();
			if(ans.equalsIgnoreCase("y") || ans.equalsIgnoreCase("yes"))
			{
				c1++;
			}
			else 
				continue;
		}
		if(c1==(stocks.length))
		{
			System.out.println("Bot:You shound invest in stocks");
			System.out.println("Bot:Thank you.");
			System.exit(0);
		}
		else
		{
			for(int i=0;i<bonds.length;i++)
			{
				System.out.println("Bot:Is it this your requirement "+bonds[i]);
				System.out.print("You:");
				String ans=sc.next();
				if(ans.equalsIgnoreCase("y") || ans.equalsIgnoreCase("yes"))
				{
					c2++;
				}
				else 
					continue;
			}
		}
		
		if(c2==(bonds.length))
		{
			System.out.println("Bot:You shound invest in bonds");
			System.out.println("Bot:Thank you.");
			System.exit(0);
		}
		else
		{
			for(int i=0;i<cash_equivalent.length;i++)
			{
				System.out.println("Bot:Is it this your requirement "+cash_equivalent[i]);
				System.out.print("You:");
				String ans=sc.next();
				if(ans.equalsIgnoreCase("y") || ans.equalsIgnoreCase("yes"))
				{
					c3++;
				}
				else 
					continue;
			}
		}
		if(c3==(cash_equivalent.length))
		{
			System.out.println("Bot:You shound invest in cash_equivalent");
			System.out.println("Bot:Thank you.");
			System.exit(0);
		}	
		else 
		{
					int a[]={c1,c2,c3};

					int c=0;
					for(int i=0;i<a.length;i++)
					{
						if(a[i]<=2)
						{
							c++;
						}
					}
					if(c==3)
					{
						System.out.println("Bot:Cant predict Investment");
						System.out.println("Bot:Thank you.");
						System.exit(0);

					}

					int max=0,index=0;
					for(int i=0;i<a.length;i++)
					{
						if(a[i]>max)
						{
							max=a[i];
							index=i;
						}
					}
					
					Arrays.sort(a);
					if(a[a.length-1]!=a[a.length-2])
					{
						System.out.println("Bot:You shound invest in "+Investment[(index)]);
						System.out.println("Bot:Thank you.");
					}
					else if(a[a.length-1]==a[a.length-2])
					{
							System.out.println("Bot:Cant predict Investment");
							System.out.println("Bot:Thank you.");
					}		
					}
					sc.close();
		}
}
