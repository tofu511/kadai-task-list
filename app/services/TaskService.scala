package services

import models.Task
import scalikejdbc.{ AutoSession, DBSession }

trait TaskService {

  def create(task: Task)(implicit s: DBSession = AutoSession): Long

  def findAll(implicit s: DBSession = AutoSession): List[Task]

  def findById(id: Long)(implicit s: DBSession = AutoSession): Option[Task]

  def update(id: Long, status: String, content: String)(implicit s: DBSession = AutoSession): Int

  def deleteById(id: Long)(implicit s: DBSession = AutoSession): Int
}
