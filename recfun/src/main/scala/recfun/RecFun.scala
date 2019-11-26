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

    println()

    // 3
    println("Counting Change")
    println(countChange(4, List(1, 2)))
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
    def balance0(input: List[Char], cnt: Int): Boolean = {
      if (cnt < 0) false
      else if (input.isEmpty) cnt == 0
      else if (input.head == '(') balance0(input.tail, cnt + 1)
      else if (input.head == ')') balance0(input.tail, cnt - 1)
      else balance0(input.tail, cnt)
    }
    balance0(chars, 0)
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    def countChange0(money: Int, coin: Int): Int = {
      val newMoney = money - coin
      if (newMoney < 0) 0
      else if (newMoney == 0) 1
      else coins.filter(c => c <= coin).map(c => countChange0(newMoney, c)).sum
    }
    coins.map(coin => countChange0(money, coin)).sum
  }
}
