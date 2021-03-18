package setianjay.coroutine

import kotlinx.coroutines.*
import org.junit.jupiter.api.Test


/*
* Note:
* launch = Secara otomatis akan menjalankan fungsi coroutine secara asyncrounous.
*
* CoroutineStart.LAZY = Berfungsi jika kita ingin membuat coroutine yang mana corutine yang kita buat
* tidak langsung di jalankan(syncrounous) melainkan nanti dijalankannya pada saat kita panggil.
*
* join() = Berfungsi untuk menunggu sebuah proses coroutine sampai selsai dan jika sudah selesai maka
* code selanjutnya baru akan di lanjutkan.
*
* joinAll() = Sama seperti join() namun joinAll() dapat menunggu sebuah proses coroutine lebih dari 1.
*
* cancel() = Berfungsi untuk membatalkan proses coroutine.
*
* */
class JobTest {

    @Test
    fun testJob() {
        println("Before coroutine")
        runBlocking {
            GlobalScope.launch {
                delay(10000)
                println("Coroutine function start")
            }
            delay(11_000)
            println("Kerjain ini dulu")
        }
    }

    @Test
    fun testJobLazy(){
        println("Before coroutine")
        runBlocking {
            val job: Job = GlobalScope.launch(start = CoroutineStart.LAZY) {
                delay(1000)
                println("Coroutine function start")
            }
            job.start()
            delay(1000)
            println("Kerjain ini dulu")
        }
    }

   @Test
    fun testJobJoin(){
        println("Before coroutine")
        runBlocking {
            val job: Job = GlobalScope.launch(start = CoroutineStart.LAZY) {
                delay(1000)
                println("Coroutine function start")
            }
            job.start()
            job.join()
            println("Kerjain ini dulu")
        }
    }

    @Test
    fun testJobJoinAll(){
        println("Before coroutine")
        runBlocking {
            val job1: Job = GlobalScope.launch {
                delay(1000)
                println("Coroutine function start")
            }
            val job2: Job = GlobalScope.launch {
                delay(2000)
                println("Coroutine function start")
            }
            joinAll(job1,job2)
            println("Kerjain ini dulu")
        }
    }

    @Test
    fun testJobCancel(){
        println("Before coroutine")
        runBlocking {
            val job: Job = GlobalScope.launch(start = CoroutineStart.LAZY) {
                delay(1000)
                println("Coroutine function start")
            }
            job.start()
            job.cancel(message = "Proses di batalkan")
            println("Kerjain ini dulu")
        }
    }
}