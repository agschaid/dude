package the.dude.data


trait Item extends Model[ Item ] {
  def text:String
  def comment:Option[String]

}

case class ActiveItem( id:Id[Item], text:String, quantity:String, comment:Option[String] ) extends Item

case class FinishedItem(id:Id[Item], text:String, comment:Option[String] ) extends Item

