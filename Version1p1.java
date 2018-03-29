import java.util.Scanner;

public class Version1p1 {

	int gridSizeX = 0;
	int gridSizeY = 0;
	
	int locOneX = 0;
	int locOneY = 0;
	int locTwoX = 0;
	int locTwoY = 0;
	
	int distanceOne = 0;
	int distanceTwo = 0;
	String closestExchange;
	
	String idOne;
	String idTwo;
	int tempIDOne;
	int tempIDTwo;
	
	int tempNum1 = 0;
	int tempNum2 = 0;
	
	int maxX = 100000;
	int maxY = 100000;
	
	public static void main(String[] args) {
		Version1p1 nearestExchange = new Version1p1();
		nearestExchange.setGridSizeX();
		nearestExchange.setGridSizeY();
		
		nearestExchange.setLocOneX();
		nearestExchange.setLocOneY();
		nearestExchange.setLocTwoX();
		nearestExchange.setLocTwoY();
		
		nearestExchange.setidOne();
		nearestExchange.setidTwo();
		nearestExchange.findNearest();
	}
	
	public void setGridSizeX() {
	  Scanner gridInput = new Scanner(System.in);
	  System.out.println("To set the size of the X axis, please enter a positive integer no bigger than " + maxX + "."  + "\n");  
	  try {
		  gridSizeX = Integer.parseInt(gridInput.nextLine());
		  if (gridSizeX > maxX || gridSizeX < 0) {
			  setGridSizeX();
		  }
		  else {	  
			  System.out.println("The grid size for the X axis is " + gridSizeX  + "\n");
		  }
	  }
	  catch (Exception ex) {
		  setGridSizeX();
	  }
	}
	
	public void setGridSizeY() {
		  Scanner gridInput = new Scanner(System.in);
		  System.out.println("To set the size of the Y axis, please enter a positive integer no bigger than " + maxY + "." + "\n");  
		  try {
			  gridSizeY = Integer.parseInt(gridInput.nextLine());
			  if (gridSizeY > maxY || gridSizeY < 0) {
				  setGridSizeY();
			  }
			  else {	  
				  System.out.println("The grid size for the Y axis is " + gridSizeY + "\n");
			  }
		  }
		  catch (Exception ex) {
			  setGridSizeY();
		  }
	}
	
	public void setidOne() {
		Scanner idInput = new Scanner(System.in);
		System.out.println("Set Exchange 1's ID, Must be Unique. Please enter a postitive integer no bigger than 99." + "\n");  
		
		try {
			  tempIDOne = Integer.parseInt(idInput.nextLine());
			  if (tempIDOne > 99 || tempIDOne < 1) {
				  setidOne();
			  }
			  else {	  
				  System.out.println("Exchange 1's id is " + tempIDOne + "." + "\n");
				  tempNum2 = tempIDOne % 10;
				  tempNum1 = (tempIDOne - tempNum2)/10;
				  idOne = "ex:" + Integer.toString(tempNum1) + ":" + Integer.toString(tempNum2);
				  System.out.println("ID of exchange 1 is " + idOne + "." + "\n");
			  }
		  }
		  catch (Exception ex) {
			  setidOne();
		  }
		
	}
	
	public void setidTwo() {
		Scanner idInput = new Scanner(System.in);
		System.out.println("Set Exchange 2's ID, Must be Unique. Please enter a postitive integer no bigger than 99." + "\n");  
		
		try {
			  tempIDTwo = Integer.parseInt(idInput.nextLine());
			  if (tempIDOne == tempIDTwo || tempIDTwo > 99 || tempIDTwo < 1) {
				  setidTwo();
			  }
			  else {	  
				  System.out.println("Exchange 2's id is " + tempIDTwo + "." + "\n");
				  tempNum2 = tempIDTwo % 10;
				  tempNum1 = (tempIDTwo - tempNum2)/10;
				  idTwo = "ex:" + Integer.toString(tempNum1) + ":" + Integer.toString(tempNum2);
				  System.out.println("ID of exchange 2 is " + idTwo + "." + "\n");
			  }
		  }
		  catch (Exception ex) {
			  setidTwo();
		  }
		
	}
	
	public void setLocOneX() {
		Scanner locInput = new Scanner(System.in);
		System.out.println("To set the x location of the first exchange, please enter a positive integer no bigger than " + gridSizeX + ".");  
		 try {
			  locOneX = Integer.parseInt(locInput.nextLine());
			  if (locOneX > gridSizeX || locOneX < 0) {
				  setLocOneX();
			  }
			  else {	  
				  System.out.println("The x location of the first exchange is " + locOneX + ".");
			  }
		  }
		  catch (Exception ex) {
			  setLocOneX();
		  }
	}

	public void setLocOneY() {
		Scanner locInput = new Scanner(System.in);
		System.out.println("To set the y location of the first exchange, please enter a positive integer no bigger than " + gridSizeY + ".");  
		 try {
			  locOneY = Integer.parseInt(locInput.nextLine());
			  if (locOneY > gridSizeY || locOneY < 0) {
				  setLocOneY();
			  }
			  else {	  
				  System.out.println("The y location of the first exchange is " + locOneY + ".");
			  }
		  }
		  catch (Exception ex) {
			  setLocOneY();
		  }
	}
	
	public void setLocTwoX() {
		Scanner locInput = new Scanner(System.in);
		System.out.println("To set the x location of the second exchange, please enter a positive integer no bigger than " + gridSizeX + "."  + "\n");  
		 try {
			  locTwoX = Integer.parseInt(locInput.nextLine());
			  if (locTwoX > gridSizeX || locTwoX < 0) {
				  setLocTwoX();
			  }
			  else {	  
				  System.out.println("The x location of the second exchange is " + locTwoX + "." + "\n");
			  }
		  }
		  catch (Exception ex) {
			  setLocTwoX();
		  }
	}

	public void setLocTwoY() {
		Scanner locInput = new Scanner(System.in);
		System.out.println("To set the y location of the second exchange, please enter a positive integer no bigger than " + gridSizeY + "."  + "\n");  
		 try {
			  locTwoY = Integer.parseInt(locInput.nextLine());
			  if (locTwoY > gridSizeY || locTwoY < 0) {
				  setLocTwoY();
			  }
			  else {	  
				  System.out.println("The y location of the second exchange is " + locTwoY + "."  + "\n");
			  }
		  }
		  catch (Exception ex) {
			  setLocTwoY();
		  }
	}

	public String findNearest() {
		distanceOne = locOneX + locOneY;
		distanceTwo = locTwoX + locTwoY;
		
		if(distanceOne < distanceTwo) {
			System.out.println("The closest exchange is " + idOne + "."  + "\n");
			closestExchange = idOne;
		}
		else if(distanceTwo < distanceOne) {
			System.out.println("The closest exchange is " + idTwo + "."  + "\n");
			closestExchange = idTwo;
		}
		else {
			if(Math.random() > 0.5) {
				System.out.println("The exchanges are equally close to the customer."  + "\n");
				System.out.println("The system suggests you use exchange " + idOne + "."  + "\n");
				closestExchange = idOne;
			}
			else {
				System.out.println("The exchanges are equally close to the customer."  + "\n");
				System.out.println("The system suggests you use exchange " + idTwo + "."  + "\n");
				closestExchange = idTwo;
			}
		}
		return closestExchange;
		
	}
}