#include <stdio.h>
#include <stdlib.h>

int fibo(int n){
    if(n <= 1)
        return n;
    int a = 0, b = 1, c;
    int aux;
    while(n-- >= 2){
        c = a + b;
        a = b;
        b = c;
    }
    return c;
}

int main(int argc, char *argv[]){
    char *nptr;
    int n = strtol(argv[1], &nptr, 10);
    if(n < 0){
        printf("Arg must be an integer and > 0.\n");
        return -1;
    }
    printf("%d\n", fibo(n));
    return 0;
}
