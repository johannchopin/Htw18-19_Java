compile: ausgabenbeleg.c fibo.c myLimits.c
	gcc ausgabenbeleg.c -o ausgabenbeleg
	gcc fibo.c -o fibo
	gcc myLimits.c -o myLimits

clear:
	rm ausgabenbeleg myLimits fibo

test: compile
	echo "\n=== 1. Aufgabe ===\n"
	./ausgabenbeleg 100
	echo "\n=== 2. Aufgabe ===\n"
	./fibo 5
	echo "\n=== 3. Aufgabe ===\n"
	./myLimits
