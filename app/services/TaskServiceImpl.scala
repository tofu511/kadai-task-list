package services

import java.time.ZonedDateTime
import javax.inject.Singleton

import models.Task
import scalikejdbc.DBSession

@Singleton
class TaskServiceImpl extends TaskService {

  override def create(task: Task)(implicit s: DBSession): Long = Task.create(task)

  override def findAll(implicit s: DBSession): List[Task] = Task.findAll()

  override def findById(id: Long)(implicit s: DBSession): Option[Task] = Task.findById(id)

  override def update(id: Long, status: String, content: String)(implicit s: DBSession): Int =
    Task.updateById(id)
    .withAttributes(
      'status -> status,
      'content  -> content,
      'updateAt -> ZonedDateTime.now()
    )

  override def deleteById(id: Long)(implicit s: DBSession): Int = Task.deleteById(id)

}
