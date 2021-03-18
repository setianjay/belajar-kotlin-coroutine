package setianjay.coroutine

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import java.util.*
import kotlin.concurrent.thread
import kotlin.concurrent.timer
import kotlin.system.measureTimeMillis

/*
* Note :
* Coroutine sama seperti Runnable yang mana mempunyai proses asyncronous, Coroutine juga sama seperti
* Runnable yaitu berjalan di Thread namun Coroutine mempunyai Thread tersendiri.
*
* Untuk membuat sebuah proses dengan Coroutine kita harus menjalankannya dengan scope2 yang ada pada
* Coroutine, misal pada contoh ini kita memakai GlobalScope lalu di ikuti dengan launch.
*
* delay() = fungsinya sama seperti Thread.sleep(), yaitu untuk menunda proses kalkulasi pada Thread.*/

class CoroutineTest {
    private var name = ""
    fun hello() {
        name = "Hari Setiaji"
    }

    @Test
    fun coroutineTest() {
        GlobalScope.launch {
            delay(1000)
            hello()
        }
        println("Menunggu")
        runBlocking {
            delay(2000)
        }
        println(name)
        println("Selesai")
    }

    @Test
    fun threadTimeTest() {
        val time = measureTimeMillis {
            repeat(10000) {
                thread {
                    Thread.sleep(1000)
                    println("Done : $it ${Thread.currentThread().name} ${Date()}")
                }
            }
        }
        println("Menunggu")
        Thread.sleep(2000)
        println("Total time : $time") // Memakan waktu sekitar 3 detik lebih
        println("Selesai")
    }

    @Test
    fun coroutineTimeTest() {
        val time = measureTimeMillis {
            repeat(10000) {
                GlobalScope.launch {
                    delay(1000)
                    println("Done : $it ${Thread.currentThread().name} ${Date()}")
                }
            }
        }
            println("Menunggu")
            runBlocking {
                delay(2000)
                println("Total Time : $time") // Memakan waktu sekitar 1936 detik
            }
            println("Selesai")
    }
}