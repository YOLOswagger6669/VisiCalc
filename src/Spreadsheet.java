public class Spreadsheet {
  private Cell[][] cells;
  private static int rows=11;
  private static int cols=8;
  private static int columnWidth=12;
  private static int asciiOffset=64;
  private String border;
  private String borderRow;
  private static int getCol(String location) {
    return (int) location.charAt(0) - asciiOffset;
  }
  private static int getRow (String location) {
    return Integer.parseInt(location.substring(1));
  }
  private static String padOrTruncateDisplayString(Cell cell) {
     // truncate string to length - 1 and display >
     String s = cell.getDisplayString();
     if (s.length() > columnWidth) {
       s = s.substring(0, columnWidth - 1) + ">";
     }
     // if length is odd pad end to even length
     if (s.length() % 2 == 1) {
       s += " ";
     }
     // justify pad to center in cell
     while (s.length() < columnWidth) {
       s = " " + s + " ";
     }
     return s;
 }
  public Spreadsheet() {
    cells[0][0]=new CellString(" ");
    for(int col=1; col<cols; col++) {
      cells[0][col]=new CellString((asciiOffset+col)+" ");
    }
    for(int row=1; row<rows; row++) {
      cells[row][0]=new CellString(row+"");
    }
    for(int col=1; col<cols; col ++) {
      cells[row][col]= new CellString("");
      String border="";
      for(int i=0; i<colwidth; i++) {
        border+="-";
      }
      String borderRow=border+="+";
    }
  }
  public void setCell(String location, Cell cell) {
    cells[getRow(location)][getCol(location)]= cell;
 }
  public Cell getCell(String location) {
    return cells[getRow(location)][getCol(location)];
  }
  private int getColumn() {
    return location.charAt(0)-asciiOffset;
  }
  public void print() {
   for (int row = 0; row< rows; row++){
     for(int col = 0; col<cols; col++)
     {
       System.out.print(padOrTruncateDisplayString(cells[row][col])+ "|");
     }
     System.out.println(borderRow);
   }
 }
}
