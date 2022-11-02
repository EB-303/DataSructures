import java.awt.Point;

public class ArrayPointList implements PointList {
	// Declare variables
    private int maxSize; // user size is the max size of the array
    private Point[] points;
    private int cursor; // pointer to the indexes of the array
    private int currSize; // number of elements

    // Constructors
        
	public ArrayPointList( int size ) {
		// Generate by user size
		points = new Point[size];
		maxSize = size;
		cursor = 0;
		currSize = 0;
	}
	
	public ArrayPointList() {
    	// Default values for empty array of size 100
    	this(MAX_SIZE);
    	}
    

	@Override
	public void append(Point newPoint) {
		// Check if the size is valid & adds newPoint to the end of the list
		if ( !isFull() ) {
            points[currSize++] = newPoint;
            // Moves cursor to newPoint
            cursor = currSize - 1;
		}
	}
	

	@Override
	public void clear() {
		// Reset the array's values
        currSize = 0;
        cursor = 0;
	}
	

	@Override
	public boolean isEmpty() {
		if( currSize == 0 )
			return true;
		return false;
	}
	

	@Override
	public boolean isFull() {
		if( currSize == maxSize )
			return true;
		return false;
	}

	@Override
	public boolean goToBeginning() {
		// Check if the array isn't empty
		if( isEmpty() ) {
			return false;
		}
		cursor = 0;
		return true;
	}

	
	@Override
	public boolean goToEnd() {
		// Check if the array is empty
		if( isEmpty() )
			return false;
		// Move the cursor to the last element of the array
		cursor = currSize - 1; 
		return true;
	}
	

	@Override
	public boolean goToNext() {
		if( (cursor == currSize - 1) || ( isEmpty())  ) // Check if the cursor is in the last element
			return false;
		// Otherwise increase the cursor to the next index
			cursor ++;
			return true;
	}
	

	@Override
	public boolean goToPrior() {
		if( (cursor == 0) || ( isEmpty())  ) // Check if the cursor is in the last element
			return false;
		// Otherwise decrease the cursor to the previous index
			cursor --;
			return true;
	}

	
	@Override
	public Point getCursor() {
		if( isEmpty() )
			return null;
		return new Point(points[cursor]);
	}

	
	@Override
	public String toString(){
        String s ="";
        for(int i=0; i < this.maxSize; i++) {
           s += points[i].toString();
        }
		return s;
    } 

}
