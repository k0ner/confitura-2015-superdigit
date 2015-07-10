package superdigit

import org.scalatest.prop.TableDrivenPropertyChecks.forAll
import org.scalatest.prop.Tables.Table
import org.scalatest.{Matchers, WordSpec}

class SuperdigitSpec extends WordSpec with Matchers {

  "Superdigit" should {

    import Superdigit._
    "compute proper superdigit" in new context {

      forAll(superdigits) { (n: String, s: Int) =>
        compute(n) shouldBe s
      }
    }

    "compute superdigit from integer" in {

      compute(Int.MaxValue) shouldBe 1
    }

    "compute superdigit from long" in {

      compute(Long.MaxValue) shouldBe 7
    }
  }

  trait context {
    val superdigits =
      Table(
        ("n", "s"),
        ("9875", 2),
        ("10", 1),
        ("1", 1),
        ("11", 2),
        ("148148148", 3)
      )
  }

}
