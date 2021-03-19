package setianjay.coroutine

import kotlinx.coroutines.*
import org.junit.jupiter.api.Test
import java.util.*

/*
* Note:
* withTimeOut() = Berfungsi untuk membatasi fungsi coroutine dengan waktu yang telah di tentukan,
* jika lewat dari waktu yang di tentukan maka akan mengembalikan throw TimeoutCancellationException
* dan coroutine di hentikan.
*
* withTimeOutOrNull() = Berfungsi untuk membatasi fungsi coroutine dengan waktu yang telah di tentukan,
* jika lewat dari waktu yang di tentukan maka akan mengembalikan null bukan throw
* TimeoutCancellationException sehingga proses coroutine tidak di hentikan.
*  */

class CoroutineTimeoutTest {


    @Test
    fun withTimeOutTest() {
        runBlocking {
            val job: Job = GlobalScope.launch {
                println("Coroutine Start")
                withTimeout(5000) {
                    repeat(10) {
                        delay(1000)
                        println("$it ${Date()}")
                    }
                }
                println("Coroutine Finish") // Tidak tereksekusi
            }
            job.join()
        }
    }

    @Test
    fun withTimeOutOrNullTest() {
        runBlocking {
            val job: Job = GlobalScope.launch {
                println("Coroutine Start")
                withTimeoutOrNull(5000) {
                    repeat(100) {
                        delay(1000)
                        println("$it ${Date()}")
                    }
                }
                println("Coroutine Finish") // Tereksekusi
            }

            job.join()
        }
    }
}