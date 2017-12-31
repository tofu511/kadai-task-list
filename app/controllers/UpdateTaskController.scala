package controllers

import javax.inject.{ Inject, Singleton }

import forms.TaskForm
import play.api.i18n.{ I18nSupport, Messages, MessagesApi }
import play.api.mvc.{ Action, AnyContent, Controller }
import services.TaskService

@Singleton
class UpdateTaskController @Inject()(val messagesApi: MessagesApi, taskService: TaskService)
    extends Controller
    with I18nSupport
    with TaskControllerSupport {

  def index(id: Long): Action[AnyContent] = Action { implicit request =>
    val result     = taskService.findById(id).get
    val filledForm = form.fill(TaskForm(result.id, result.status.getOrElse(""), result.content))
    Ok(views.html.edit(filledForm))
  }

  def update: Action[AnyContent] = Action { implicit request =>
    form
      .bindFromRequest()
      .fold(
        formWithErrors => BadRequest(views.html.edit(formWithErrors)), { model =>
          val result = taskService.update(model.id.get, model.status, model.content)
          if (result > 0)
            Redirect(routes.GetTasksController.index())
          else
            InternalServerError(Messages("UpdateTaskError"))
        }
      )
  }
}
