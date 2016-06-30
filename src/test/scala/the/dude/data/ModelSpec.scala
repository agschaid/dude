package the.dude.data

import org.scalatest._

class ModelSpec extends FlatSpec with Matchers {

  case class DummyModel( id:Id[DummyModel], someData:String ) extends Model[DummyModel]

  private def model( id:Int, someData:String ) = DummyModel( new IdImpl[DummyModel](id), someData )

  // TODO why oh why aren't these test actually run?
  "A Model" should "equal itself" in {
    val m = model(1, "asd")
    m.is(m) should be (true)
  }

  "A model" should "equal a model with the same id but different data" in {
    val idInt = 2
    val m1 = model(idInt, "m1")
    val m2 = model(idInt, "m2")

    m1.is(m2) should be (true)
    m2.is(m1) should be (true)

  }

  "A model" should "not equal another model with different id" in {
    val m1 = model(3, "data")
    val m2 = model(4, "data")

    m1.is(m2) should be (false)
    m2.is(m1) should be (false)
  }

}

