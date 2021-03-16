package setianjay.coroutine

import org.junit.jupiter.api.Test

class ThreadTest {

    @Test
    fun testThreadName(){
        println(Thread.currentThread().name)
    }

    @Test
    fun testCreateThread(){
        var number = 0
        val runnable = Runnable {
            println("Mengubah nilai number")
            Thread.sleep(2000)
            number = 1
        }

        val thread = Thread(runnable)
        thread.start()
        Thread.sleep(3000)
        println(number)
    }

    @Test
    fun testMultipleThread(){
        var name = ""
        val thread1 = Thread(Runnable {
            println("Mengubah value nama")
            name = "Hari"
        })

        val thread2 = Thread(Runnable {
            println("Mengubah value nama")
            Thread.sleep(1000)
            name = "Hari Setiaji"
        })

        thread1.start()
        thread2.start()
        Thread.sleep(2000)
        println(name)
    }
}