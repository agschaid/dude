package the.dude.data

trait Id[ M <: Model[M] ]

protected case class IdImpl[ M <: Model[M] ]( id:Int ) extends Id[M]

