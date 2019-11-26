package recfun

object RecFun extends RecFunInterface {

  def main(args: Array[String]): Unit = {
    // 1
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(s"${pascal(col, row)} ")
      println()
    }

    println()

    // 2
    println("Balance")
    println(balance("(if (zero? x) max (/ 1 x))".toList))
    println(balance("I told him (that it’s not (yet) done). (But he wasn’t listening)".toList))
    println(balance(":-)".toList))
    println(balance("())(".toList))

  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    if (c == 0 || c == r) 1
    else pascal(c-1, r-1) + pascal(c, r-1)
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    println(f"chars: ${chars.mkString}")

    def is

    var i = 0
    val leftIdx = chars.indexOf('(')
    val rightIdx = chars.indexOf(')')

    if (leftIdx < 0 && rightIdx < 0) true
    else if (leftIdx > 0 && rightIdx > 0) balance(chars)
    else false


//    if (chars.isEmpty) true
//    else if (chars.length == 1) false
//    else if (chars.head == '(' && chars.last == ')') balance(chars.slice(1, chars.length-1))
//    else if (chars.head == '(') balance(chars.slice(0, chars.length-1))
//    else if (chars.last == ')') balance(chars.slice(1, chars.length))
//    else balance(chars.slice(1, chars.length-1))
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = ???
}
