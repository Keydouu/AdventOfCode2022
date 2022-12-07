import java.io.File
import java.io.InputStream

var mainDirectory:MyDirectory = MyDirectory("/",0)
var currentDirectory= mainDirectory

var allDirectories = mutableListOf<MyDirectory>()

fun main(){
    val inputStream: InputStream = File("Input.txt").inputStream()
	inputStream.bufferedReader().useLines {
        lines -> lines.forEach {
            var splitedInput=it.split(' ')
            if(splitedInput[0]=="$"){//command
                if(splitedInput[1]=="cd"){//cd
                    if(splitedInput[2]=="..")//..
                        currentDirectory.goToParrentDirectory()
                    else
                        currentDirectory.goToSubDirectory(splitedInput[2])
                }
            }
            else{
                var newDir:MyDirectory
                if(splitedInput[0]=="dir")
                    newDir=MyDirectory(splitedInput[1], 0)
                else
                    newDir=MyDirectory(splitedInput[1], splitedInput[0].toLong(), "file")
                newDir.parrentDirectory=currentDirectory
                currentDirectory.addSubFile(newDir)
            }
        }
    }
    var total:Long=0
    var directoryToDelete=mainDirectory
    var requiredSpace=(30_000_000+mainDirectory.size-70_000_000)
    println("required space : "+requiredSpace)
    for(entry in allDirectories){
        if(entry.type=="dir"){
            if ((entry.size <= 100_000))
                total+=entry.size
            if((entry.size>requiredSpace)and(entry.size<directoryToDelete.size))
                directoryToDelete=entry
        }
    }
    println("Part 1 : "+total)
    print("Part 2 : "+directoryToDelete.size)
}

class MyDirectory(val name: String, var size: Long, val type: String="dir"){
    var parrentDirectory:MyDirectory=mainDirectory
    var subFiles = mutableMapOf<String, MyDirectory>()
    fun addSubFile(newDirectory: MyDirectory){// considered files as directory because having both in one list is a pain in the ass
        if(subFiles.get(newDirectory.name)==null){
            subFiles.put(newDirectory.name,newDirectory)
            if(newDirectory.type=="file")
                this.addSize(newDirectory.size)
            else
                allDirectories.add(newDirectory)
        }
    }
    fun addSize(extraSize:Long){
        this.size+=extraSize
        if(this.name!="/")//avoiding infinite loop because main directory's parrent directory is itself
            parrentDirectory.addSize(extraSize)
    }
    fun goToParrentDirectory(){
        //if(currentDirectory==this) Always true as long as input is correct
            currentDirectory=parrentDirectory
    }
    fun goToSubDirectory(subName:String){
        if(subName!="/"){
            var newDir=subFiles.get(subName)
            if(newDir!=null)
                currentDirectory=newDir
            else{
                newDir=MyDirectory(subName, 0)
                this.addSubFile(newDir)
                newDir.parrentDirectory=this
                currentDirectory=newDir
            }
        }
    }
}