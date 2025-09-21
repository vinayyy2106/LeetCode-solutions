class MovieRentingSystem {
    private Map<Integer, TreeSet<int[]>> available;//movie to available shops(unrented)
    private TreeSet<int[]> rented;//all rented movies, sorted by (price, shop, movie)
    private Map<String, Integer> priceMap;// (shop, movie) -> price lookup
    private Map<String, int[]> entryMap;

    public MovieRentingSystem(int n, int[][] entries) {
        this.available=new HashMap<>();
        this.entryMap = new HashMap<>();
        this.rented = new TreeSet<>((a, b) -> 
            a[2] != b[2] ? a[2] - b[2] : 
            (a[0] != b[0] ? a[0] - b[0] : a[1] - b[1])
        );
        this.priceMap=new HashMap<>();
        for(int[] e:entries){
            int shop = e[0], movie = e[1], price = e[2];
            int[] entry = new int[]{shop, movie, price};
            priceMap.put(shop + "," + movie, price);
            entryMap.put(shop + "," + movie, entry);
            available.computeIfAbsent(movie, k -> new TreeSet<>(
                (x, y) -> x[2] != y[2] ? x[2] - y[2] : x[0] - y[0]
            )).add(entry);
        }
    }
    
    public List<Integer> search(int movie) {
        List<Integer> li=new ArrayList<>();
        if(!available.containsKey(movie))return li;
        int count=0;
        for(int[] arr:available.get(movie)){
            if(count>=5){
                break;
            }else{
                li.add(arr[0]);
            }
            count++;
        }
        return li;
    }
    
    public void rent(int shop, int movie) {
        int[] entry = entryMap.get(shop + "," + movie);
        available.get(movie).remove(entry);
        rented.add(entry);
    }
    
    public void drop(int shop, int movie) {
        int[] entry = entryMap.get(shop + "," + movie);
        rented.remove(entry);
        available.get(movie).add(entry);
    }
    
    public List<List<Integer>> report() {
        List<List<Integer>> rep=new ArrayList<>();
        int count=0;
        for(int[] x:rented){
            if(count>=5){
                break;
            }else{
                rep.add(Arrays.asList(x[0], x[1]));
            }
            count++;
        }
        return rep;
    }
}

/**
 * Your MovieRentingSystem object will be instantiated and called as such:
 * MovieRentingSystem obj = new MovieRentingSystem(n, entries);
 * List<Integer> param_1 = obj.search(movie);
 * obj.rent(shop,movie);
 * obj.drop(shop,movie);
 * List<List<Integer>> param_4 = obj.report();
 */