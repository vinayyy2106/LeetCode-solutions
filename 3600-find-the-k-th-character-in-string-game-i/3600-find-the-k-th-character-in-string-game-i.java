class Solution {
    public char kthCharacter(int k) {
    //     String word="a";
    //     while(word.length()<k){
    //         char[] arr=word.toCharArray();
    //         StringBuilder changed=new StringBuilder("");
    //         for(char ch:arr){
    //             if(ch=='z'){
    //                 changed.append('a');
    //             }else{
    //                 changed.append((char)(ch+1));
    //             }               
    //         }
    //         word+=changed;
    //     }
    //     return word.charAt(k-1);
    //....bf......
    int val=Integer.bitCount(k-1);
    return (char)('a'+val);
    }
}