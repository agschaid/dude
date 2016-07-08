package the.dude.data


/**
 * An item on the shopping list. Active or finished.
 */
sealed trait Item extends Model[ Item ] {

  /**
   * The text/description of the item. E.g. "Mozarella"
   */
  def text:String

  /**
   * An optional comment. E.g. "The one in the yellow packaging is the best"
   */ 
  def comment:Option[String]

}


/**
 * An item you still need to buy.
 * @param id see [[Model]]
 * @param text see [[Item]]
 * @param quantity free text signifying how much of it you need
 * @param comment see [[Item]]
 */
case class ActiveItem( id:Id[Item], text:String, quantity:String, comment:Option[String] ) extends Item {

  /**
   * Returns a finished/bought version of this item.
   */
  def asFinished() = FinishedItem( id, text, comment )
}

/**
 * An item you have allready bought and that is only stored for future reference.
 * @param id see [[Model]]
 * @param text see [[Item]]
 * @param comment see [[Item]]
 */
case class FinishedItem(id:Id[Item], text:String, comment:Option[String] ) extends Item {

  /**
   * Return an active version of this item.
   * @param quantity the quantity to be used in the new item
   */
  def asActive( quantity:String ) = ActiveItem( id, text, quantity, comment )
}

