import java.lang.Math;
import java.util.HashSet;
public class Task4 {
	public HashSet<String> outcomes = new HashSet<String>();
	public int[] amount = new int[7];

	public Task4() {
		generate("");
		for( String s : outcomes) 
			amount[s.length()-3]++;	
	}

	public void execute()  {
		System.out.printf("Entropy of X: %.3f\n",H_x());
		System.out.printf("Entropy of Y: %.3f\n",H_y());
		System.out.printf("H(X,Y): %.3f\n",H_x_and_y());
		System.out.printf("H(Y|X): %.3f\n",H_y_given_x());
		System.out.printf("H(X|Y): %.3f\n",H_x_given_y());
		System.out.printf("I(X,Y): %.3f\n",I_x_y());
	}


	/*  sum of P(x)* log(P(x))
		as prob of winning of any of A,B,C,D is equal
		prob of getting outcome of length "m" is equal to (1/4)^m
		*/
	public  double H_x () {
		double answ = 0;
		double prob;
		for(int i=0;i<7;i++) {
			// p(x)
			prob = Math.pow(0.25,i+3); 
			answ += prob *amount[i]* Math.log(prob);
		} 
		return -answ / Math.log(2);
	}


	public  double H_y () {
		double answ = 0,prob;
		for(int i=0;i<7;i++) {
			//probability of getting i+3  == (probability of getting outcome of length i+3) * amount of outcomes of length i+3
			prob = Math.pow(0.25,i+3) * amount[i]; 
			answ += prob * Math.log(prob);
		}
		return -answ / Math.log(2);
	}



	/*

		as Y is completly determined by X (as we know X we can get Y)
		therefore entropy of Y|X is 0
	
	*/
	public  double H_y_given_x() {
		return 0; 
	}

	/*

		as H(X|Y) = H(X) - H(Y) + H(Y|X) 
		and  H(Y|X) == 0 
		H(X|Y) = H(X) - H(Y)

		*/
	public  double H_x_given_y () {
		return H_x() - H_y();
	}


	/*
		H(X,Y) = H(X) + H(Y|X)
		as H(Y|X) ==0
		H(X,Y) = H(X)

		*/
	public  double H_x_and_y () {
		return H_x();
	}

	/*
		I(X,Y) = H(X) - H(X|Y) = H(X) - H(X) + H(Y) = H(Y)

	*/
	public  double I_x_y() {
		return H_y();
	}


	//recursive generate all posible combinations
	public  void generate(String s) {
		if(is_good(s)) {
			generate(s+'A');
			generate(s + 'B');
			generate(s + 'C');
			generate(s + 'D');
		}
		else
			outcomes.add(s);
	}


	/*
		check whether given string has 3 'A' , 'B', 'C' or 'D'

	*/
	public  boolean is_good(String s) {
		int a = 0,b = 0,c = 0,d =0;
		for(char ch : s.toCharArray()) {
			if(ch =='A') a++;
			if(ch == 'B') b++;
			if (ch == 'C') c++;
			if(ch =='D') d++;
		}
		if( a == 3 || b == 3 || c==3 || d ==3 ) 
			return false;
		return true;
	}
}