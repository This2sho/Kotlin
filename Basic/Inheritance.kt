open class Operations() {
    protected var ProcessName:String?=null
    fun sum(n1:Int, n2:Int):Int {
        return n1+n2
    }
    fun div(n1:Int, n2:Int):Int {
        return n1/n2
    }
}

class MultiOperations():Operations() {
    fun sub(n1:Int, n2:Int):Int {
        return n1-n2
    }
    fun mul(n1:Int, n2:Int):Int { 
        return n1*n2
    }

    // Visibility Modifier
    fun GetName() { 
        super.ProcessName
    }
}

fun main(args:Array<String>) {
    var op=MultiOperations()
    var sum=op.sum(10,15)
    println("sum:"+sum)
    var div=op.div(12,11)
    println("div:"+div)

    println("op.ProcessName : "+op.GetName())

    var sub=op.sub(30,20)
    println("sub:"+sub)
    var mul=op.mul(5,6)
    println("mul:"+mul)
}