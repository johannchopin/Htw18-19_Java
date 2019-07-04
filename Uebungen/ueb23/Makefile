compile: ausgabenbeleg.c fibo.c myLimits.c
	gcc ausgabenbeleg.c -o bin/ausgabenbeleg
	gcc fibo.c -o bin/fibo
	gcc myLimits.c -o bin/myLimits

clear:
	rm ausgabenbeleg myLimits fibo

test: compile
	echo "\n=== 1. Aufgabe (input: 100) ===\n"
	bin/ausgabenbeleg 100
	echo "\n=== 2. Aufgabe (input: 5) ===\n"
	bin/fibo 5
	echo "\n=== 3. Aufgabe ===\n"
	bin/myLimits
