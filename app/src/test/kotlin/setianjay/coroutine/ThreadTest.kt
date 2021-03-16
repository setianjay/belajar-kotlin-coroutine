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
        println(number)
    }
}