package service

import arrow.core.fix
import configuration.server.RepositoryContext
import exceptions.EntityNotFoundException
import io.reactivex.Flowable
import model.Lesson

fun save(lesson: Lesson) = repository.save(lesson).run(RepositoryContext).fix().extract()

fun getById(id: String) = repository.getById(id).run(RepositoryContext).fix().extract() ?: throw EntityNotFoundException()

fun getByClass(classId: String) =
    Flowable.fromPublisher(repository.getByClass(classId).run(RepositoryContext).fix().extract().publisher)

fun delete(id: String) = repository.delete(id).run(RepositoryContext)

fun replace(id: String, lesson: Lesson) = repository.replace(id, lesson).run(RepositoryContext).fix().extract()
