**some code snippet**

int[] copiedArray = Arrays.copyOf(array, newLength);

there is the ListIterator<E> which provides two-way traversal it.next() and it.previous().
linkedList.listIterator().previous()

Date expiry = new Date( epoch * 1000 );

for (Iterator<String> it = myList.iterator(); it.hasNext(); ) {}

DateTimeFormatter f = DateTimeFormatter.ofPattern( "dd-MM-yyyy" );
LocalDate start = LocalDate.parse( "22-02-2010" , f );

Collections.sort(fares,Collections.reverseOrder(Comparable) )
Comparator<Fare> comparingByRate= Comparator.comparingDouble(f -> f.getFareEstimate());
Collections.sort(fares,Collections.reverseOrder(comparingByRate) );

Map<String, Long> counts =
    list.stream().collect(Collectors.groupingBy(e -> e.key, Collectors.counting()));

List<Integer> aliceScores
for (Integer aliceScore : aliceScores) {

int idx=Collections.binarySearch(arr,"df")

regex
this\s+is\s+text -> \s white space
https://www.vogella.com/tutorials/JavaRegularExpressions/article.html

**some general notes**
find path in graph : BFS not DFS
``CLEAN-READABLE code``
``READ CAREFULLY``
edge cases
CONFIDENCE-SENNII
DFS is not optimal, meaning the number of steps in reaching the solution, or the cost spent in reaching it is high.
DFS is complete means it finds the solution is there is any
DP is another version of Recursive, so we can easily convert rec to dp, 
with the same tasks ( basic, and relation to previous item) : check LCS        
