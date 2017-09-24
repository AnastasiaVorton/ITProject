import java.lang.Math;
import java.util.HashSet;
public class Task4 {
	public static HashSet<String> outcomes = new HashSet<String>();
	public static int[] amount = new int[7];

	public static int all_outcomes;

	public static void main(String[] args)  {
		generate("");
		all_outcomes = outcomes.size();
		for( String s : outcomes) 
			amount[s.length()-3]++;
		System.out.printf("Entropy of X: %.3f\n",H_x());
		System.out.printf("Entropy of Y: %.3f\n",H_y());
		System.out.printf("H(X,Y): %.3f\n",H_x_and_y());
		System.out.printf("H(Y|X): %.3f\n",H_y_given_x());
		System.out.printf("H(X|Y): %.3f\n",H_x_given_y());
		System.out.printf("Mutual Info of X and Y: %.3f\n",I_x_y());	

	}
	public static double H_x () {
		double answ = 0;
		double prob;
		for(int i=0;i<7;i++) {
			prob = Math.pow(0.25,i+3);
			answ += prob *amount[i]* Math.log(prob);
		} 
		return -answ / Math.log(2);
	}

	public static double H_y () {
		double answ = 0,prob;
		for(int i=0;i<7;i++) {
			prob = Math.pow(0.25,i+3) * amount[i];
			answ += prob * Math.log(prob);
		}
		return -answ / Math.log(2);
	}

	public static double H_y_given_x() {
		return 0; 
	}
	public static double H_x_given_y () {
		return H_x() - H_y();
	}
	public static double H_x_and_y () {
		return H_x();
	}
	public static double I_x_y() {
		return H_y();
	}
	public static int fact(int i) {
		if(i<=1) 
			return 1;
		return i*fact(i-1);
	}
	public static void generate(String s) {
		if(is_good(s)) {
			generate(s+'A');
			generate(s + 'B');
			generate(s + 'C');
			generate(s + 'D');
		}
		else
			outcomes.add(s);

	}
	public static boolean is_good(String s) {
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