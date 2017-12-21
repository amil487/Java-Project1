/*
Name: Amil Patel
Class section: 5994
Instructor: Kyla McMullen
Due date: September 20, 2016
Brief Description: A capture calculator for Brokemon Go
*/
import java.util.Scanner;		//Imports
import java.lang.Math;
import java.lang.String;

public class CaptureCalculator 			//Class beginning
{
	public static void main(String[] args)		//Main
	{
		String playerLuck;				//String Declarations
		String probability = "";		
		
		System.out.println("Hello and welcome to the Monster Capture Possibility Calculator.");		//Welcome output
		
		Scanner input = new Scanner(System.in);		//Scanner creation
		
		System.out.println("Please enter the latitude of the monster (1-10):");				//Beginning of user questions and inputs
		
		int monsterLatitude = input.nextInt();
		
		System.out.println("Please enter the longitude of the monster (1-10):");
		
		int monsterLongitude = input.nextInt();
		
		System.out.println("Please enter the time of the monster appear (1-1440):");
		
		int monsterAppear = input.nextInt();
		
		System.out.println("Please enter the possible time of the monster will exist (10-59):");
		
		int monsterExist = input.nextInt();
		
		System.out.println("Please enter the player's ID (8 digits):");
		
		int playerID = input.nextInt();
		
		System.out.println("Please enter the time of the player noticing monster (1-1440 and greater than the time the monster appears):");
		
		int playerNotice = input.nextInt();
		
		System.out.println("Please enter the latitude of the player (1-10):");
		
		int playerLatitude = input.nextInt();
		
		System.out.println("Please enter the longitude of the player (1-10):");
		
		int playerLongitude = input.nextInt();
		
		System.out.println("Please enter the player's walking speed (10-200):");
		
		int playerSpeed = input.nextInt();												//End of user questions and inputs
		
		int luck = (playerID %100);		//Calculate player luck
		
		double distance = (Math.sqrt((monsterLongitude - playerLongitude)*(monsterLongitude - playerLongitude)+(monsterLatitude-playerLatitude)*(monsterLatitude-playerLatitude))*1000);		//Player and monster distance calculation
		
		double arrivalTime = (playerNotice + (distance/playerSpeed));		//Player's arrival time calculation
		
		double roundedDistance = Math.round(distance*10)/10.0;				//Variable for distance displayed
		double roundedArrivalTime = Math.round(arrivalTime*10)/10.0;		//Variable for arrival time displayed
		
		int disappearTime = (monsterAppear + monsterExist);			//Disappear 
		
		double proportion = ((arrivalTime - (monsterAppear + monsterExist))/monsterExist)*100;		//Proportion calculation
		
		if (luck <= 49)		//List calculation
		
			 playerLuck = "lucky list";
		else 
			 playerLuck = "normal list";
		
		if (arrivalTime <= (monsterAppear + monsterExist))		//Definite probability calculation
			probability = "definitely";
		
		if ((arrivalTime > (monsterAppear + monsterExist)) && (luck <= 49) && (proportion <= 10.0))		//Highly likely probability calculation on lucky list
			probability = "highly likely";
		
		if ((arrivalTime > (monsterAppear + monsterExist)) && (luck > 49) && (proportion <= 5.0))		//Highly likely probability calculation on normal list
			probability = "highly likely";

		if ((arrivalTime > (monsterAppear + monsterExist)) && (luck <= 49) && (proportion > 10.0 && proportion <= 30.0))		//Likely probability calculation on lucky list
			probability = "likely";
		
		if ((arrivalTime > (monsterAppear + monsterExist)) && (luck > 49) && (proportion > 5.0 && proportion <= 20.0))			//Likely probability calculation on normal list
			probability = "likely";
		
		if ((arrivalTime > (monsterAppear + monsterExist)) && (luck <= 49) && (proportion > 30.0 && proportion <= 40.0))		//Unsure probability calculation on lucky list
			probability = "unsure";
		
		if ((arrivalTime > (monsterAppear + monsterExist)) && (luck > 49) && (proportion > 20.0 && proportion <= 35.0))			//Unsure probability calculation on normal list
			probability = "unsure";
		
		if ((arrivalTime > (monsterAppear + monsterExist)) && (luck <= 49) && (proportion > 40.0 && proportion <= 50.0))		//Unlikely probability calculation on lucky list
			probability = "unlikely";
		
		if ((arrivalTime > (monsterAppear + monsterExist)) && (luck > 49) && (proportion > 35.0 && proportion <= 40.0))			//Unlikely probability calculation on normal list
			probability = "unlikely";
		
		if ((arrivalTime > (monsterAppear + monsterExist)) && (luck <= 49) && (proportion > 50.0))								//Highly unlikely probability calculation on lucky list
			probability = "highly unlikely";
		
		if ((arrivalTime > (monsterAppear + monsterExist)) && (luck > 49) && (proportion > 40.0))								//Highly unlikely probability calculation on lucky list
			probability = "highly unlikely";
		
		
		System.out.println("Player " + playerID + " who is on the " + playerLuck + ","  );					//Output display 
		System.out.println("noticed the monster at time " + playerNotice + ",");
		System.out.println("is " + roundedDistance + " m away from the monster,");
		System.out.println("and will arrive at time " + roundedArrivalTime + "."  );
		System.out.println("The monster's disappear time is about " + disappearTime + "." );
		System.out.println("So the player will capture this monster with " + probability + " possibility.");
		
	
	}
	
	
	 
}
