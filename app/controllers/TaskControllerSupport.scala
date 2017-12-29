package controllers

import forms.TaskForm
import play.api.data.Forms._ // play.api.data.Formだとmappingできないので注意
import play.api.data._
import play.api.mvc.Controller

trait TaskControllerSupport { this: Controller =>

  protected val form = Form(
    mapping(
      "id"      -> optional(longNumber),
      "content" -> nonEmptyText(maxLength = 255)
    )(TaskForm.apply)(TaskForm.unapply)
  )

}
