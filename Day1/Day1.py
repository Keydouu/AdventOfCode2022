inputFile = open("Day1/Input.txt", "r")
top=[0,0,0]
current=0
while True:
    input=inputFile.readline()
    if  input=="\n":
        if current>top[0]:
            top[0]=current
            if current>top[1]:
                top[0]=top[1]
                top[1]=current
                if current>top[2]:
                    top[1]=top[2]
                    top[2]=current
        current=0
    elif input=='':
        break
    else :
        current+=int(input)
print("top 1 : "+str(top[2]))
print("sum of top 3 : "+str(sum(top)))
inputFile.close()