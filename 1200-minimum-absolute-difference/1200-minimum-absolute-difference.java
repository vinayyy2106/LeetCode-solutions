class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int n=arr.length;
        List<List<Integer>> ans=new ArrayList<>();
        if(n==2){
            List<Integer> li=new ArrayList<>();
            li.add(arr[0]);
            li.add(arr[1]);
            ans.add(li);
            return ans;
        }
        int diff=Integer.MAX_VALUE;
        for(int i=0;i<n-1;i++){
            diff=Math.min(arr[i+1]-arr[i],diff);
        }
        for(int i=0;i<n-1;i++){
            int dif=arr[i+1]-arr[i];
            if(dif==diff){
                List<Integer> temp=new ArrayList<>();
                temp.add(arr[i]);
                temp.add(arr[i+1]);
                ans.add(temp);
            }
        }
        return ans;
    }
}