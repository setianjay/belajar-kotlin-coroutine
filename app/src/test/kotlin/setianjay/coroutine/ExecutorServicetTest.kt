package setianjay.coroutine

import org.junit.jupiter.api.Test
import java.util.*
import java.util.concurrent.Executors

/*
* Note :
* ExecutorService = Memanajemen Thread
*
* newSingleThreadExecutor() = Membuat ExecutorService dengan mempunyai 1 thread untuk meng handle
* proses nya
*
* newFixedThreadPool(n: Int) = Membuat ExecutorService dengan mempunyai n thread untuk meng handle
* proses nya
*
* newCachedThreadPool() = Membuat ExecutorService dengan mempunyai jumlah Thread sesuai dengan jumlah
* proses nya
* */

class ExecutorServicetTest {

    @Test
    fun singleThreadPoolTest() {
        val singleExecutor = Executors.newSingleThreadExecutor()
        repeat(5) {
            val runnable = Runnable {
                // Memberikan waktu jeda selama 1 detik untuk setiap proses perulangannya
                Thread.sleep(1000)
                println("Done $it ${Thread.currentThread().name} ${Date()}")
            }
            singleExecutor.execute(runnable)
            println("Selesai memasukan runnable $it")
        }

        println("Menunggu")
        Thread.sleep(6_000)
        println("Selesai")

    }

    @Test
    fun fixThreadPoolTest() {
        val fixExecutor = Executors.newFixedThreadPool(3)
        repeat(10) {
            val runnable = Runnable {
                Thread.sleep(1000)
                println("Done $it ${Thread.currentThread().name} ${Date()}")
            }
            fixExecutor.execute(runnable)
            println("Repeat $it Masuk")
        }

        println("Menunggu")
        Thread.sleep(11_000)
        println("Selesai")
    }

    @Test
    fun cacheThreadPoolTest() {
        val fixExecutor = Executors.newCachedThreadPool()
        repeat(10) {
            val runnable = Runnable {
                Thread.sleep(1000)
                println("Done $it ${Thread.currentThread().name} ${Date()}")
            }
            fixExecutor.execute(runnable)
            println("Repeat $it Masuk")
        }

        println("Menunggu")
        Thread.sleep(4000)
        println("Selesai")
    }
}