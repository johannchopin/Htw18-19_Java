#include <stdio.h>
#include <stdlib.h>


#define BILL_LINE_SEPARATOR "================================================================="


char * printBillLine(char * lineTitle, float value, int withLineSeparator)
{
    printf("%-15s %10s EURO %6.2f\n", lineTitle, "", value);

   if(withLineSeparator) {
       printf("%.*s\n", 38, BILL_LINE_SEPARATOR);
   }
}


void ausgabeBeleg(double nettopreis){
    double mwst = nettopreis * 0.2;
    double bruttopreis = nettopreis + mwst;
    double skonto = bruttopreis * 0.02;
    double rechnungbetrag = bruttopreis * 0.98;

    printBillLine("Nettopreis", nettopreis, 0);
    printBillLine("+ 20% MwSt", mwst, 1);
    printBillLine("Bruttopreis", bruttopreis, 0);
    printBillLine("- 2% Skonto", skonto, 1);
    printBillLine("Rechnungsbetrag", rechnungbetrag, 0);
}

double argvToLong(int argc, char** argv){
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
}
 
int main(int argc, char* argv[]){
    ausgabeBeleg(atof(argv[1]));
    return 0;
}
