package setianjay.coroutine

import kotlinx.coroutines.*
import org.junit.jupiter.api.Test
import kotlin.jvm.Throws

class CoroutineCancellableTest {

    @Test
    fun testCanNotCancel() {
        runBlocking {
            val job: Job = GlobalScope.launch {
                println("Coroutine Start")
                println("Coroutine Process")
                Thread.sleep(2000) // Tidak bisa di cancel
                println("Coroutine End")
            }
            job.cancel()
            delay(3000)
        }
    }

    @Test
    fun testCanCancel() {
        runBlocking {
            val job: Job = GlobalScope.launch {
                try {
                    if (!isActive) throw CancellationException()
                    println("Coroutine Start")

                    ensureActive()
                    println("Coroutine Process")
                    delay(2000) // Tercancel di sini
                    ensureActive()
                    println("Coroutine End")
                } finally {
                    println("Process Finished")
                }
            }
            job.cancel()
            delay(3000)
        }
    }
}