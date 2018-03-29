package amazon;

/**
 * Created by sikpeng on 3/28/2018.
 *
 * http://www.1point3acres.com/bbs/thread-225078-1-1.html
 *
 假设有个Movie类，
 public class Movie.
 {
 int movieId;.
 float rating;
 List<Movie> similarMovies
 //还有其他的getters.
 }.
 现在要求找到 k个和movie最相似的movies。.
 函数的signature大概是这样的：
 public static List<Movie> getNearest(Movie movie, int numSimilar)

 举个栗子：
 m0 <-->m1, similarity 2
 mo <--> m2, similarity 3
 m1 <--> m3, similarity 4
 m2 <--> m5, similaity 5
 如果要返回和mo最相似的movie, 那么应该返回 m5 (只有有一条路径从 m1到 m5, 并且 5是最大的）；
 如果返回3个最相似的就返回 m2, m3， m5（顺序不重要）； 如果需要返回10个，但是相似的只有9个，那么就返回9个。
 source movie本身不能在返回结果里面。

 可以的一个做法是 dfs + min-Heap(PriorityQueue)， 我们一直做dfs，
 每次碰到一个新的movie，如果现在queue的size比 k小的话，直接加到queue里面；
 如果新movie的rating比queue top movie的rating高的话， 把顶部movie
 踢出队列，加上这个新的。

 update: 应该返回 m5 (只有有一条路径从 m1到 m5, 并且 5是最大的） --> 应该返回 m5 (只要有一条路径从 m1到 m5, 并且 5是最大的）



 https://yidongzhang.gitbooks.io/-oa-1/content/movie-network.html


 */
public class MovieNetwork {
}
