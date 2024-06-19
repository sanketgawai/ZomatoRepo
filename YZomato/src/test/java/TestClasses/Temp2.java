package TestClasses;

public class Temp2 {
	
	public static void main(String[] args) {
			
		int no = 153;
		int temp = no;
		int rem = 0;
		int sum =0;
		
		while(temp>0)
		{
			rem = temp%10;
			temp = temp/10;
			sum = sum+rem*rem*rem;
		}
		if(sum==no)
		{
			System.out.println("Amstrong");
		}
		else
		{
			System.out.println("not Amstrong");
		}
	}
}
