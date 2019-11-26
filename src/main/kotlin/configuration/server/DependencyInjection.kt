package configuration.server

import configuration.database.mongoConnection
import model.Lesson
import org.litote.kmongo.coroutine.CoroutineCollection

object RepositoryContext {
    val coroutineCollection: CoroutineCollection<Lesson> = mongoConnection()
}