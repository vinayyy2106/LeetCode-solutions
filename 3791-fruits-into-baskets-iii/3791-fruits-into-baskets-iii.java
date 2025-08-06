class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n=baskets.length;
        int[] segmentTree=new int[4*n];//min size we define for forming a segment tree
        build(0,0,n-1,segmentTree,baskets);
        int unplaced=0;
        for(int fruit:fruits){
            if(!canBePlaced(0,0,n-1,segmentTree,fruit)){
                unplaced++;
            }
        }
        return unplaced;
    }
    public boolean canBePlaced(int i,int l,int r,int[] segmentTree,int fruit){
        if(segmentTree[i]<fruit){
            return false;
        }
        if(l==r){
            segmentTree[i]=-1;
            return true;
        }
        int mid=l+(r-l)/2;
        boolean placed=false;
        if(segmentTree[2*i+1]>=fruit){
            placed=canBePlaced(2*i+1,l,mid,segmentTree,fruit);
        }else{
            placed=canBePlaced(2*i+2,mid+1,r,segmentTree,fruit);
        }
        //before returning as we are updating above the segmentTree at i=-1 so we need to change all others basis on this ri8 while coming back
        segmentTree[i]=Math.max(segmentTree[2*i+1],segmentTree[2*i+2]);
        return placed;
    }
    public void build(int i,int l,int r,int[] segmentTree,int[] baskets){
        if(l==r){
            segmentTree[i]=baskets[l];
            return;
        }
        int mid=l+(r-l)/2;
        build(2*i+1,l,mid,segmentTree,baskets);
        build(2*i+2,mid+1,r,segmentTree,baskets);
        segmentTree[i]=Math.max(segmentTree[2*i+1],segmentTree[2*i+2]);
    }
}