package setianjay.coroutine

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test

/*
* Note :
* Coroutine sama seperti Runnable yang mana mempunyai proses asyncronous, Coroutine juga sama seperti
* Runnable yaitu berjalan di Thread namun Coroutine mempunyai Thread tersendiri.
*
* Untuk membuat sebuah proses dengan Coroutine kita harus menjalankannya dengan scope2 yang ada pada
* Coroutine, misal pada contoh ini kita memakai GlobalScope lalu di ikuti dengan launch.
*
* delay() = fungsinya sama seperti Thread.sleep(), yaitu untuk menunda proses kalkulasi pada Thread.*/

class Coroutine {
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
}