def getScore(line):
    elf=ord(line[0])-64 # 1 for rock, 2 for paper, 3 for scissors
    score = (ord(line[2])-88)*3 #points from win / loss / draw
    #next we add points from the chosen shape
    if score==3 : #draw
        return (score + elf) #same choice as elf so same points
    elif score==6: #win
        if elf==3: #if elf choose scissors
            return score+1 #I choose rock
        else :
            return score+elf+1 #I choose next one ( if elf took rock i take paper, if elf choose paper i choose paper i choose scissor) 
    else : #loss ( same logic as win)
        if elf==1:
            return 3
        else :
            return elf-1

inputFile = open("Day2/Input.txt", "r")
totalScore=0
input=inputFile.readline() 
while input!='':
    totalScore+=getScore(input)
    input=inputFile.readline() 
print(totalScore)
