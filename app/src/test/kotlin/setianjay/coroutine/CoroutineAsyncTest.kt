package setianjay.coroutine

import kotlinx.coroutines.*
import org.junit.jupiter.api.Test
import kotlin.system.measureTimeMillis

/*
* Note :
* async = Berfungsi seperti launch hanya saja fungsi async dapat mengembalikan value seperti Callable.
*
* launch = Berfungsi seperti async hanya saja fungsi launch tidak dapat mengembalikan value seperti
* runnable.
*
* await() = Berfungsi untuk menunggu balikan value dari proses coroutine.
*
* awaitAll() = Berfungsi sama dengan await() namun di awaitAll() kita bisa menunggu sebuah proses
* Coroutine lebih dari 1 proses.
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
    fun asyncWithAwaitTest(){
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


    @Test
    fun asyncWithAwaitAll(){
       var result: Int = 0

        runBlocking {
            val time = measureTimeMillis {
                val foo1 = GlobalScope.async { getFoo() }
                val foo2 = GlobalScope.async { getFoo() }
                val bar1 = GlobalScope.async { getBar() }
                val bar2 = GlobalScope.async { getBar() }

                result = awaitAll(foo1,foo2,bar1,bar2).sum()
            }
            println("Result : $result")
            println(time)
        }

    }
}