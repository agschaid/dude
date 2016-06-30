package the.dude.data

trait Model[M <: Model[M]] { 
  def id:Id[M]

  def is( otherId:Id[M] ):Boolean = id == otherId
  def is( other:M):Boolean = is(other.id)

}

