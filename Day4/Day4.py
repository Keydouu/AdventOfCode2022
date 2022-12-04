#sleepy af sorry if my code is more garbage than usual
def isIntervalOneWithinTheSecond(a,b,x,y):
    if a<=x and b>=y:
        return True
    return False

inputFile = open("Day4/Input.txt", "r")
input=inputFile.readline() 
partOneOutput=0
partTwoOutput=0
while input!='':
    intervals=input.split(',')
    interval1=intervals[0].split('-')
    interval2=intervals[1].split('-')
    a=int(interval1[0])
    b=int(interval1[1])
    x=int(interval2[0])
    y=int(interval2[1])
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