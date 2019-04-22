import matplotlib.pyplot as plt
import csv

FILENAME = "benchmarks.txt"

def readCsv(filename):
    with open(filename) as f:
        reader = csv.reader(f)
        return [list(map(int, line)) for line in list(reader)]        

(x, iterative, recursive) = readCsv(FILENAME)

plt.plot(x, iterative, label="Iterativ")
plt.plot(x, recursive, label="Rekursiv")

plt.title("Time execution of recursive and iterative algorithm")
plt.xlabel("Size of the string\nBenchmarks tested on the 2^n values with 1 <= n <= 16")
plt.ylabel("Time (in ns)")
plt.legend(loc="upper left")
plt.grid()

plt.savefig("graphic.png")
plt.show()