package models.dao

object DAOFactory {
  val dbConfig = play.api.Play.current.configuration.getString("lojinha.db.type", Some(Set("sql", "mongo")))
  
  def itemDAO: ItemDAO = dbConfig match {
    case Some("mongo") => MongoItemDAO
    case Some("sql") => AnormItemDAO
    case None => AnormItemDAO
  }
  
  def bidDAO: BidDAO = dbConfig match {
    case Some("mongo") => MongoBidDAO
    case Some("sql") => AnormBidDAO
    case None => AnormBidDAO
  }
}
