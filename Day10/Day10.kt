import java.io.File
import java.io.InputStream
fun main(){
    val inputStream: InputStream = File("Input.txt").inputStream()
    var clock=Clock()
	inputStream.bufferedReader().useLines {
        lines -> lines.forEach {
            val input=it.split(' ')
            if (input[0]=="noop")
                clock.noop()
            else
                clock.addX(input[1].toInt())
        }
    }
    print("Part 1 : "+clock.total)
}
class Clock(){
    var xRegister=1
    var time=1
    var total=0
    var crtX=0
    val timeTable=arrayOf(20, 60, 100, 140, 180, 220)
    fun noop(){
        if(time in timeTable)
            total+=time*xRegister
        time++
        crt()
    }
    fun addX(i:Int){
        noop()
        noop()
        xRegister+=i
    }
    fun crt(){
        if(Math.abs(crtX-xRegister)<2)
            print('#')
        else
            print('.')
        crtX++
        if(crtX==40){
            println()
            crtX=0
        }
    }
}