public class Ex1a{
    public static void main(String[] args){
        int a = 1;
	while(a < 6){
	    int b = a;
	    while(b > 0){
		System.out.print('*');
		b--;
	    }
	    System.out.println();
	    a++;
	}
    }
}
