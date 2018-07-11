package com.iblesa.javajokes;

import java.util.Random;

public class Joker {
    private String[] jokes = new String[]

            {
                    "Can a kangaroo jump higher than a house? \n" +
                            "Of course, a house doesn’t jump at all.",

                    "Doctor: \"I'm sorry but you suffer from a terminal illness and have only 10 to live.\"\n" +
                            "Patient: \"What do you mean, 10? 10 what? Months? Weeks?!\"\n" +
                            "Doctor: \"Nine.\"",

                    " Anton, do you think I’m a bad mother?\n" +
                            "My name is Paul.",

                    "My dog used to chase people on a bike a lot. It got so bad, finally I had to take his bike away.",

                    "What is the difference between a snowman and a snowwoman?\n" +
                            "-\n" +
                            "Snowballs."

            };
    private Random random;

    public Joker() {
        random = new Random();
    }

    public String getJoke() {
        int nextJoke = random.nextInt(jokes.length);
        return jokes[nextJoke];
    }
}
