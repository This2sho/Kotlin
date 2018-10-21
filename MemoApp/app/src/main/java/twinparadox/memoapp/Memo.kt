package twinparadox.memoapp

class Memo {
    var nodeID:Int?=null
    var nodeTitle:String?=null
    var nodeContent:String?=null

    constructor(nodeID:Int,nodeTitle:String,nodeContent:String) {
        this.nodeID=nodeID
        this.nodeTitle=nodeTitle
        this.nodeContent=nodeContent
    }
}