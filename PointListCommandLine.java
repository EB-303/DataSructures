
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StreamTokenizer;
import java.awt.Point;
import java.io.Reader;
 
public class PointListCommandLine {
	ArrayPointList arr;
	InputStreamReader reader;
	StreamTokenizer tokens;
	
	
	public PointListCommandLine() {
		arr = new ArrayPointList();
		// create sreamTokenizer object that's get input from the terminal
		reader = new InputStreamReader( System.in ); 
		tokens = new StreamTokenizer( reader );
		// message for user
		// System.out.print( "Enter the string (end with quit) : " ); 
		
	}
	

	public void parser() throws IOException { 
		while ( true ){	
			this.tokens.nextToken(); 
			// switch case on tokens.sval
			switch( this.tokens.sval ) {
				case "add":
					if( this.tokens.nextToken() != StreamTokenizer.TT_WORD ) {
					Point point = new Point(); 
					point.x = ( int )this.tokens.nval;    
					this.tokens.nextToken();
					point.y = ( int )this.tokens.nval;    
					arr.append( point );
					}
					break;
				case "curr":
					// -> return the point that the cursor is on it
					System.out.println("(" + arr.getCursor().x + ", " + arr.getCursor().y + ")"); 
					break;
				case "next":
					// -> move the cursor to the next point in the array
					System.out.println(arr.goToNext());  
					break;
				case "prev":
					// -> move the cursor to the previous point in the array
					System.out.println(arr.goToPrior()); 
					break;
				case "start":
					// -> move the cursor to the beginning
					System.out.println(arr.goToBeginning()); 
					break;
				case "end":
					// -> move the cursor to the end
					System.out.println(arr.goToEnd());  
					break;
				case "empty":
					// -> return boolean, is the array empty of values ?
					System.out.println(arr.isEmpty());  
					break;
				case "full":
					// -> return boolean, is the array full of values ? 
					System.out.println(arr.isFull());  
					break; 
				case "clear":
					// -> delete all the values
					arr.clear(); 
					break;
				case "quit":
					// -> end the program
					System.exit( 0 ); 
				} // end switch case
			}  // end while loop
		} // end parser
	
	
	public void run() {
		try { 
			this.parser();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		
		PointListCommandLine plc = new PointListCommandLine();
		plc.run();
	} // end main
} // end class
