package superdigit

import scala.annotation.tailrec

trait Convertions {
  implicit def int2String(v: Int): String = v.toString

  implicit def long2String(v: Long): String = v.toString
}

// superdigit computation for even extremely long number. Provided converters enables us to pass int or long,
// but string is much more flexible
object Superdigit extends Convertions {

  @tailrec
  final def compute(number: String): Int = number.toList match {
    case x :: Nil => x.toString.toInt
    case x => compute(x.map(_.asDigit).sum)
  }
}


