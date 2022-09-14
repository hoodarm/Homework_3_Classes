package com.company;

import java.util.ArrayList;

public class Main
{
    public static void main(String[] args)
    {
        //taking input
        String firstInput = args[0];
        String secondInput = args[1];

        //creating storage for processed output
        ArrayList<Integer> input = new ArrayList<>();
        StringBuilder answer = new StringBuilder();

        //finding processed output
        int firstAppearance = firstInput.indexOf(secondInput);
        if (firstAppearance!=-1)
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
}