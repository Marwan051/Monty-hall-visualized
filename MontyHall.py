import random


def startgame(num, dnum, mode, losstowinratio):
    # make the hashmap for the simulated doors
    game = dict()
    choice = 0
    for i in range(0, num):
        for j in range(0, dnum):
            game[j + 1] = 0
        # add the winning value
        game.update({(int)(random.random() * dnum): 1})
        # choose a random value to simulate first choice
        choice = (int)((random.random() * dnum))
        if mode == 1:  # no change case
            if game.get(choice) == 1:
                losstowinratio[1] += 1
            else:
                losstowinratio[0] += 1

        elif mode == 2:  # always change case
            if game.get(choice) == 1:
                losstowinratio[0] += 1
            else:
                losstowinratio[1] += 1

        elif 3:  # control case(changing or no changing randomly)
            ranchoice = (int)(random.random() * 2 + 1)
            if ranchoice == 1:
                if game.get(choice) == 1:
                    losstowinratio[1] += 1
                else:
                    losstowinratio[0] += 1

            else:
                if game.get(choice) == 1:
                    losstowinratio[0] += 1
                else:
                    losstowinratio[1] += 1

        game.clear()


losstowinratio = [
    0,
    0,
]  # array for the results (first value is losses the second is wins)
sampleSize = 1  # min is 1
numOfDoors = 3  # min is 3
mode = 1  # modes are (1:no change,2:always change,3:Control-random change-)
startgame(sampleSize, numOfDoors, mode, losstowinratio)  # running the simulation
print(
    "Losses: " + str(losstowinratio[0]) + "\nWins: " + str(losstowinratio[1])
)  # printing the results
