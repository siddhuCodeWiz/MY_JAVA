package PreFS;

/*
 * Given an 2D character array, Letters[][], of size r*c.
You have to construct the word W, using the given array.

Rules to construct the word are as follows:
	- All the letters of the word W, should be adjacent to each other 
	in the array Letters(either horizontal or vertical).
	- You can use each charcater in Letters[][] only once.

If you are able to construct the word W, return 'true'
Otherwise 'false'.

Input Format:
-------------
Line-1 -> two integers R and C, array size.
R lines -> C space separated characters.
Last line -> a string, word W

Output Format:
--------------
print the boolean result.


Sample Input-1:
---------------
3 3
a b c
d e f
g h i
bad

Sample Output-1:
----------------
true


Sample Input-2:
---------------
3 3
a b c
d e f
g h i
ace

Sample Output-2:
----------------
false


Sample Input-3:
---------------
3 3
a b c
d e f
g h i
add

Sample Output-3:
----------------
false

 */

import java.util.*;

public class Day_34 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Program 1
        // int m = sc.nextInt();
        // int n = sc.nextInt();

        // String[][] arr = new String[m][n];

        // for(int i=0; i<m; i++){
        //     for(int j=0; j<n; j++){
        //         arr[i][j] = sc.next();
        //     }
        // }

        // String s = new String(sc.next());

        // Program1 p1 = new Program1(s, m, n);
        // p1.isPossible(arr);
        // System.out.println(p1.isPossible);





        // Program 2
        // String s = sc.nextLine();
        // Program2 p2 = new Program2(s);
        // p2.divideWords();
        // System.out.println(p2.maxx);


        // Program 3

        Program3 p3 = new Program3();

        p3.n = sc.nextInt();
        p3.mat = new int[p3.n][p3.n];
        for(int i=0; i<p3.n; i++){
            for(int j=0; j<p3.n; j++){
                p3.mat[i][j] = sc.nextInt();
            }
        }

        p3.findBridgeDist();
        System.out.println(p3.minnn);
    }
}








class Program1{
    String s;
    int m;
    int n;
    Program1(String s, int m, int n){
        this.s = s;
        this.m = m;
        this.n = n;
    }
    boolean isPossible = false;

    public void isPossible(String[][] arr){
        boolean[][] visited = new boolean[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                // visited[i][j] = true;
                StringBuilder sb = new StringBuilder("");
                helper(arr, i, j, visited, sb);
                // sb.deleteCharAt(sb.length()-1);
                visited[i][j] = false;
            }
        }

    }

    public void helper(String[][] arr, int i, int j, boolean[][] visited, StringBuilder curr){
        if(s.equals(curr.toString())){
            // System.out.println(curr.toString());
            isPossible = true;
            return;
        }
        if(i<0 || i>=m || j<0 || j>=n || visited[i][j]==true){
            return;
        }
        curr.append(arr[i][j]);
        visited[i][j] = true;
        helper(arr, i+1, j, visited, curr);
        helper(arr, i, j+1, visited, curr);
        helper(arr, i-1, j, visited, curr);
        helper(arr, i, j-1, visited, curr);

        curr.deleteCharAt(curr.length()-1);
        visited[i][j] = false;
    }
}








/*
 * Mr Parandhamayya working with words.
He is given a word W, you need to divide the word into N non-empty parts, 
such that all the newly formed words should be distinct, and 
if you append all those words should form original word W.

Your task is to help Mr Parandhamayya to divide the word into N parts,
such that, the value of N should be maximized, and print N.

Input Format:
-------------
Line-1: A string W, a word.

Output Format:
--------------
Print an integer result, the value of N.


Sample Input-1:
---------------
banana

Sample Output-1:
----------------
4

Explanation: 
------------
One way to divide the word is "b","a","n","ana".
If you divide it like "b","a","n","an","a".The word "a" will be repeated.
So it is not allowed to divide like the second way.


Sample Input-2:
---------------
mississippi

Sample Output-2:
----------------
7

Explanation: 
------------
One of the way to divide the word is "m","i","s","si","ssi","p","pi".

NOTE: Subsequences are not allowed.

 */

class Program2{
    String s;
    LinkedHashSet<String> hs;
    int maxx;
    Program2(String s){
        this.s = s;
        hs = new LinkedHashSet<>();
        maxx = 0;
    }

    public void divideWords(){
        helper(0);
    }

    public void helper(int currInd){
        if(currInd==s.length()){
            System.out.println(hs);
            maxx = Math.max(maxx, hs.size());
            return;
        }

        for(int i=currInd+1; i<=s.length(); i++){
            String substring = s.substring(currInd, i);
            if (!hs.contains(substring)) {
                hs.add(substring);
                helper(i);
                hs.remove(substring);
            }
        }
    }
}







/* The Pandavas and Kauravas each rule different kingdoms separated by a river. 
If the two kingdoms are connected, the land will form a square-shaped area. 
The kingdoms are represented by cells marked with 1, and the river is 
represented by cells marked with 0.

The Pandavas and Kauravas have decided to build a bridge over the river to 
improve connectivity between their kingdoms. To minimize the cost of construction, 
they aim to reduce the length of the bridge. The bridge can only be built on 
river cells that are connected in the four cardinal directions (up, down, left, 
and right).

Your task is to help the rulers minimize the number of river cells used for 
building the bridge, and return the count of river cells occupied.

Input Format:
-------------
Line-1: An integer N, size of the land.
Next N lines: N space separated integers, either 0 or 1. 

Output Format:
--------------
Print an integer result.


Sample Input-1:
---------------
4
1 1 1 0
1 0 0 0
1 0 0 1
0 0 1 1

Sample Output-1:
----------------
2


Sample Input-2:
---------------
5
1 1 0 0 0
1 1 0 0 0
0 0 0 0 1
0 0 0 1 1
0 0 1 1 1

Sample Output-2:
----------------
3
*/

class Program3{
    int minnn;
    int n;
    int[][] mat;

    Program3(){
        minnn = Integer.MAX_VALUE;
    }

    public void findBridgeDist(){
        OUTER:for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(mat[i][j]==1){
                    convert(i, j);
                    printMat();
                    helper(i, j, 0);
                    break OUTER;
                }
            }
        }
    }

    public void printMat(){
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
    }

    public void convert(int x, int y){
        Queue<Coords> que = new LinkedList<>();
        mat[x][y]=-1;
        que.add(new Coords(x, y));

        int[][] dirs = {{0,1}, {1,0}, {-1,0}, {0, -1}};
        Coords curr;
        int currx, curry, newx, newy;
        while(!que.isEmpty()){
            curr = que.poll();
            currx = curr.x;
            curry = curr.y;

            for(int i=0; i<dirs.length; i++){
                newx = currx+dirs[i][0];
                newy = curry+dirs[i][1];

                if(newx>=0 && newx<n && newy>=0 && newy<n && mat[newx][newy]==1){
                    mat[newx][newy]=-1;
                    que.add(new Coords(newx, newy));
                }
            }
        }
    }


    public void helper(int x, int y, int currLen){
        Queue<Coords> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];
        
        // Add all marked (-1) kingdom cells to queue
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == -1) {
                    queue.add(new Coords(i, j, 0));
                    visited[i][j] = true;
                }
            }
        }
    
        // Directions for movement (up, down, left, right)
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    
        while (!queue.isEmpty()) {
            Coords curr = queue.poll();
    
            for (int[] dir : directions) {
                int newX = curr.x + dir[0];
                int newY = curr.y + dir[1];
    
                if (newX >= 0 && newX < n && newY >= 0 && newY < n && !visited[newX][newY]) {
                    // If we reach the second kingdom (mat[newX][newY] == 1)
                    if (mat[newX][newY] == 1) {
                        minnn = Math.min(minnn, curr.dist); // Print shortest bridge length
                        return;
                    }
    
                    // If it's a river cell (0), continue BFS
                    if (mat[newX][newY] == 0) {
                        queue.add(new Coords(newX, newY, curr.dist + 1));
                        visited[newX][newY] = true;
                    }
                }
            }
        }
    }
    
}

class Coords{
    int x;
    int y;
    int dist;

    Coords(int x, int y){
        this.x = x;
        this.y = y;
    }

    Coords(int x, int y, int dist){
        this.x = x;
        this.y = y;
        this.dist=dist;
    }
}