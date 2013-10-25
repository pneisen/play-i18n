package controllers

import play.api.mvc.{Action, Controller}
import play.api.Logger
import java.util.Date

case class User(name: String)

object Application extends Controller {
  
  def index = Action { implicit request =>
    Logger.logger.debug("Request Header: " + request.headers.toString)
    
    // Setup some implicits to automatically get passed to the views
    implicit val user = User("Pete")
    implicit val now : Date = new Date()
    
    Ok(views.html.index())
  }
}