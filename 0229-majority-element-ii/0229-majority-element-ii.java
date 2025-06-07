class Solution {
    //moore's voting
    public List<Integer> majorityElement(int[] nums) {
        int count1=0;
        int count2=0;
        int ele1=0;
        int ele2=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(count1==0 && nums[i]!=ele2){
                ele1=nums[i];
                count1=1;
            }else if(count2==0 && nums[i]!=ele1){
                ele2=nums[i];
                count2=1;
            }
            else if(nums[i]==ele1){
                count1++;
            }
            else if(nums[i]==ele2){
                count2++;
            }
            else{
                count1--;
                count2--;
            }
        }
        int c=(int)n/3;
        int ec1=0;
        int ec2=0;
        List<Integer> list=new ArrayList<>();
    for(int i=0;i<n;i++){
        if(nums[i]==ele1)ec1++;
        else if(nums[i]==ele2)ec2++;
        
    }
    if(ec1>c)list.add(ele1);
    if(ec2>c)list.add(ele2);
    // Collections.sort(list);
    return list;
    }
    
    
}