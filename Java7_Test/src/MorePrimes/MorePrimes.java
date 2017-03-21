package MorePrimes;
import static java.lang.Math.ceil;
import static java.lang.Math.sqrt;

//≥Ã–Ú“Ï≥£

public class MorePrimes {

	public static void main(String[] args) {
		long[] primes = new long[20];
		primes[0] = 2L;
		primes[1] = 3L;
//		primes[2] = 9090L;
		int count = 2;
		
		long number = 5L;
		
		outer:
		for ( ; count < primes.length; count += 2L) {
			long limit = (long)ceil(sqrt((double)number));
			
			for (int i = 1; i < count && primes[i] <= limit; i++) {
				if(number % primes[i] == 0L)
					continue outer;
			}
		}
		primes[count++] = number;
		
		for(long n: primes){
			System.out.println(n);
		}	
	}
	


}
