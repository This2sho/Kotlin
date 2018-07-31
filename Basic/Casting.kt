open class Operations() {
    open fun sum(n1:Int, n2:Int):Int {
        return n1+n2
    }
    fun div(n1:Int, n2:Int):Int {
        return n1/n2
    }
}

class MultiOperations:Operations {
    constructor(): super() {

    }
    override fun sum(n1:Int, n2:Int):Int {
        return n1+n2+3
    }
    fun sub(n1:Int, n2:Int):Int {
        return n1-n2
    }
    fun mul(n1:Int, n2:Int):Int { 
        return n1*n2
    }
}

fun main(args:Array<String>) {
    var op=Operations()
    var sum=op.sum(10,15)
    println("sum:"+sum)
    var div=op.div(12,11)
    println("div:"+div)

    var op2=MultiOperations() as Operations
    var sub=op.sum(30,20)
    println("sum:"+sub)
    var mul=op.div(5,6)
    println("div:"+mul)
}