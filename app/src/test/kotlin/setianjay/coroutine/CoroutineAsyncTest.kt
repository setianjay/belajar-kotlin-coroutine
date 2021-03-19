package setianjay.coroutine

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import kotlin.system.measureTimeMillis
import kotlin.time.measureTime

/*
* Note :
* async = Berfungsi seperti launch hanya saja fungsi async dapat mengembalikan value seperti Callable.
*
* launch = Berfungsi seperti async hanya saja fungsi launch tidak dapat mengembalikan value seperti
* runnable.
*
* await() = Berfungsi untuk menunggu balikan value dari proses coroutine.
*
* */

class CoroutineAsyncTest {

    suspend fun getFoo(): Int{
        delay(1000)
        return 10
    }

    suspend fun getBar(): Int{
        delay(1000)
        return 20
    }

    @Test
    fun asyncTest(){
        var result  = 0
        runBlocking {
            val time = measureTimeMillis {
                val foo = GlobalScope.async { getFoo() }
                val bar = GlobalScope.async { getBar() }

                result = foo.await() + bar.await()
            }
            println("Time : ${time}")
            println("Result : $result")
        }
    }
}