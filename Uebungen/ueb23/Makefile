compile: ausgabenbeleg.c fibo.c myLimits.c
	gcc ausgabenbeleg.c -o bin/ausgabenbeleg
	gcc fibo.c -o bin/fibo
	gcc myLimits.c -o bin/myLimits

clear:
	rm bin/*

test: compile
	echo "\n\n=== 1. Aufgabe ===\n"
	bin/ausgabenbeleg 100
	echo "\n\n"
	bin/ausgabenbeleg 50
	echo "\n\n=== 2. Aufgabe (input: 5) ===\n"
	bin/fibo 5
	echo "\n\n=== 2. Aufgabe (input: 13) ===\n"
	bin/fibo 13
	echo "\n\n=== 3. Aufgabe ===\n"
	bin/myLimits
