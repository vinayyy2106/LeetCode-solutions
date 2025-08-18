class Solution {
    public List<Integer> getRow(int rowIndex) {
        
        List<Integer> row = new ArrayList<>();
        row.add(1);  // C(rowIndex, 0) = 1
        long ans = 1;

        for (int col = 1; col <= rowIndex; col++) {
            ans = ans * (rowIndex - col + 1) / col;
            row.add((int) ans);
        }

        return row;
    }
}