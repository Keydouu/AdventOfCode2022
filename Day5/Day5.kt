import java.io.File
import java.io.InputStream

var stacks1 = mutableListOf<Stack>()
var stacks2 = mutableListOf<Stack>()

fun main(){
    val inputStream: InputStream = File("Input.txt").inputStream()
    var readingInit=true
	inputStream.bufferedReader().useLines {
        lines -> lines.forEach {
            if(readingInit){
                readingInit=readInitialPositions(it)
                if(!readingInit){
                    for(elem in stacks1){
                        elem.reverse()
                    }
                    for(elem in stacks2){
                        elem.reverse()
                    }
                }
            }
            else if(it[0]=='m'){
                var splited:List<String> = it.split(' ')
                partOneMove((splited[1].toInt()-1), (splited[3].toInt()-1), (splited[5].toInt()-1))
                partTwoMove((splited[1].toInt()-1), (splited[3].toInt()-1), (splited[5].toInt()-1))
            }
        }
        print("part One : ")
        for(elem in stacks1){
            elem.printLast()
        }
        print("\npart Two : ")
        for(elem in stacks2){
            elem.printLast()
        }
    }
}
fun partOneMove(numberOfMoves: Int, fromStack: Int, toStack:Int){
    for(i in 0..numberOfMoves){
        stacks1.elementAt(toStack).add(stacks1.elementAt(fromStack).take())
    }
}
fun partTwoMove(numberOfMoves: Int, fromStack: Int, toStack:Int){
    var c = stacks2.elementAt(fromStack).take()
    if(numberOfMoves>0){
        partTwoMove((numberOfMoves-1), fromStack, toStack)
    }
    stacks2.elementAt(toStack).add(c)
}
fun readInitialPositions(line : String) : Boolean {
    if(line=="")
        return false
    val tokens: List<String> = line.split("(?<=\\G.{4})".toRegex())
    var i=-1

    if (tokens[0]==" 1  ")
        return true
    if (stacks1.size<1){
        for(j in 1..tokens.size){
            stacks1.add(Stack())
            stacks2.add(Stack())
        }
    }

    for(elem in tokens){
        i++
        if(elem.length<2)
            continue
        if (elem[1]==' ')
            continue
        stacks1.elementAt(i).add(elem[1])
        stacks2.elementAt(i).add(elem[1])
    }
    return true
}

class Stack{
    var crates = mutableListOf<Char>()
    fun add(newCrate: Char){
        crates.add(newCrate)
    }
    fun reverse(){
        crates.reverse()
    }
    fun take(): Char{
        var leavingCrate = crates.last()
        crates.removeAt(crates.size-1)
        return leavingCrate
    }
    fun printAll(){
        val j=crates.size
        for(i in 0..(j-1)){
            print(crates.elementAt(j-i-1))
        }
        println()
    }
    fun printLast(){
        if(crates.size>0)
            print(crates.last())
        else
            print(" ")
    }
}