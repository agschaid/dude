package the.dude.data

/**
 * A generic model.
 * @tparam M the concrete type of the model for reference. In probably every case just the type of the implementing class.
 */
trait Model[M <: Model[M]] { 

  /**
   * the id of the model
   */
  def id:Id[M]

  /**
   * Whether this model's id matches the given one.
   * @parma otherId the id to compare against
   */
  def is( otherId:Id[M] ):Boolean = id == otherId

  /**
   * Wheter this model's id matches the id of the given model.<br>
   * NOTE: This only compares the ids of the two models. Not the values.
   * @param other the model who's id to compare with the own one
   */
  def is( other:M):Boolean = is(other.id)

}

