// Author: Rahul Bulsara
// Date of Last Modification: 10/12/2020
// Course: CS111B
// Instructor: Constance Conner 
// Assignment #4
// File Name: ConnerBoxes.java
// This program will create a series of black and white boxes with a random red box, to form an illusion

// Algorithm:
// 1. Create and Initialize all size and position variables for our boxes
// 2. Outer for loop creates 14 boxes going down in Black White order
// 3. Inner for loop creates 14 boxes going across in Black White order
// 4. Adjust every other row across to start from the width/2 units 
// 5. Add ONE random RED box
// --------------------------
// *the user can adjust the variables at the beginning to change the size, location of the boxes, and gap distance

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import java.util.Random;




// Class to create the assortment of black and white boxes
public class ConnerBoxes extends Application
{
   private static final int GAP_SIZE = 2;

   public void start(Stage primaryStage)
   {
         
      Group root = new Group();
      Random gen = new Random();
        
    // initialize all variables for rectangle (coordinates, and size)       
      int x = 0;
      int y = 10;
      int width = 50;
      int height = 30;
      
    // Generate 2 random numbers
      int randOne = gen.nextInt(13)+1;
      int randTwo = gen.nextInt(13)+1;
     
    // Integer (constant) that control the gap distance between the blocks
       //final int GAP_SIZE = 2;
      
          
   // Initialize for loop to get 14 (7 pairs) blocks down 
      for(int i = 0; i < 14; i++)
      {
      // Initialize for loop to get 14 (7 pairs) blocks across
         for(int row = 0; row < 14; row++)
         {
         
            //checks if the row number is even or odd to determine whether to create a black or white box
            if(row % 2 == 0)
            {
               Rectangle boxOne = new Rectangle(x, y, width, height);
               boxOne.setFill(Color.BLACK);
            
               root.getChildren().add(boxOne);
            }
            else
            {
               Rectangle boxTwo = new Rectangle(x, y, width, height);
               boxTwo.setFill(Color.WHITE);
               
               root.getChildren().add(boxTwo);
            }
            
          // Checks if the random numbers match the current for loop numbers and CREATES A RED BOX
            if(randOne == i && randTwo == row)
            {
               
               Rectangle randRedBox = new Rectangle(x, y, width, height);
               randRedBox.setFill(Color.RED);
               
               root.getChildren().add(randRedBox);
            }
            
        
          //increases X position
            x = x + width + GAP_SIZE;
         }
       // resets the x position of the box (depending on which line its on), and moves the y pos down by 42 units
         y = y + height + GAP_SIZE;
         if(i % 2 == 0)
         {
            x = width / 2;
         }
         else
         {
            x = 0;
         }
      }
               
        
      Scene scene = new Scene(root, 1000, 700, Color.GRAY);
        
      primaryStage.setTitle("Rahul's Funky Box Illusion");
      primaryStage.setScene(scene);
      primaryStage.show();
   }
    
   public static void main(String[] args)
   {
      launch(args);
   }
}
