package hackerrank.CountingValleys;

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
	 * Complete the 'countingValleys' function below.
	 *
	 * The function is expected to return an INTEGER.
	 * The function accepts following parameters:
	 *  1. INTEGER steps
	 *  2. STRING path
	 */

	public static int countingValleys(int steps, String path)
	{
		// Write your code here
		int number_of_valleys = 0;
		int hill = 0, vally = 0;
		boolean vally_started = false;
		for (char i : path.toCharArray())
		{
			if (i == 'U')
			{
				if (vally == 0)
					hill++;
				else
					vally--;
			}
			else if (i == 'D')
			{
				if (hill == 0)
					vally++;
				else
					hill--;
			}
			if (!vally_started)
			{
				if (vally != 0)
					vally_started = true;
			}
			else if (vally == 0){
				number_of_valleys++;
					vally_started = false;

			}
		}

		return number_of_valleys;

	}
}
