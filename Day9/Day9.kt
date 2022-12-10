import java.io.File
import java.io.InputStream

fun main(){
    val inputStream: InputStream = File("Input.txt").inputStream()
    var ropeOrSnakeOrSomething=Postion()
    ropeOrSnakeOrSomething.saveTailPos()
	inputStream.bufferedReader().useLines {
        lines -> lines.forEach {
            val input=it.split(' ')
            for(i in 0..(input[1].toInt()-1))
                ropeOrSnakeOrSomething.getMoves(input[0])
        }
    }
    print(ropeOrSnakeOrSomething.getNumberOfPos().toInt())
}
class Postion(var hx:Int =0, var hy:Int =0, var tx:Int =0, var ty:Int =0){
    var allTailPos = mutableListOf<String>()
    fun getNumberOfPos():Int{
        return allTailPos.size
    }
    fun saveTailPos(){
        val x:String= hx.toString()+"-"+hy.toString()
        if (x !in allTailPos)
            allTailPos.add(x)
    }
    fun getMoves (input:String){
        when (input[0]){
            'U'->executeMove( 0,  1)
            'D'->executeMove( 0, -1)
            'L'->executeMove(-1, 0)
            'R'->executeMove( 1, 0)
        }
    }
    fun executeMove(i:Int, j:Int){
        if((hx+i-tx>1)or(hx+i-tx<-1)or(hy+j-ty>1)or(hy+j-ty<-1)){
            tx=hx
            ty=hy
            saveTailPos()
        }
        hx+=i
        hy+=j
    }
}