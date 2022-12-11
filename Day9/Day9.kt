import java.io.File
import java.io.InputStream
fun main(){
    val inputStream: InputStream = File("Input.txt").inputStream()
    var ropeOrSnakeOrSomething=Rope()
	inputStream.bufferedReader().useLines {
        lines -> lines.forEach {
            val input=it.split(' ')
            for(i in 0..(input[1].toInt()-1)){
                ropeOrSnakeOrSomething.getMoves(input[0][0])
            }
        }
    }
    println("Part 1 : "+ropeOrSnakeOrSomething.getNumberOfPos())
    print("Part 2 : "+ropeOrSnakeOrSomething.getNumberOfPos2())
}
class Point(){
    var x=0
    var y=0
    fun newPos(i:Int, j:Int){
        x=i
        y=j
    }
    fun newPos(p: Point){
        x=p.x
        y=p.y
    }
    fun distance(i:Int, j:Int):Int{
        return maxOf(Math.abs(x-i), Math.abs(y-j))
    }
    fun distance(p: Point):Int{
        return maxOf(Math.abs(x-p.x), Math.abs(y-p.y))
    }
    fun fellow(p:Point){
        if(this.x<p.x)
            x+=1
        else if(this.x>p.x)
            x-=1
        if(this.y<p.y)
            y+=1
        else if(this.y>p.y)
            y-=1
    }
    override fun toString():String{
        return x.toString()+";"+y.toString()
    }
}
class Rope(){
    var allPartTwoTailPos = mutableListOf<String>()
    var allTailPos = mutableListOf<String>()
    var allPoints = mutableListOf<Point>()
    init{
        for (i in 0..9)
            allPoints.add(Point())
        allTailPos.add("0;0")
        allPartTwoTailPos.add("0;0")
    }
    fun getNumberOfPos():Int{
        return allTailPos.size
    }
    fun getNumberOfPos2():Int{
        return allPartTwoTailPos.size
    }
    fun getMoves (input:Char){
        when (input){
            'U'->allPoints.get(0).y+=1
            'D'->allPoints.get(0).y-=1
            'L'->allPoints.get(0).x-=1
            'R'->allPoints.get(0).x+=1
        }
        executeMove(0)
    }
    fun executeMove(currentKnot:Int){
        if(currentKnot==9){
            val myStr:String= allPoints.get(currentKnot).toString()
            if (myStr !in allPartTwoTailPos)
                allPartTwoTailPos.add(myStr)
        }
        else {
            if(currentKnot==1){
                val myStr:String= allPoints.get(currentKnot).toString()
                if (myStr !in allTailPos)
                    allTailPos.add(myStr)
            }
            if(allPoints.get((currentKnot+1)).distance(allPoints.get(currentKnot))>1){
                allPoints.get(currentKnot+1).fellow(allPoints.get(currentKnot))
                executeMove(currentKnot+1)
            }
        }
    }
}