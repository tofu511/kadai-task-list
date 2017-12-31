package controllers

import java.time.ZonedDateTime
import javax.inject.{ Inject, Singleton }

import models.Task
import play.api.i18n.{ I18nSupport, Messages, MessagesApi }
import play.api.mvc.{ Action, AnyContent, Controller }
import services.TaskService

@Singleton
class CreateTaskController @Inject()(val messagesApi: MessagesApi, taskService: TaskService)
    extends Controller
    with I18nSupport
    with TaskControllerSupport {

  def index: Action[AnyContent] = Action { implicit request =>
    Ok(views.html.create(form))
  }

  def create: Action[AnyContent] = Action { implicit request =>
    form
      .bindFromRequest()
      .fold(
        formWithErrors => BadRequest(views.html.create(formWithErrors)), { model =>
          val now    = ZonedDateTime.now()
          val task   = Task(None, Some(model.status), model.content, now, now)
          val result = taskService.create(task)
          if (result > 0)
            Redirect(routes.GetTasksController.index())
          else
            InternalServerError(Messages("CreateTaskError"))
        }
      )
  }
}
