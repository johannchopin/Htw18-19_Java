#include <stdio.h>
#include <stdlib.h>

void ausgabeBeleg(double nettopreis){
    double mwst = nettopreis / 20;
    double bruttopreis = nettopreis + mwst;
    double skonto = bruttopreis * 0.02;
    double rechnungbetrag = bruttopreis * 0.98;

    printf("Nettopreis               Euros %6.2f\n", nettopreis);
    printf("+ 20%% MwSt               Euros %6.2f\n", mwst);
    printf("=====================================\n");
    printf("Bruttopreis              Euros %6.2f\n", bruttopreis);
    printf("- 2%% Skonto              Euros %6.2f\n", skonto);
    printf("=====================================\n");
    printf("Rechnungbetrag           Euros %6.2f\n", rechnungbetrag);
}

int main(int argc, char* argv[]){
    char *nptr;
    if(argc != 2){   
        printf("Just one positive number must be provided\n");
        exit(2);
    }
    double n = strtod(argv[1], &nptr);
    if(n < 0){
        printf("Arg must be an integer and > 0.\n");
        exit(1);
    }
    ausgabeBeleg(n);
    return 0;
}
