#include <stdio.h>
#include <limits.h>

/*
 * Print the bound given in limits.h
 */
void printLimitsH(){
    printf("\nPredefined limits in limits.h\n");
    printf("CHAR_MIN   :   %d\n", CHAR_MIN);
    printf("CHAR_MAX   :   %d\n", CHAR_MAX);
    printf("UCHAR_MAX  :   %d\n", UCHAR_MAX);
    printf("SHRT_MIN   :   %d\n", SHRT_MIN);
    printf("SHRT_MAX   :   %d\n", SHRT_MAX);
    printf("USHRT_MAX  :   %d\n", (unsigned short) USHRT_MAX);
    printf("INT_MIN    :   %d\n", INT_MIN);
    printf("INT_MAX    :   %d\n", INT_MAX);
    printf("UINT_MAX   :   %u\n", (unsigned int) UINT_MAX);
    printf("LONG_MIN   :   %ld\n", (long) LONG_MIN);
    printf("LONG_MAX   :   %ld\n", (long) LONG_MAX);
    printf("ULONG_MAX  :   %lu\n", (unsigned long) ULONG_MAX);
    printf("SCHAR_MIN  :   %d\n", SCHAR_MIN);
    printf("SCHAR_MAX  :   %d\n", SCHAR_MAX);
    printf("SHRT_MIN   :   %d\n", SHRT_MIN);
    printf("SHRT_MAX   :   %d\n", SHRT_MAX);
    printf("UCHAR_MAX  :   %d\n", UCHAR_MAX);
}


/* =============================
 * Search the bound of each type
 * =============================
 */
void guessChar(){
    char i = 1;
    int prev;
    do {
        prev = i;
        i *= 2;
    } while(i >= 0);
    printf("CHAR: %d %d\n", i, ~i);
}

void guessShort(){
    char i = 1;
    int prev;
    do {
        prev = i;
        i *= 2;
    } while(i >= 0);
    printf("SHRT: %d %d\n", i, ~i);
}

void guessInt(){
    int i = 1;
    int prev;
    do {
        prev = i;
        i *= 2;
    } while(i >= 0);
    printf("INT: %d %d\n", i, ~i);
}

void guessLong(){
    long i = 1;
    int prev;
    do {
        prev = i;
        i *= 2;
    } while(i >= 0);
    printf("LONG: %ld %ld\n", i, ~i);
}

int main(){
    guessChar();
    guessShort();
    guessInt();
    guessLong();
    printLimitsH();
    return 0;
}
