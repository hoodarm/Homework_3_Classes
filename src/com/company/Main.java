package com.company;

import java.util.ArrayList;

public class Main
{
    public static void main(String[] args)
    {
        Method_1(args);
        Method_2(args);
    }

    static void Method_1(String[] args)
    {

        //taking input
        String firstInput = args[0];
        String secondInput = args[1];

        //creating storage for processed output
        ArrayList<Integer> input = new ArrayList<>();
        StringBuilder answer = new StringBuilder();

        //finding processed output
        int firstAppearance = firstInput.indexOf(secondInput);
        if (firstAppearance != -1)
            if (!firstInput.substring(0, firstAppearance).equals(""))
                answer.append(firstInput, 0, firstAppearance).append(" ");

        while (firstAppearance != -1)
        {
            input.add(firstAppearance);

            //using String method indexOf()
            firstAppearance = firstInput.indexOf(secondInput, firstAppearance + secondInput.length());
        }

        //using String method length()
        input.add(firstInput.length());

        for (int i = 0; i < input.size() - 1; i++)
        {
            //using String method substring()
            String element = firstInput.substring(input.get(i) + secondInput.length(), input.get(i + 1));

            if (!element.equals(""))
                answer.append(element).append(" ");
        }

        //deleting the blank space at the end
        if (answer.length() != 0)
            answer.delete(answer.length() - 1, answer.length());

        //printing final answer
        System.out.println(answer);
    }

    static void Method_2(String[] args)
    {
        //Method 2

        String one = args[0];
        String two = args[1];

        //making a mutable StringBuilder
        StringBuilder output = new StringBuilder();

        //adding the string to the StringBuilder
        output.append(one);

        //checking for required subString
        boolean contains = true;
        while (contains)
        {
            if (output.toString().contains(two))
            {
                int position = output.indexOf(two);
                output.delete(position, position + 2);
                output.insert(position, " ");
            }
            else
                contains = false;
        }

        //emptying out the extra white spaces
        for (int a = 0; a < output.length(); a++)
        {
            int n = 1;
            while (n > 0)
            {
                if (output.charAt(a) == ' ' && output.charAt(a + n) == ' ')
                {
                    output.delete(a, a + n);
                }
                else
                    break;
                n++;
            }
        }

        //printing out final output
        String final_answer = output.toString().trim();
        System.out.println(final_answer);
    }
}