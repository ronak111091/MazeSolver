import java.util.Scanner;

public class Maze {
	
	public void solveMaze(){
		Scanner in = null;
		try {
			in = new Scanner(System.in);
			int rows = in.nextInt();
			in.nextLine();
			char[][] maze = new char[rows][];
			for(int i=0;i<rows;i++){
				maze[i] = in.nextLine().toCharArray();
			}
			int columns = maze[0].length;
			int[] startIndex = getStartPosition(maze, rows, columns);
			move(maze, startIndex[0], startIndex[1], "", '?');
			
		} finally {
			// TODO: handle finally clause
			in.close();
		}
	}
	
	private boolean move(char[][] maze, int currRowInd, int currColInd, String tempPath, char reverseDirection){
		String path = new String(tempPath);
		//move bottom
		
		if(currRowInd+1<maze.length && maze[currRowInd+1][currColInd]!='@' && reverseDirection!='D'){
//			path = path+"D";
			if(maze[currRowInd+1][currColInd]=='F'){
				System.out.println(path+"D");
				return true;
			}else{
				move(maze, currRowInd+1, currColInd, path+"D", 'U');
			}
		}
		
			
		//move right
		if(currColInd+1<maze[0].length && maze[currRowInd][currColInd+1]!='@' && reverseDirection!='R'){
//			path = path+"R";
			if(maze[currRowInd][currColInd+1]=='F'){
				System.out.println(path+"R");
				return true;
			}else{
				move(maze, currRowInd, currColInd+1, path+"R", 'L');
			}
		}	
		//move left
			
		if(currColInd-1>=0 && maze[currRowInd][currColInd-1]!='@' && reverseDirection!='L'){
//			path = path+"L";
			if(maze[currRowInd][currColInd-1]=='F'){
				System.out.println(path+"L");
				return true;
			}else{
				move(maze, currRowInd, currColInd-1, path+"L", 'R');
			}
		}
		
		//move top
		
		if(currRowInd-1>=0 && maze[currRowInd-1][currColInd]!='@' && reverseDirection!='U'){
//			path = path+"U";
			if(maze[currRowInd-1][currColInd]=='F'){
				System.out.println(path+"U");
				return true;
			}else{
				move(maze, currRowInd-1, currColInd, path+"U", 'D');
			}
		}
		return false;
	}
	
	private int[] getStartPosition(char[][] maze,int rows,int columns){
		int[] startPosition = new int[2];
		int i = 0;
		//top
		for(i=0;i<columns;i++){
			if(maze[0][i]=='S'){
				startPosition[0]=0;
				startPosition[1]=i;
				return startPosition;
			}
		}
		//left
		for(i=0;i<rows;i++){
			if(maze[i][0]=='S'){
				startPosition[0]=i;
				startPosition[1]=0;
				return startPosition;
			}
		}
		
		//bottom
		for(i=0;i<columns;i++){
			if(maze[rows-1][i]=='S'){
				startPosition[0]=rows-1;
				startPosition[1]=i;
				return startPosition;
			}
		}
		
		//right
		for(i=0;i<rows;i++){
			if(maze[i][columns-1]=='S'){
				startPosition[0]=i;
				startPosition[1]=columns-1;
				return startPosition;
			}
		}
		return startPosition;
	}
	
	public static void main(String[] args) {
		Maze maze = new Maze();
		maze.solveMaze();
	}

}
