abstract class CreditCard() { 
    fun CreditID():String {
        return "12345asdfg"
    }
    abstract fun newCredit()
}

class UserInfo() : CreditCard() { 
    fun getInfo():String {
        return CreditID()
    }
    override fun newCredit() {
        println("New CreditCard Created!")
    }
}

fun main(args:Array<String>) {
    var user=UserInfo()
    user.newCredit()
    println(user.getInfo())
}