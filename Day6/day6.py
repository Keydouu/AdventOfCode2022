inputFile = open("Day6/Input.txt", "r")
input=inputFile.readline()
inputFile.close()
i=0
j=0
read=""
foundPart1=False
while True:
    if not foundPart1:
        if len(read)==4:
            foundPart1=True
            print("Part 1 : "+str(i))
    if input[i] in read:
        read=read[(read.index(input[i])+1):len(read)]
        read+=input[i]
    else:
        read+=input[i]
        if len(read)==14:
            break
    i+=1
print("part 2 : "+str(i+1))