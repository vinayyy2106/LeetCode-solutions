class Solution {
    public boolean checkString(String s) {
        int ind=s.indexOf('b');
        int last=s.lastIndexOf('a');
        return (last<ind || ind==-1)?true:false;
    }
}