package hackerrank.SalesbyMatch;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result
{

	/*
	 * Complete the 'sockMerchant' function below.
	 *
	 * The function is expected to return an INTEGER.
	 * The function accepts following parameters:
	 *  1. INTEGER n
	 *  2. INTEGER_ARRAY ar
	 */

	public static int sockMerchant(int n, List<Integer> ar)
	{
		int final_number_of_pairs = 0;
		// Write your code here
		Set<Integer> tracker = new HashSet<>();
		for (Integer each : ar)
		{
			if (tracker.contains(each))
			{
				tracker.remove(each);
				final_number_of_pairs++;
			}else {
				tracker.add(each);
			}
		}
		return final_number_of_pairs;
	}

}

