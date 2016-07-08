package the.dude.data

/**
 * A generic id.
 * @tparam M the type of the model this id belongs to
 */
trait Id[ M <: Model[M] ]

object Id {
  def newId[M <: Model[M]]() = IdImpl[M]( rawId[M] )

  private def rawId[M <: Model[M]]():Int = ???
}

/**
 * Primitive implementation if an id. Probably's going to change.
 */
protected case class IdImpl[ M <: Model[M] ]( id:Int ) extends Id[M]

