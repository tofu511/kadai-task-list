package controllers

import javax.inject.{ Inject, Singleton }

import play.api.i18n.{ I18nSupport, MessagesApi }
import play.api.mvc._
import models.Task

@Singleton
class GetTaskController @Inject()(val messagesApi: MessagesApi) extends Controller with I18nSupport {

  def index(id: Long): Action[AnyContent] = Action { implicit request =>
    val task = Task.findById(id).get
    Ok(views.html.show(task))
  }
}
