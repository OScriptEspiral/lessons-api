package repository

import arrow.data.Reader
import arrow.data.ReaderApi.ask
import arrow.data.map
import com.mongodb.client.model.Filters
import configuration.server.RepositoryContext
import kotlinx.coroutines.runBlocking
import model.Lesson

fun save(lesson: Lesson): Reader<RepositoryContext, Lesson> =
    ask<RepositoryContext>().map { ctx ->
        runBlocking {
            lesson.also {
                ctx.coroutineCollection.insertOne(lesson)
            }
        }
    }

fun getById(id: String) =
    ask<RepositoryContext>().map { ctx ->
        runBlocking {
            ctx.coroutineCollection.findOneById(id)
        }
    }

fun getByClass(classId: String) =
    ask<RepositoryContext>().map { ctx ->
        ctx.coroutineCollection.find(Filters.eq("classId", classId))
    }

fun delete(id: String) =
    ask<RepositoryContext>().map { ctx ->
        runBlocking {
            ctx.coroutineCollection.deleteOneById(id)
        }
    }

fun replace(id: String, lesson: Lesson) =
    ask<RepositoryContext>().map { ctx ->
        runBlocking {
            ctx.coroutineCollection.replaceOneById(id, lesson)
        }
    }
