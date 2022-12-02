def getScore(line):
    elf=ord(line[0])
    me=ord(line[2])
    score = me-87 #score from the shape i choose
    #next we calculate score from win / loss / draw
    if me-elf==23 : #draw
        return (score + 3)
    elif me-elf==24 or me-elf==21:  #win
        return score+6
    return score    #loss is me-elf==22 or me-elf==25

inputFile = open("Day2/Input.txt", "r")
totalScore=0
input=inputFile.readline() 
while input!='':
    totalScore+=getScore(input)
    input=inputFile.readline() 
print(totalScore)
