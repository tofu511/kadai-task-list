package services
import java.time.ZonedDateTime

import models.Task
import scalikejdbc.DBSession

class MockTaskService extends TaskService {

  override def create(task: Task)(implicit s: DBSession): Long = 1L

  override def findAll(implicit s: DBSession): List[Task] =
    List(Task(Some(1L), Some("D"), "test", ZonedDateTime.now(), ZonedDateTime.now()))

  override def findById(id: Long)(implicit s: DBSession): Option[Task] =
    Some(Task(Some(1L), Some("D"), "test", ZonedDateTime.now(), ZonedDateTime.now()))

  override def update(id: Long, status: String, content: String)(implicit s: DBSession): Int = 1

  override def deleteById(id: Long)(implicit s: DBSession): Int = 1
}
