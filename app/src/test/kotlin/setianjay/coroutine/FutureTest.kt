package setianjay.coroutine

import org.junit.jupiter.api.Test
import java.util.concurrent.Callable
import java.util.concurrent.Executors
import kotlin.system.measureTimeMillis

/*
* Note :
* Jika kita memakai Thread, maka kita akan memanggil function run yang ada di dalam interface Runnable.
* function run didalam interface runnable bersifat unit/void yang berarti tidak mengembalikan apa2.
*
* Jika kita ingin menjalankan suatu Thread dengan nilai kembalian atau return value, maka kita bisa
* menggunakan interface Callable.
*
* Untuk menjalankan Callable di ExecutorService maka kita bisa memanggilnya dengan fungsi submit*/


class FutureTest {

    /*
    * Jika kita memakai newSingleThread maka lama waktu proses sama seperti
    * timeNonParaleltest() yaitu 2 Detik.
    *
    * Jika kita memakai newFixedThread maka lama waktu proses adalah 1 Detik.*/
    private val fixThread = Executors.newFixedThreadPool(3)


    fun getFoo(): Int{
        Thread.sleep(1000)
        return 10
    }

    fun getBar(): Int{
        Thread.sleep(1000)
        return 10
    }

    @Test
    fun timeNonParalelTest(){
        val time = measureTimeMillis {
            val foo = getFoo()
            val bar = getBar()

            println(foo + bar)
        }
        println("Total time : $time") // 2 Detik
    }

    @Test
    fun timeFutureTest(){
        val time = measureTimeMillis {
        val foo = fixThread.submit(Callable { getFoo() }) // Future<Int>
        val bar = fixThread.submit(Callable{ getBar() }) // Future<Int>
            val foo1 = fixThread.submit(Callable { getFoo() })

        val result = foo.get() + bar.get() + foo1.get()
            println("Result : ${result}")
        }

        println("Total time : $time") // 1 Detik


    }


}