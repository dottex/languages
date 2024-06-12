import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PureFunctions{
	// Impure function: Modifies external state
	int counter = 0;

	int incrementCounter() {
	    return ++counter; // Side effect: Modifies counter
	}

	// Pure function: No side effects
	int add(int x, int y) {
	    return x + y;
	}


	// Pure function: No side effects
	static int addStatic(int x, int y) {
	    return x + y;
	}


	// Higher-order function: Takes a function as an argument
	static List<Integer> doubleNumbers(List<Integer> numbers, Function<Integer, Integer> doubler) {
	    return numbers.stream().map(doubler).collect(Collectors.toList());
	}

	public static void main(String args[]){
		System.out.println("Addition of 2 and 3 is: " + new PureFunctions().add(2, 3));
		System.out.println("Addition of 2 and 3 is: " + addStatic(2, 3));
		
		// Mutable list
		List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3));
		numbers.add(4); // Modifies the list

		// Immutable list (using Java 9+ List.copyOf)
		List<Integer> immutableNumbers = List.copyOf(numbers);
		//ImmutableNumbers.add(5); // UnsupportedOperationException ->  It's true!!!
		

		// Usage of the higher-order function
		List<Integer> doubled = doubleNumbers(numbers, x -> x * 2);
	}
}
