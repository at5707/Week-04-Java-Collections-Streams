import java.util.function.BiFunction;
public class BiFunctionExample {
	public static void main(String[] args) {
		BiFunction<String,String,String> concat=(str1,str2)->str1+" "+str2;
		String result=concat.apply("Hello", "World");
		System.out.println("Concatenated String: "+result);
	}
}