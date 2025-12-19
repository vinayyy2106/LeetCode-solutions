class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {

        Map<Integer, List<Pair>> mp = new HashMap<>();
        for (int[] m : meetings) {
            mp.computeIfAbsent(m[0], k -> new ArrayList<>()).add(new Pair(m[2], m[1]));
            mp.computeIfAbsent(m[1], k -> new ArrayList<>()).add(new Pair(m[2], m[0]));
        }

        int[] resArray = new int[n];
        Arrays.fill(resArray, Integer.MAX_VALUE);
        resArray[0] = 0;
        resArray[firstPerson] = 0;

        PriorityQueue<Pair> pq =
            new PriorityQueue<>((a, b) -> a.time - b.time);

        pq.offer(new Pair(0, 0));
        pq.offer(new Pair(0, firstPerson));

        while (!pq.isEmpty()) {
            Pair p = pq.poll();

            if (p.time > resArray[p.person]) continue;
            if (!mp.containsKey(p.person)) continue;

            for (Pair pr : mp.get(p.person)) {
                if (pr.time >= p.time && resArray[pr.person] > pr.time) {
                    resArray[pr.person] = pr.time;
                    pq.offer(new Pair(pr.time, pr.person));
                }
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (resArray[i] != Integer.MAX_VALUE) {
                res.add(i);
            }
        }
        return res;
    }
}

class Pair {
    int time;
    int person;
    Pair(int time, int person) {
        this.time = time;
        this.person = person;
    }
}
