class Bank {
    Map<Integer,Long> mp=new HashMap<>();
    long[] balance;
    public Bank(long[] balance) {
        // int n=balance.length;
        // for(int i=1;i<=n;i++){
        this.balance=balance;
        // }
    }
    
    public boolean transfer(int account1, int account2, long money) {
        if(account1<=balance.length && account2<=balance.length &&balance[account1-1]>=money){
            long temp=balance[account1-1]-money;
            balance[account1-1]=temp;
            balance[account2-1]+=money;
            return true;
        }
        return false;
    }
    
    public boolean deposit(int account, long money) {
        if(account<=balance.length){
            balance[account-1]+=money;
            return true;
        }
        return false;
    }
    
    public boolean withdraw(int account, long money) {
        if(account<=balance.length && balance[account-1]>=money){
            balance[account-1]-=money;
            return true;
        }
        return false;
    }
}

/**
 * Your Bank object will be instantiated and called as such:
 * Bank obj = new Bank(balance);
 * boolean param_1 = obj.transfer(account1,account2,money);
 * boolean param_2 = obj.deposit(account,money);
 * boolean param_3 = obj.withdraw(account,money);
 */