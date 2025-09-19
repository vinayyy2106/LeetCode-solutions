class Spreadsheet {
    int[][] array;
    public Spreadsheet(int rows) {
        this.array=new int[rows][26];
    }
    
    public void setCell(String cell, int value) {
        char col=cell.charAt(0);
        String row=cell.substring(1);
        int rowIndex = Integer.valueOf(row) - 1;
        int colIndex = col - 'A';
        array[rowIndex][colIndex]=value;
    }
    
    public void resetCell(String cell) {
        char col=cell.charAt(0);
        String row=cell.substring(1);
        int rowIndex = Integer.valueOf(row) - 1;
        int colIndex = col - 'A';
        array[rowIndex][colIndex]=0;
    }
    private int getCellValue(String cell){
        char col=cell.charAt(0);
        String row=cell.substring(1);
        int rowIndex = Integer.valueOf(row) - 1;
        int colIndex = col - 'A';
        return array[rowIndex][colIndex];
    }
    
    public int getValue(String formula) {
        String realFormulae=formula.substring(1);
        String[] parts=realFormulae.split("\\+");
        String left = parts[0].trim();
        String right = parts[1].trim();
        int val1, val2;
        //for left
        if(Character.isLetter(left.charAt(0))){
            val1=getCellValue(left);
        }else{
            val1=Integer.parseInt(left);
        }
        //for right
        if(Character.isLetter(right.charAt(0))){
            val2=getCellValue(right);
        }else{
            val2=Integer.parseInt(right);
        }
        return val1+val2;
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */