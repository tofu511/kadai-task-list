package controllers

import javax.inject.{ Inject, Singleton }

import play.api.i18n.{ I18nSupport, Messages, MessagesApi }
import play.api.mvc.{ Action, AnyContent, Controller }
import services.TaskService

@Singleton
class DeleteTaskController @Inject()(val messagesApi: MessagesApi, taskService: TaskService)
    extends Controller
    with I18nSupport {

  def delete(id: Long): Action[AnyContent] = Action {
    val result = taskService.deleteById(id)
    if (result > 0)
      Redirect(routes.GetTasksController.index())
    else
      InternalServerError(Messages("DeleteTaskError"))
  }
}
