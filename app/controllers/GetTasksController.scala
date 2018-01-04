package controllers

import javax.inject.{ Inject, Singleton }

import play.api.mvc._
import play.api.i18n.{ I18nSupport, MessagesApi }
import services.TaskService

@Singleton
class GetTasksController @Inject()(val messagesApi: MessagesApi, taskService: TaskService)
    extends Controller
    with I18nSupport {

  def index: Action[AnyContent] = Action { implicit request =>
    val result = taskService.findAll
    Ok(views.html.index(result))
  }
}
