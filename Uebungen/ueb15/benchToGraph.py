import matplotlib.pyplot as plt
import csv

FILENAME = "benchmarks.txt"

def readCsv(filename):
    with open(filename) as f:
        reader = csv.reader(f)
        return [list(map(int, line)) for line in list(reader)]        

lines = readCsv(FILENAME)

x = plt.plot(lines[1], label="Iterativ")
y = plt.plot(lines[2], label="Rekursiv")

plt.title("Time execution of recursive and iterative algorithm")
plt.xlabel("Size of the string (2^n)")
plt.ylabel("Time (in ns)")
plt.legend(loc="upper left")
plt.grid()

plt.show()