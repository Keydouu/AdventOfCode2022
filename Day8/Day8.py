inputFile = open("Day8/Input.txt", "r")
input=inputFile.readline() 
treesList=[]
while input!='':
    treesList.append(input)
    input=inputFile.readline()
inputFile.close()
maxL=len(treesList[0])-1#removing the fucking \n at the end of the string
maxH=len(treesList)
total=0
max=0
# Full retard mode, full loops, brute forcing because I don't have much time I may try to fix it at a later date (next month)
for i in range(maxH):
    for j in range(maxL):
        newMax=0
        a=0
        k=ord(treesList[i][j])
        visibility=4
        for x in range(i-1,-1,-1):
            newMax+=1
            if k<=ord(treesList[x][j]):
                visibility-=1
                break
        for x in range(j-1,-1,-1):
            a+=1
            if k<=ord(treesList[i][x]):
                visibility-=1
                break
        newMax*=a
        a=0
        for x in range(i+1,maxH):
            a+=1
            if k<=ord(treesList[x][j]):
                visibility-=1
                break
        newMax=newMax*a
        a=0
        for x in range(j+1,maxL):
            a+=1
            if k<=ord(treesList[i][x]):
                visibility-=1
                break
        newMax*=a
        if visibility>0:
            total+=1
        if newMax>max:
            max=newMax
print(total)
print(max)