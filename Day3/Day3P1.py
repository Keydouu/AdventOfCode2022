def getPrio(letter):
    if ord(letter) > 96 :
        return (ord(letter)-96)
    else :
        return (ord(letter)-38)

def getCommonLetter(line):
    line=line[0:len(line)-1]#removing the /n
    halfIndex = int(len(line)/2)
    firstHalf=line[0 : halfIndex]
    secondHalf=line[halfIndex : len(line)]
    for c in firstHalf:
        if c in secondHalf:
            return c

inputFile = open("Day3/Input.txt", "r")
sumOfPriorities=0
input=inputFile.readline() 
while input!='':
    sumOfPriorities+=getPrio(getCommonLetter(input))
    input=inputFile.readline() 
print(sumOfPriorities)
inputFile.close()