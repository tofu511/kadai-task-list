package controllers

import org.scalatestplus.play.guice.GuiceOneAppPerSuite
import play.api.test.FakeRequest
import play.api.test.Helpers._

class CreateTaskControllerSpec extends PlayFunSpec with GuiceOneAppPerSuite {

  describe("CreateTaskController") {
    describe("route of CreateTaskController#index") {
      it("should be valid") {
        val result = route(app, addCsrfToken(FakeRequest(GET, routes.CreateTaskController.index().toString))).get
        status(result) mustBe OK
      }
    }

    describe("route of CreateTaskController#create") {
      val result =
        route(app,
              addCsrfToken(
                FakeRequest(POST, routes.CreateTaskController.create().toString)
                  .withFormUrlEncodedBody("status" -> "N", "content" -> "test")
              )).get

      status(result) mustBe SEE_OTHER
    }
  }
}
