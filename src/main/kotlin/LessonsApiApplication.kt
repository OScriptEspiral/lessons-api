import configuration.server.ktorServer
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
fun main() {
    ktorServer().start(wait = true)
}