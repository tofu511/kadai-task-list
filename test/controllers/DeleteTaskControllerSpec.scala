package controllers

import org.scalatestplus.play.guice.GuiceOneAppPerSuite
import play.api.test.FakeRequest
import play.api.test.Helpers._

class DeleteTaskControllerSpec extends PlayFunSpec with GuiceOneAppPerSuite {

  describe("DeleteTaskController") {
    describe("route of DeleteTaskController#delete") {
      val fakeId = 1L
      val result =
        route(app,
              addCsrfToken(
                FakeRequest(POST, routes.DeleteTaskController.delete(fakeId).toString)
              )).get
      status(result) mustBe SEE_OTHER
    }
  }
}
