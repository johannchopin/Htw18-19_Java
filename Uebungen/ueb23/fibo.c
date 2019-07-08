#include <stdio.h>
#include <stdlib.h>

/*
 * Return the n first numbers of the fibonacci's suit
 */
int fibo(int n){
    int first = 0, second = 1, next, c;

    printf("Erste %d-Begriffe der Fibonacci-Serie sind:\n", n);

    for (c = 0; c < n; c++)
    {
        if (c <= 1)
            next = c;
        else
        {
            next = first + second;
            first = second;
            second = next;
        }

        printf("%d\n", next);
    }

    return 0;
}

int main(int argc, char *argv[]){
    char *nptr;
    int n = strtol(argv[1], &nptr, 10);

    if(n < 0){
        printf("Arg must be an integer and > 0.\n");
        return -1;
    }

    fibo(n);

    return 0;
}
