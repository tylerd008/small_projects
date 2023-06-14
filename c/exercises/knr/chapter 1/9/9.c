#include <stdio.h>

int main(){
    int c, lc;

    lc = 0;

    while((c = getchar()) != EOF){
        if (c = ' '){
            lc = c;
        } else if (c != ' ' && lc == ' '){
            putchar(' ');
            putchar(c);
        } else{
            putchar(c);
        }
    }
}