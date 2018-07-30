fun main(args:Array<String>) {
    var t1=thread("Thread1")
    t1.start()

    var t2=thread("Thread2")
    t2.start()

    var t3=thread("Thread3")
    t3.start()
    t3.join()
    println(" thread is run")
}

class thread():Thread() {
    var  ThreadName:String=""

    constructor(ThreadName:String):this() {
        this.ThreadName=ThreadName
        println(this.ThreadName+" is started")
    }

    override fun run() {
        var cnt=0
        while(cnt<10) {
            println(this.ThreadName+" Count:$cnt")
            cnt++

            try {
                Thread.sleep(1000)
            }
            catch (ex:Exception) {
                print(ex.message)
            }
        }
    }
}