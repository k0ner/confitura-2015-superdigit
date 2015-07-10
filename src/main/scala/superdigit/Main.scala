package superdigit

// run the program, pass two numbers: the first one is "the base", the second one is how many it will be multiplied, eg.
// 148 3 will result in computing superdigit for 148148148
// but due to the fact that:
// superdigit(148148148) = 3 * superdigit(148)
// the second one is much more performant than the first one because one does not have to concatenate string
object Main extends App {

  import Superdigit._

  val splitted = io.StdIn.readLine().split(" ")

  val n = splitted(0)
  val k = splitted(1).toInt

  val singleComputation = compute(n)

  println(compute((singleComputation * k).toString))
}
