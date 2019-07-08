#include <stdio.h>
#include <stdlib.h>

/*
 * Print the fibonnaci numbers until n
 */
int fibo(int n){
    int first = 0, second = 1, next, c;
    printf("Erste %d-Begriffe der Fibonacci-Serie sind:\n", n);

    printf("0\n");
    if (c >= 1)
        printf("1\n");
        
    for (c = 2; c < n; c++){
        next = first + second;
        first = second;
        second = next;

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
    printf("Returned: %d\n", fibo(n));
    return 0;
}
