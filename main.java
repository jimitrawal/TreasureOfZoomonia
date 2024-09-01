
import java.util.Scanner;//import scanner
import java.io.*;//import file 

class Main {// main class
  public static void main(String[] args) {// main public void string
    char direction;// declare direction as character value
    char confirm;// declare confirm as charcater value
    int x = 2;// declare x equal to 2, as integer value, and initialize them as starting
              // position
    int y = 3;// declare y equal to 3, as integer value, and initialize them as starting
              // position
    int jewelPickup = 0;// declare jewelPickup equal to 0, as integer value, used for jewel pick up
    int weaponPickup = 0;// declare weaponPickup equal to 0, as integer value, used for weapon pick up
    Scanner scan = new Scanner(System.in);// declare scanner for usage
    String[][] map = new String[10][10];// declare an array of 10x10 as string value
    for (int i = 0; i <= 9; i++) {// for loop running from integer value i equal to 0 to i equal to 9
      for (int j = 0; j <= 9; j++) {
        // for loop running from integer j equal to 0 to j equal to 9, forming a nested
        // loop
        map[i][j] = "You are in a vast ocean.";// default message for empty array coordinates
      } // second loop
    } // first loop
    try {// try this command inside the brackets
      Scanner fh = new Scanner(new File("datafile"));// declare file for usage as new file named datafile
      while (fh.hasNext()) {// while datafile is confirmed and open
        String line = fh.nextLine();// declare line as string as datafile
        String[] fileC = line.split(",");// declare fileC as string value, seprating with commas
        int a = Integer.parseInt(fileC[0].trim());// declare a as integer value, converting string to integer
        int b = Integer.parseInt(fileC[1].trim());// declare b as integer value, converting string to integer
        map[a][b] = fileC[2];// let 10x10 array map equal string fileC
      } // while loop
      fh.close();// close the file (datafile)
    } // try statement
    catch (FileNotFoundException e) {// catch the error if there is one
      System.out.println(e);// if there is error, print e and continue the program
    } // catch statement
    do {// do loop
      System.out.print(
          "\nWhich direction do you want proceed to? \n-N for North\n-S for South\n-E for East\n-W for West\n-Q for Quit \n-P for Pick-up\n-D for Drop-off\n-F for Fighting\n:");
      // enter, ask for direction, enter, state all the options and enter after each
      // line, asking for user input
      direction = scan.next().charAt(0);// let char value direction equal user input
      if (direction == ('N')) {// if string value diretion is equal to character N, proceed
        y = y + 1;// let integer value y equal to y plus 1
      } // if statement
      if (direction == ('S')) {// if char value diretion is equal to character S, proceed
        y = y - 1;// let integer value y equal to y minus 1
      } // if statement
      if (direction == ('E')) {// if char value diretion is equal to character E, proceed
        x = x + 1;// let integer value x equal to x plus 1
      } // if statement
      if (direction == ('W')) {// if char value diretion is equal to character W, proceed
        x = x - 1;// let integer value x equal to x minus 1
      } // if statement
      if (direction == ('P')) {// if char value diretion is equal to character P, proceed
        if ((x == 5) && (y == 7)) {// if x is equal to 5 and y is equal to 7, proceed
          jewelPickup++;// let integer value jewelPickup equal jewelPickup plus 1
        } // if statement
        System.out.printf("You have %s precious jewels!\n", jewelPickup);// print the number of jewels from integer
                                                                         // jewelPickup
        if ((x == 5) && (y == 5)) {// if x is equal to 5 and y is equal to 5, proceed
          weaponPickup++;// then let integer vaue weaponPickup equal weaponPickup plus 1
        } // if statement
        System.out.printf("You have %s weapons!\n", weaponPickup);//// print the number of weapons from integer value
                                                                  //// weaponPickup
      } // if statement
      if (direction == ('D')) {// if char value diretion is equal to character D
        if (jewelPickup > 0) {// if integer value jewelPickup is greater than 0, then proceed
          jewelPickup--;// let integer value jewelPickup equal jewelPickup minus 1
        } // if statement
        else {// if jewelPickup is not greater than 0, proceed
          System.out.print("Drop what, you cannot drop weapons?\n");
          // print "Drop what,you cannpt drop weapons" and enter
        } // else statement
        System.out.printf("You have %s precious jewels!\n", jewelPickup);
        // print the number of jewels from the integer value jewelPickup
        System.out.printf("You have %s weapons!\n", weaponPickup);// print the number of weapons from the integer value
                                                                  // weaponPickup
      } // if direction is equal to character D
      if (direction == ('F')) {// if char value direction is equal to character F, proceed
        if ((x == 8) && (y == 4) && (weaponPickup >= 1)) {
          // if integer value x is equal to 8, integer value y is equal to 4, and integer
          // value weaponPickup is
          // greater than or equal to 1, proceed
          System.out.print("Do you want to use the weapon?(y for yes):\n");
          // print "Do you want to use the weapon?(y for yes)", and expect user input
          confirm = scan.next().charAt(0);// let char value confirm equal to user input
          if (confirm == ('y')) {// if char value confirm equals character y, proceed
            System.out.print("You killed a zombie!");
            // print that the the player has killed a zombie
          } // if statement
        } // if statement
        else if ((x == 8) && (y == 4)) {
          // if weaponPickup not greater than or equal to 1, but integer value x equal to
          // 8 and integer value y
          // equal to 4, proceed
          System.out.print("You do not have a weapon to use.");
          // print "You do not have a weapon to use."
        } // else if statement
        else {// if both the statements not true, proceed
          System.out.print("You cannot fight.");// print "You cannot fight."
        } // else statement
      } // if direction == ('F')
      System.out.printf(map[x][y]);
      // print the current coordinates of the 10x10 array with its coordinates
      // descriptions from the array and from default
      // description
    } // do loop
    while (!(direction == ('Q')));
    // continue the above do loop till the string value direction is not equal to
    // character value Q
    if ((direction == ('Q'))) {// if the string value direction is equal to character value Q, proceed
      System.out.print("Thank you for playing the game!");// print "Thank you for the playing the game!"
    } // if statement
  }// main public void
}// main class
 // End of the program
