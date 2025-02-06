package Mine.Challenges;

import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		
		
		// int N = sc.nextInt();
		// for(int i=0; i<N; i++){
            ArrayList<ArrayList<Integer>> a = new ArrayList<>();
		    int M = sc.nextInt();
		    for(int j=0; j<M; j++){
		        ArrayList<Integer> b = new ArrayList<>();
		        b.add(sc.nextInt());
		        b.add(sc.nextInt());
		        a.add(b);
		    }

            // Iterator<ArrayList<Integer>> c = a.iterator();
            // Iterator<Integer> n = c.next();

            int max = Integer.MIN_VALUE;

            for(int l=0; l<M; l++){
                for(int x=l+1; x<M; x++){
                    int f = (a.get(l).get(0) * a.get(x).get(1))+(a.get(l).get(1) * a.get(x).get(0));
                    if(f>max){
                        max = f;
                    }
                }
            }
		    System.out.println(max);
		    
		}

	// }
}

