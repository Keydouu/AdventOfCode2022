#sleepy af sorry if my code is more garbage than usual
import re
def isIntervalOneWithinTheSecond(a,b,x,y):
    if a<=x and b>=y:
        return True
    return False

inputFile = open("Day4/Input.txt", "r")
input=inputFile.readline() 
partOneOutput=0
partTwoOutput=0
while input!='':
    intervals=re.split(r',|-',input)
    a=int(intervals[0])
    b=int(intervals[1])
    x=int(intervals[2])
    y=int(intervals[3])
    if isIntervalOneWithinTheSecond(a,b,x,y):
        partOneOutput+=1
        partTwoOutput+=1
    elif isIntervalOneWithinTheSecond(x,y,a,b):
        partOneOutput+=1
        partTwoOutput+=1
    elif (a<=x<=b)or(a<=y<=b)or(x<=a<=y)or(x<=b<=y):
        partTwoOutput+=1
    input=inputFile.readline()
print(partOneOutput)
print(partTwoOutput)
inputFile.close()