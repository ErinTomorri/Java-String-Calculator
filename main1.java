// Erin Tomorri
// Calculator program
// ISC3U
// Ella Katsman
 
import java.lang.Math;
import java.util.Scanner;
 
public class main1 {
 
    // this is the main method that runs the program
    public static void main(String[] args) {
 
 
        // set game to 1 so the loop will run
 
 
 
        int game = 1;
        // this is the main game loop
        String equation;
        while (game == 1) {
            // create a new scanner object
            Scanner scan = new Scanner(System.in);
            equation = "";
            // prompt the user for input
            // read in the user input as a string
            System.out.println("Input your equation (+,-,*,/,^,%): ");
            equation = scan.nextLine();
 
            // initialize the index variables
            String op_index = "";
            String num_index = "";
            for (int x = 0; x!=equation.length();x++){
                if (equation.indexOf("+")<0 && equation.indexOf("-")<0 && equation.indexOf("*")<0 && equation.indexOf("/")<0 && equation.indexOf("^")<0 && equation.indexOf("%")<0 ) {
                    System.out.println("YOU FORGOT THE OPERATIONS");
                    System.out.println("YOU BROKE ME");
                }
            }

   
            // this loop checks for invalid input/ if a eqautoin sign is in the middle randomly
            for (int gg = 0; gg != equation.length(); gg++ ){
                while (equation.charAt(gg) == '=' && gg != equation.length()-1){
                    System.out.println("--------------------------");
                    System.out.println("Error: equation sign found in middle of equation");
                    System.out.println("Feedback: dont have an equation sign in the middle");
                    System.out.println("Input your new equation: ");
                    equation = scan.nextLine();  
                }
            }        
            // checks if no equation sign is at the end
            while (equation.charAt(equation.length()-1) != '='){
                System.out.println("--------------------------");
                System.out.println("Error: no equation sign found at the end");
                System.out.println("Feedback: add an equation sign at the end");
                System.out.println("Input your new equation: ");
                equation = scan.nextLine();  
            }
            // checks for two operators
                while (equation.indexOf("+-") != -1 || equation.indexOf("++")!= -1
                    || equation.indexOf("+/")!= -1 || equation.indexOf("+*")!= -1
                    || equation.indexOf("+^")!= -1 || equation.indexOf("+%")!= -1
                    || equation.indexOf("--")!= -1 || equation.indexOf("-+")!= -1
                    || equation.indexOf("-/")!= -1 || equation.indexOf("-*")!= -1
                    || equation.indexOf("-^")!= -1 || equation.indexOf("-%")!= -1
                    || equation.indexOf("/-")!= -1 || equation.indexOf("/+")!= -1
                    || equation.indexOf("/*")!= -1 || equation.indexOf("//")!= -1
                    || equation.indexOf("/^")!= -1 || equation.indexOf("/*")!= -1
                    || equation.indexOf("*-")!= -1 || equation.indexOf("*+")!= -1
                    || equation.indexOf("*/")!= -1 || equation.indexOf("**")!= -1
                    || equation.indexOf("*%")!= -1 || equation.indexOf("^-")!= -1
                    || equation.indexOf("^+")!= -1 || equation.indexOf("^/")!= -1
                    || equation.indexOf("^*")!= -1 || equation.indexOf("^%")!= -1
                    || equation.indexOf("%-")!= -1 || equation.indexOf("%+")!= -1
                    || equation.indexOf("%*")!= -1 || equation.indexOf("%/")!= -1
                    || equation.indexOf("%^")!= -1 || equation.indexOf("%%")!= -1) {
                  System.out.println("--------------------------");
                  System.out.println("Error: There are two operators next to each other");
                  System.out.println("Feedback: delete one or add a number inbetween");
                  System.out.println("Input your new equation: ");
                  equation = scan.nextLine();
                }
               
            int c =0;
            while (c != equation.length()){// checks if you are dividing by zero
                if ((int)equation.charAt(c)== 48 && equation.charAt(c-1) == '/'){
                    System.out.println("--------------------------");
                    System.out.println("Error: you cant divide by zero");
                    System.out.println("Feedback: dont divide by zero");
                    System.out.println("Input your new equation: ");
                    equation = scan.nextLine();
                }
                c+=1;
            }
            // save the original equation
            String original = equation;
            // this loop goes through the equation and evaluates it
            for (int u = 0; u!=equation.length() && op_index.length()!=2; u++) {
 
                // remove whitespace from equation
                equation.trim();
                equation.replace(" ", "");
                
 
                // reset the index variables
                op_index = "";
                num_index = "";
 
                // this loop finds the index of the operators
                for(int x = 0; x != equation.length(); x++) {
 
                    // if the character is an operator, add its index to op_index
                    if ((int)equation.charAt(x) == 42 || (int)equation.charAt(x)== 43 || (int)equation.charAt(x) == 37 || (int)equation.charAt(x) == 47 || (int)equation.charAt(x) == 45 || (int)equation.charAt(x) == 94 || (int)equation.charAt(x) == 61) {
                        op_index += x;
                    }
                }
 
                // this loop finds the index of the numbers
                for (int y = 0; y!=equation.length(); y++) {
 
                    // if the character is a number, add its index to num_index
                    if ((int)equation.charAt(y) >= 48 && (int)equation.charAt(y) <= 57) {
                        num_index += y;
                    }
                }
                int op_index_int_2 = 0;
                int num_index_int_2 = 0;

                // changes the number index and op index to intergers
                for (int z = 0; z < num_index.length(); z++) {
                    num_index_int_2=  num_index_int_2 * 10 + (num_index.charAt(z) - (int)'0');
                }
                for (int z = 0; z < op_index.length(); z++) {
                    op_index_int_2=  op_index_int_2 * 10 + (op_index.charAt(z) - (int)'0');
                }
                // convert the index strings to ints
                int op_index_int = 1;
                int num_index_int = 1;
                 // calculate the length of the equation  
                for (int l = 0; l!=num_index.length()-1;l++){
                    num_index_int = num_index_int*10;
                }
                for (int i = 0; i!=op_index.length()-1;i++){
                    op_index_int = op_index_int*10;
                    
                }
                int counter = equation.length();
                // this loop evaluates the equation
                    
                // get the first number
                int one_num = (num_index_int_2/num_index_int) % 10;

                    // get the index of the first operator
                    int op_num = (op_index_int_2/op_index_int) % 10;
 
                    // remove the first number and operator from the index ints
                    op_index_int /= 10;
                    num_index_int /= 10;
  
                    // get the index of the second operator
                    int op_two = (op_index_int_2/op_index_int) % 10;
                    
                    // remove the second number and operator from the index ints
                    op_index_int /= 10;
                    num_index_int /= 10;
                    counter -= 1;
                    
                    // get the first number from the equation string
                    String first_num_set = equation.substring(one_num,op_num);
                    // get the operator from the equation string
                    String operation_set = equation.substring(op_num,op_num+1);
 
                    // get the second number from the equation string
                    while (op_two<op_num+1){
                        op_two =(op_index_int_2/op_index_int) % 10;
                        op_index_int /= 10;

                    }
                    // get the numbers from after the operation to the next operation 
                    String second_num_set = equation.substring(op_num+1,op_two);
                    
                    // initialize the value variable
                    int value = 0;//change to double for 2/3 to work
 
                    // convert the first number string to an int
                    int first_num = 0;//change to double for 2/3 to work
                    for (int z = 0; z < first_num_set.length(); z++) {
                        first_num= first_num * 10 + (first_num_set.charAt(z) - (int)'0');
                    }
 
                    // convert the second number string to an int
                    int second_num = 0;//change to double for 2/3 to work
                    for (int aa = 0; aa < second_num_set.length(); aa++) {
                        second_num = second_num * 10 + (second_num_set.charAt(aa) - (int)'0');
                    }
 
                    // perform the operations of the first num to second num

                    if (operation_set.equals("+")) {
                        value = first_num + second_num;
                        equation = value+equation.substring(op_two);// changes the equation
                    } else if (operation_set.equals("-")) {
                        value = first_num - second_num;
                        equation = value+equation.substring(op_two);
                    } else if (operation_set.equals("*")) {
                        value = first_num * second_num;
                        equation = value+equation.substring(op_two);
                    } else if (operation_set.equals("/")) {
                        value = first_num / second_num;
                        equation = value+equation.substring(op_two);
                    } else if (operation_set.equals("^")) {
                        value =  (int) Math.pow(first_num,second_num);//change to double for 2/3 to work
                        equation = value+equation.substring(op_two);
                    } else if (operation_set.equals("%")) {
                        value = first_num % second_num;
                        equation = value+equation.substring(op_two);
                    }

                
            }
            // print the equation            
            System.out.println("Do you want to guess what the answer is (y/n): ");
            String guess = scan.nextLine();
            guess = guess.toLowerCase();
            // asks the user if they want to play a small game
            // checks if guess is not y or n
            while (guess.equals("y") == false && guess.equals("n")== false){
                System.out.println("--------------------------");
                System.out.println("Do you want to guess what the answer is (y/n): ");
                guess = scan.nextLine();
            }
            // checks if guess is y and asks the user for their guess
            if (guess.equals("y")){
                System.out.println("Guess what the answer is: ");
                int guess_sec = scan.nextInt();
                System.out.println("You guessed:"+ guess_sec);
                String guess_string ="";
                guess_string= guess_string + guess_sec;
                if (guess_string.equals(equation.substring(0,equation.length()-1))){
                    System.out.println("You got it right!!! ");
                }
            }
            // print out the final answer
            System.out.println(original+equation.substring(0,equation.length()-1));
            System.out.println("--------------------------");
            // ask if they want to play again
            System.out.println("Would you like to play again (1=yes,0=no): ");
            game = scan.nextInt();
            // check if the user wants to leave and if they arent using 1 or 0
            while (game != 1 && game!=0){
                System.out.println("--------------------------");
                System.out.println("Error: not one or zero");
                System.out.println("Would you like to play again (1=yes,0=no): ");
                game = scan.nextInt();  }
                equation = ""; 
            // ask for new equation
            if (game == 1){
                equation = scan.nextLine();

            }
        }
        //leave
        System.out.println("bye");
    }
}
