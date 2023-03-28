import java.util.Scanner;

import javax.print.DocFlavor.STRING;

public class colors {

    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);// Scanner object
        System.out.println("Enter the size of the list: ");
        int size = Integer.parseInt(userInput.nextLine());// read thesize of the list convert the string to int value
        String names[] = new String[size];// String array to store the names
        String colors[] = new String[size]; // String array to store the colors
        System.out.println("Enter the names");
        for (int i = 0; i < size; i++) {
            names[i] = userInput.nextLine(); // read all the names and store in array

        }

        System.out.println("Enter the colors: "); // read all the colors and store in array
        for (int i = 0; i < size; i++) {
            colors[i] = userInput.nextLine();

        }
        userInput.close();// close scanner

        String color;
        int randomIndexColor;

        // Shuffling the colors
        for (int i = 0; i < size; i++) { // for each color

            randomIndexColor = (int) (Math.random() * 100) % size; // get a random index

            // Swopping the colors at ith and random index

            color = colors[i];
            colors[i] = colors[randomIndexColor];
            colors[randomIndexColor] = color;
        }

        // Printing the name + color pairs

        for (int i = 0; i < size; i++) {

            System.out.println(names[i] + "\t" + colors[i]);

        }

    }

}
