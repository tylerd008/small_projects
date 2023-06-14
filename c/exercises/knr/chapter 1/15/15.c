#include <stdio.h>

#define LOWER 0
#define UPPER 300
#define STEP 20

float fToC(int fahr); 

int main(){
    int fahr;

    for (fahr = LOWER; fahr <= UPPER; fahr = fahr + STEP){
        printf("%3d %6.1f\n", fahr, fToC(fahr));
    }

    return 0;
}

float fToC(int fahr){
    return (5.0/9.0)*(fahr-32);
}