def getPrio(letter):
    if ord(letter) > 96 :
        return (ord(letter)-96)
    else :
        return (ord(letter)-38)

def sortLine(line):
    line=line[0:len(line)-1]#removing the /n
    return ''.join(sorted(set(line)))

def getCommonLetter(line1, line2, line3):
    line1=sortLine(line1)
    line2=sortLine(line2)
    line3=sortLine(line3)
    i=0
    j=0
    for c in line1 :
        while True:#because there is 100% a common letter ( change it to "while i < len(line2)" otherwise )
            if line2[i]==c:
                while True:#assuming there is 100% a common letter ( change it to "while j < len(line3)" otherwise )
                    if line3[j]==c:
                        return c
                    elif line3[j]>c:
                        break
                    j+=1
            elif line2[i]>c:
                break
            i+=1
    #tried to write an optimised code but execution time is longer than brute force lol
inputFile = open("Day3/Input.txt", "r")
sumOfPriorities=0
input=inputFile.readline() 
while input!='':
    input2=inputFile.readline() 
    input3=inputFile.readline() 
    sumOfPriorities+=getPrio(getCommonLetter(input, input2, input3))
    input=inputFile.readline() 
print(sumOfPriorities)
inputFile.close()