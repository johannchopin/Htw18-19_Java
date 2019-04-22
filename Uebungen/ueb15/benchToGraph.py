import matplotlib.pyplot as plt
import csv

FILENAME = "benchmarks.txt"

def readCsv(filename):
    with open(filename) as f:
        reader = csv.reader(f)
        return [list(map(int, line)) for line in list(reader)]        

lines = readCsv(FILENAME)

iterative = plt.plot(lines[0], lines[1], label="Iterativ")
recursive = plt.plot(lines[0], lines[2], label="Rekursiv")

plt.title("Time execution of recursive and iterative algorithm")
plt.xlabel("Size of the string\nBenchmarks tested on the 2^n values with 1 <= n <= 16")
plt.ylabel("Time (in ns)")
plt.legend(loc="upper left")
plt.grid()

plt.savefig("graphic.png")
plt.show()