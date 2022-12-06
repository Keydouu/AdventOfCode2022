inputFile = open("Day6/Input.txt", "r")
input=inputFile.readline()
inputFile.close()
i=0
read=""
foundPart1=False
while True:
    c=input[i]
    if not foundPart1:
        if len(read)==4:
            foundPart1=True
            print("Part 1 : "+str(i))
    if c in read:
        read=read[(read.index(c)+1):len(read)]
        read+=c
    else:
        read+=c
        if len(read)==14:
            break
    i+=1
print("part 2 : "+str(i+1))