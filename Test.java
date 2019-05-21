
package ocp;


public class Test {
    public static void main(String[] args)
    {
      ChessBoard chessboard = new ChessBoard(8);
      Queen queen = new Queen(4,4);
      chessboard.insertQueen(queen);
      Block[] blocks = {new Block(1,2),new Block(5,5) };
      int[][] array = chessboard.blockQueensSquare(blocks);
      for(int[] a:array)
      {
          for(int b:a)
          {
              System.out.print(b+" ");
          }
          System.out.println();
      }
      
    }
      
}
class Queen {
    private int row;
    private int column;
    
    public Queen(int row,int column)
    {
        this.row = row;
        this.column = column;
    }
    public void setRow(int row) { this.row = row;  }
    public int getRow() { return row;  }
    
    public void setColumn(int column) { this.column = column; }
    public int getColumn() { return column;  }
}
class ChessBoard {
    private final int[][] array;
    private int row;
    private int column;
    public ChessBoard(int n)
    {
        array = new int[n][n];
    }
    
    public int[][] insertQueen(Queen queen)
    {
        row = queen.getRow()-1;
        column = queen.getColumn()-1;
        array[row][column] = 1;
        for(int i=0;i<array.length;i++)
        {
            if(array[row][i]!=1)
            {
                array[row][i] =2;
            }
        }
        for(int i=0;i<array.length;i++)
        {
            if(array[i][column]!=1)
            {
                array[i][column] = 2;
            }
        }
        int x =row;
        int y = column;
        while(x>=0&&y>=0)
        {
            if(array[x][y]!=1)
            {
                array[x][y] =2;
            }
            x--;
            y--;
        }
        x = row;
        y = column;
        while(x<array.length&&y<array.length)
        {
            if(array[x][y]!=1)
            {
                array[x][y] = 2;
            }
            x++;
            y++;
        }
        x = row;
        y = column;
        while(x<array.length&&y>=0)
        {
            if(array[x][y]!=1)
            {
                array[x][y] = 2;
            }
            x++;
            y--;
        }
        x = row;
        y = column;
        while(x>=0&&y<array.length)
        {
            if(array[x][y]!=1)
            {
                array[x][y] = 2;
            }
            x--;
            y++;
        }
        return array;
    }
    public int[][] blockQueensSquare(Block[] blocks)
    {
        for(Block block:blocks)
        {
           int r = block.getRowNumber();
           int c = block.getColumnNumber();
           if(r>row&&c>column)
           {
               while(r<array.length&&c<array.length)
               {
                   array[r][c]=3;
                   r++;
                   c++;
               }
           }else if(r>row&&c<column){
               while(r<array.length&&c>=0)
               {
                  array[r][c] = 3;
                  r++;
                  c--; 
               } 
           }else if(r<row&&c<column)
           {
               while(r>=0&&c>=0)
               {
                   array[r][c] = 3;
                   r--;
                   c--;
               }
           }else if(r<row&&c>column)
           {
               while(r>=0&&c<array.length)
               {
                   array[r][c] = 3;
                   r--;
                   c++;
               }
           }
        }
        return array;
    }
}
class Block {
    private int rowNumber;
    private int columnNumber;
    
    public Block(int row,int column)
    {
        rowNumber = row;
        columnNumber = column;
    }
    
    public int getRowNumber() { return rowNumber; }
    public void setRowNumber(int row) { rowNumber = row; }
    
    public int getColumnNumber() { return columnNumber; }
    public void setColumnNumber(int column) { columnNumber = column; }
}



