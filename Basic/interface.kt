interface op {
    fun sum(n1:Int, n2:Int)
    fun div(n1:Int, n2:Int)
}

class UserOp:op {
    override fun sum(n1:Int, n2:Int) {
        println("sum:"+n1+n2)
    }
    override fun div(n1:Int, n2:Int) {
        println("div:"+n1/n2)
    }
}

class AdminOp:op { 
    override fun sum(n1:Int, n2:Int) {
        println("sum:"+(n1+n2+2))
    }
    override fun div(n1:Int, n2:Int) {a
        println("div:"+(n1/n2+2))
    }
}

class ManagerOp:op { 
    override fun sum(n1:Int, n2:Int) {
        println("sum:"+(n1+n2-1))
    }
    override fun div(n1:Int, n2:Int) {
        println("div:"+(n1/n2-1))
    }
}

fun main(args:Array<String>) {
    var admin=AdminOp()
    var user=UserOp()
    var manager=ManagerOp()
    println("Admin class")
    admin.sum(1,2)
    admin.div(10,5)

    println("User class")
    user.sum(1,2)
    user.div(10,5)
}