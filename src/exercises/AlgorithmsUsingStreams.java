package exercises;

/*
 * @author Yvonne Davis
 * @version 1
 */
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/*
 * @author Yvonne Davis
 * @version 1
 */
public class AlgorithmsUsingStreams {

	public static long countGoodEggs(List<String> eggs) {
		return eggs.stream() // 1. create stream
				.filter(egg -> egg.equals("whole")) // 2. intermediate filter operation
				.count(); // 3. terminal operation: reduce to an int
	}

	public static Object findTallest(List<Double> peeps) {
//		return Collections.max(peeps);
		return peeps.stream().sorted(Comparator.reverseOrder()).findFirst().get();
	}

	public static long addStringOfNumbers(String numbers) {
		return numbers.chars().mapToObj(c -> Character.toString(c)).mapToInt(num -> Integer.parseInt(num)).sum();
	}

	public static long countPearls(List<Boolean> oysters) {
		return oysters.stream().filter(x -> x == true).count();

	}

	public static String findLongestWord(List<String> words) {
		// replaced Option, orElse with get() method
		// return
		// words.stream().max(Comparator.comparingInt(String::length)).orElse("");
		return words.stream().max(Comparator.comparingInt(String::length)).get();
	}

	public static List<Double> sortScores(List<Double> results) {
		return (results.stream().sorted()).collect(Collectors.toList());
	}

	public static List<String> sortDNA(List<String> unsortedSequences) {
		List<String> sortedSequences = unsortedSequences.stream()
				.sorted((x, y) -> Integer.compare(x.length(), y.length())).collect(Collectors.toList());
		return sortedSequences;
	}

	public static List<String> sortWords(List<String> words) {
		return words.stream().sorted().collect(Collectors.toList());
	}

	public static List<String> getDistinctSpellsInAlphabeticalOrder(List<String> spellsCastThisWeek) {
		return spellsCastThisWeek.stream().distinct().sorted().collect(Collectors.toList());

	}

	public static List<String> getBatPhrases(String[] batmanScript) {
		return Arrays.stream(batmanScript)
				// remove single spaces. New line after each full stop
				.map(s -> s.replace(" ", "")).filter(x -> x.equalsIgnoreCase("bam") || x.equalsIgnoreCase("pow"))
				.map(x -> x.toUpperCase()).collect(Collectors.toList());

		// .forEach(System.out::println);
	}

	public static Integer countXs(String xString) {
		long count = xString.chars().filter(ch -> ch == 'o').count();
		return (int) count;
	}

	public static Integer addEven(String numbers) {
		// Two methods to split the string numbers into integers and sum
		// 1. using a stream, splitting on boundary, and mapping to integer etc
		// return Arrays.stream(numbers.split("\\B")).map(s ->
		// Integer.valueOf(s)).filter(x -> (x % 2 == 0))
		// .mapToInt(x -> x).sum();
		// 2, converting to char object, to stream string to int and filter etc.
		return numbers.chars().mapToObj(c -> Character.toString(c)).mapToInt(num -> Integer.parseInt(num))
				.filter(x -> (x % 2 == 0)).sum();

		// .forEach(System.out::println);

	}

	public static Double getAverage(int[] numbers) {
		return Arrays.stream(numbers).average().getAsDouble();
		// return Arrays.stream(numbers).average().orElse(Double.NaN);
	}

	public static long countOccurrences(String[] strArr, String string) {
		return Arrays.stream(strArr).filter(x -> x == string).count();

	}

}
