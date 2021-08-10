// Java2316.java
// This program draws small squares at every mouse click position.
// The program will crash if you try to draw more than 100 squares.


import java.applet.Applet;
import java.awt.*;


public class Java2316 extends Applet
{
	
	Image picture1, picture2,picture3;  // Declare objects of Image class into which you will put actual pictures
	Image[] match;  // Declare an Image array so the computer can 'remember' images to match
	Rectangle rec1, rec2,rec3;// Declare Rectangle objects to coorespond to Images to be matched
	int clickCount;  // count clicks so pictures will be compared every two clicks
	int recNum;  // class variable used to identify what rectangle has been clicked upon
	int result=0;
	
	public void init ()
	{
		
		match = new Image[3];  //Demensions array to remember images to match
		clickCount=0;  // initialize clickCount
		recNum=0;     // initialize rectangle number
		rec1= new Rectangle (0,435,220,435);  // Creates actual rectangle that computer can "see"
		rec2= new Rectangle (240,400,240,400); 
		rec3= new Rectangle (460,447,460,447);  // Creates actual rectangle that computer can "see"
		picture1 = getImage(getDocumentBase(),"1.jpg");	// stores given image file into picture1
		picture2 = getImage(getDocumentBase(),"2.jpg");	// stores given image file into picture2
		picture3= getImage(getDocumentBase(),"3.jpg");													
	}
	
	public void paint(Graphics g)
	{
		g.drawImage(picture1,0,435,this);  // Displays picture1 on screen
		g.drawImage(picture2,240,400,this);	// Displays picture2 on screen	
		g.drawImage(picture3,460,447,this);	
		switch (recNum)
		{
			case 1:
				g.setColor(Color.red);
				g.drawString("Player choice rock", 380,140);
				//playerchoice=0;
				match[clickCount] = picture1; //Stores the picture clicked on into match array
				break;
			case 2:
				g.setColor(Color.red);
				g.drawString("Player choice scissors", 380,140);
				//playerchoice=1;
				match[clickCount] = picture2; //Stores the picture clicked on into match array
				break;
			case 3:
				g.setColor(Color.red);
				g.drawString("Player choice paper", 380,140);
				//playerchoice=2;
				match[clickCount] = picture3; //Stores the picture clicked on into match array
				break;
			
		}
		
		
		clickCount++;  // advances clickCount
		clickCount=clickCount%2; // Ensures clickCount will always be either 0 or 1 so pairs of images can
		// be compared for exact matches	
	}
	
	public boolean mouseDown(Event e, int x, int y)
	{
		if(rec1.inside(x,y))  // test for clicking on rec1
		{
			recNum = 1;
			int playerchoice = 0;
		}
		else if(rec2.inside(x,y))
		{
			 // test for clicking on rec1
			recNum = 2;
			int playerchoice = 1;
		}
		else if(rec3.inside(x,y))
		{
			recNum = 3;
			int playerchoice = 2;
		}
			
		else
			recNum = 4; // neither rectagle is clicked on
		repaint();
		
		return true;
	}
	public int computerchoice()
	{
		int computerchoice = (int) Math.random()*3;
		return computerchoice;
	}
	
	
	public int determineWinner (int computerchoice, int playerchoice)
	{
	   
	   if(computerchoice==playerchoice)
	   {
	   	result=3;
	   }
	   
	   if(playerchoice==0)
		{
			
			if(computerchoice==1)
				result=1;
			if(computerchoice==2)
				result=2;
		}
		else if(playerchoice==1)
		{
			if(computerchoice==0)
				result=1;
			if(computerchoice==2)	
				result=2;
		}
		else if(playerchoice==2)
		{
			if(computerchoice==0)
				result=1;
			if(computerchoice==1)	
				result=2;
		}
	
	return result;
	}
	
	public void result(Graphics g)
	{
		if(result==1)
		{
			g.setColor(Color.red);
			g.drawString("victory", 380,140);
		}
		if(result==2)
		{
			g.setColor(Color.green);
			g.drawString("defeat", 380,140);
		}
		if(result==3)
		{
			g.setColor(Color.blue);
			g.drawString("Draw", 380,140);
		}
	}

		
		
	}	

	
		
		


		
		
	


	
