package is.ru.stringcalculator;

public class Calculator {
	public static int add(String text){
		if(text.equals("")){
			return 0;
		}
		else if(text.contains(",") || text.contains("\n") || text.startsWith("//")){
			return sum(splitNumbers(text));
		}
		else
			return toInt(text);
	}

	private static int toInt(String number){
		return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String numbers){
        if (numbers.startsWith("//"))
        {
            int indexN = numbers.indexOf('\n');
            String delimiter = numbers.substring(2, indexN);
            numbers  = numbers.substring(indexN + 1, numbers.length());

            return numbers.split(delimiter);
        }
	    return numbers.split("[,\n]");
	}
      
    private static int sum(String[] numbers) {
        String negatives = "";
 	    int total = 0;
        for(String number : numbers){
            if (toInt(number) < 0) negatives = negatives.concat(number + ",");
            if (toInt(number) <= 1000) total += toInt(number);
		}
        if (negatives != "") {
            throw new RuntimeException("Negatives not allowed: " + negatives.substring(0,negatives.length()-1));
        }
		return total;
    }


}
